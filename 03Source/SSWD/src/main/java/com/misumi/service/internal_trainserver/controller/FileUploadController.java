package com.misumi.service.internal_trainserver.controller;

import com.misumi.service.internal_trainserver.storage.StorageFileNotFoundException;
import com.misumi.service.internal_trainserver.storage.StorageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    //@GetMapping("")
    @ApiOperation(value = "查询上传的文件列表", notes = "查询上传的文件列表")
    @RequestMapping(value = "api/files", method = RequestMethod.GET)
    public Object listUploadedFiles() throws IOException {

        return storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "获取文件", notes = "获取文件")
    @RequestMapping(value ="api/files/{filename:.+}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @ApiOperation(value = "上传文件", notes = "上传文件")
    @PostMapping("api/files")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        storageService.store(file);
        return MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                "serveFile",
                storageService.load(file.getOriginalFilename())
                        .getFileName().toString()).build().toString();
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
