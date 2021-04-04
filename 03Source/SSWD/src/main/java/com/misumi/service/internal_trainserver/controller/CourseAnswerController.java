package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturn;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.model.CourseAnswerModel;
import com.misumi.service.internal_trainserver.model.CourseInfoModel;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAnswer;
import com.misumi.service.internal_trainserver.pojo.entity.CourseInfo;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import com.misumi.service.internal_trainserver.service.CourseAnswerService;
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
 *  前端控制器
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Api(value = "CourseAnswer RESTful", description = "咨询信息")
@RestController
@Controller
@RequestMapping("/courseAnswer")
public class CourseAnswerController {

    @Resource
    CourseAnswerService courseAnswerService;

    @Resource
    BaseUserService baseUserService;


    @ApiOperation(value = "咨询列表", notes = "查询咨询列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CourseAnswer> list() {
        Map<String, Object> para = new HashMap<>();
        para.put("delstate", 1);
        List<CourseAnswer> CourseAnswerList = courseAnswerService.selectByMap(para);
        return CourseAnswerList;
    }

    @UserAuth
    @ApiOperation(value ="新增咨询",notes = "新增咨询")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Object add(@RequestBody CourseAnswerModel m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseAnswer entity = new CourseAnswer();
        if (user != null) {
            entity.setCoursepk(m.getCoursepk());
            entity.setCoursename(m.getCoursename());
            entity.setCoursedate(m.getCoursedate());
            entity.setCreatetime(new Date());
            entity.setCreateuser(user.getSname());
            entity.setLastupdateuser(user.getSname());
            entity.setQwpersonid(m.getQwpersonid());
            entity.setQuestion(m.getQuestion());
            entity.setQdate(new Date());
            entity.setDelstate(1);

            courseAnswerService.insert(entity);
        }
        return courseAnswerService.selectById(entity.getQwid());
    }

    @UserAuth
    @ApiOperation(value = "删除咨询", notes = "删除咨询")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int qwid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseAnswer entity = new CourseAnswer();
        if (user != null) {
            entity.setQwid(qwid);
            entity.setLastupdateuser(user.getSname());
            entity.setDelstate(2);
        }
        boolean rel= courseAnswerService.updateById(entity);
        if(!rel)
        {
            ResponseReturnUtils.error(ResponseEnum.RUN_ERROR);
        }
        return  entity.getQwid();
    }



    @UserAuth
    @ApiOperation(value ="更新咨询",notes = "更新咨询")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody CourseAnswerModel m, @RequestHeader int id) {

        BaseUser user = baseUserService.selectById(id);
        CourseAnswer entity = new CourseAnswer();
        if (user != null) {
            if (m.getQwid() > 0) {
                entity.setQwid(m.getQwid());
                entity.setCoursepk(m.getCoursepk());
                entity.setCoursename(m.getCoursename());
                entity.setCoursedate(m.getCoursedate());
                entity.setLastupdateuser(user.getSname());
                entity.setQwpersonid(m.getQwpersonid());
                entity.setQuestion(m.getQuestion());
//                entity.setQdate(new Date());

                courseAnswerService.updateById(entity);
            }
        }
        return courseAnswerService.selectById(entity.getQwid());
    }

    @UserAuth
    @ApiOperation(value ="回复咨询",notes = "回复咨询")
    @RequestMapping(value = "/answer",method = RequestMethod.PUT)
    public Object answer(@RequestBody CourseAnswerModel m, @RequestHeader int id) {

        BaseUser user = baseUserService.selectById(id);
        CourseAnswer entity = new CourseAnswer();
        if (user != null) {
            if (m.getQwid() > 0) {
                entity.setQwid(m.getQwid());
                entity.setLastupdateuser(user.getSname());
                entity.setAnswerid(m.getAnswerid());
                entity.setAnswerdate(new Date());
                entity.setAnswercontent(m.getAnswercontent());

                courseAnswerService.updateById(entity);
            }
        }
        return courseAnswerService.selectById(entity.getQwid());
    }
}
