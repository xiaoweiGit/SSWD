package com.misumi.service.internal_trainserver.controller;


import com.misumi.service.internal_trainserver.pojo.entity.AuthLog;
import com.misumi.service.internal_trainserver.service.AuthLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Api(value = "AuthLog RESTful", description = "系统日志 REST API")
@RestController
@Controller
@RequestMapping("api/authLog")
public class AuthLogController {

    @Resource
    AuthLogService authLogService;

    @ApiOperation(value = "查询系统日志", notes = "查询系统日志")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<AuthLog> list() {
        List<AuthLog> authLogList = authLogService.findAll();
        return authLogList;
    }

}
