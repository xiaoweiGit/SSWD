package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.model.CourseInfoModel;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAttachmentinfo;
import com.misumi.service.internal_trainserver.pojo.entity.CourseInfo;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import com.misumi.service.internal_trainserver.service.CourseAttachmentinfoService;
import com.misumi.service.internal_trainserver.service.CourseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 界面附件 前端控制器
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Api(value = "CourseAttachmentinfo RESTful", description = "附件信息")
@RestController
@Controller
@RequestMapping("api/courseAttachmentinfo")
public class CourseAttachmentinfoController {

    @Resource
    CourseAttachmentinfoService courseAttachmentinfoService;

    @Resource
    BaseUserService baseUserService;

    @Resource
    CourseInfoService courseInfoService;

    @ApiOperation(value = "查询附件信息", notes = "查询附件信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CourseAttachmentinfo> list() {
        Map<String, Object> para = new HashMap<>();
        para.put("delstate", 1);
        List<CourseAttachmentinfo> courseAttachmentinfoList = courseAttachmentinfoService.selectByMap(para);
        return courseAttachmentinfoList;
    }

    @UserAuth
    @ApiOperation(value ="新增附件信息",notes = "新增附件信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody CourseAttachmentinfo m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseAttachmentinfo entity = new CourseAttachmentinfo();
        if (user != null) {
            CourseInfo course = courseInfoService.selectById(m.getCourseid());
            if(course != null) {
                entity.setAtttype(m.getAtttype());
                entity.setAttname(m.getAttname());
                entity.setUrl(m.getUrl());
                entity.setStatus(m.getStatus());
                entity.setRemark(m.getRemark());
                entity.setDelstate(1);
                entity.setCreatetime(new Date());
                entity.setCreateuser(user.getSname());
                entity.setLastupdateuser(user.getSname());

                courseAttachmentinfoService.insert(entity);
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseAttachmentinfoService.selectById(entity.getAttpk());
    }

    @UserAuth
    @ApiOperation(value = "删除附件信息", notes = "删除附件信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int attpk,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );
        CourseAttachmentinfo entity = new CourseAttachmentinfo();
        if (user != null) {
            entity.setAttpk(attpk);
            entity.setLastupdateuser(user.getSname());
            entity.setDelstate(2);
            return courseAttachmentinfoService.updateById(entity);
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新附件信息",notes = "更新附件信息")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody CourseAttachmentinfo m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseAttachmentinfo entity = new CourseAttachmentinfo();
        if (user != null) {
            CourseInfo course = courseInfoService.selectById(m.getCourseid());
            if(course != null) {
                if (m.getAttpk() > 0) {
                    entity.setAtttype(m.getAtttype());
                    entity.setAttname(m.getAttname());
                    entity.setUrl(m.getUrl());
                    entity.setStatus(m.getStatus());
                    entity.setRemark(m.getRemark());
                    entity.setLastupdateuser(user.getSname());

                    courseAttachmentinfoService.insert(entity);
                } else {
                    return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
                }
            }
        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseAttachmentinfoService.selectById(entity.getAttpk());
    }
}
