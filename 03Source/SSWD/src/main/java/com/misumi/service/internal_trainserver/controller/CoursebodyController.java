package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.pojo.entity.CourseInfo;
import com.misumi.service.internal_trainserver.pojo.entity.Coursebody;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import com.misumi.service.internal_trainserver.service.CourseInfoService;
import com.misumi.service.internal_trainserver.service.CoursebodyService;
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
 *  前端控制器
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Api(value = "Coursebody RESTful", description = "课程报名表")
@RestController
@Controller
@RequestMapping("api/coursebody")
public class CoursebodyController {

    @Resource
    CoursebodyService coursebodyService;

    @Resource
    BaseUserService baseUserService;

    @Resource
    CourseInfoService courseInfoService;

    @ApiOperation(value = "查询课程计划表", notes = "查询课程计划表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Coursebody> list() {
        Map<String, Object> para = new HashMap<>();
        para.put("delstate", 1);
        List<Coursebody> coursebodyList = coursebodyService.selectByMap(para);
        return coursebodyList;
    }

    @ApiOperation(value ="新增课程计划",notes = "新增课程计划")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody Coursebody m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        Coursebody entity = new Coursebody();
        if (user != null) {
            CourseInfo course = courseInfoService.selectById(m.getCourseid());
            if(course != null) {
                entity.setQuestionid(m.getQuestionid());
                entity.setRegdate(new Date());
                entity.setLearnsumup(m.getLearnsumup());
                entity.setRemark(m.getRemark());

                coursebodyService.insert(entity);
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return coursebodyService.selectById(entity.getCoursebodyid());
    }

    @UserAuth
    @ApiOperation(value = "删除课程计划", notes = "删除课程计划")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int coursebodyid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );
        Coursebody entity = new Coursebody();
        if (user != null) {
            return coursebodyService.deleteById(new EntityWrapper<Coursebody>().eq("coursebodyid",coursebodyid));
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新课程计划",notes = "更新课程计划")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody Coursebody m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        Coursebody entity = new Coursebody();
        if (user != null) {
            CourseInfo course = courseInfoService.selectById(m.getCourseid());
            if(course != null) {
                if (m.getCourseid() > 0) {
                    entity.setQuestionid(m.getQuestionid());
                    entity.setRegdate(new Date());
                    entity.setLearnsumup(m.getLearnsumup());
                    entity.setRemark(m.getRemark());

                    coursebodyService.insert(entity);
                } else {
                    return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
                }
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return coursebodyService.selectById(entity.getCoursebodyid());
    }
}
