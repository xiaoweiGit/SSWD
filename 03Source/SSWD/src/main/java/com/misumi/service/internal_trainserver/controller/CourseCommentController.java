package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.model.CourseNewCommentModel;
import com.misumi.service.internal_trainserver.model.CourseReplyCommentModel;
import com.misumi.service.internal_trainserver.model.CourseVerifyCommentModel;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.pojo.entity.CourseComment;
import com.misumi.service.internal_trainserver.pojo.entity.CourseInfo;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import com.misumi.service.internal_trainserver.service.CourseCommentService;
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
@Api(value = "CourseComment RESTful", description = "课程讨论")
@RestController
@Controller
@RequestMapping("api/courseComment")
public class CourseCommentController {

    @Resource
    CourseCommentService courseCommentService;

    @Resource
    BaseUserService baseUserService;

    @Resource
    CourseInfoService courseInfoService;

    @ApiOperation(value = "查询课程讨论", notes = "查询课程讨论")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CourseComment> list() {
        Map<String, Object> para = new HashMap<>();
        para.put("delstate", 1);
        List<CourseComment> courseCommentList = courseCommentService.selectByMap(para);
        return courseCommentList;
    }

    @UserAuth
    @ApiOperation(value ="新增课程讨论",notes = "新增课程讨论")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Object add(@RequestBody CourseNewCommentModel m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseComment entity = new CourseComment();
        if (user != null) {
            CourseInfo course = courseInfoService.selectById(m.getCoursepk());
            if(course != null) {
                entity.setCoursename(course.getCoursename());
                entity.setCoursedate(course.getCoursedate());
                entity.setCoursename(m.getCoursename());
                entity.setContent(m.getContent());
                entity.setCommentdate(new Date());
                entity.setParentid(m.getParentid());
                entity.setDelstate(1);
                entity.setCreatetime(new Date());
                entity.setCreateuser(user.getSname());
                entity.setLastupdateuser(user.getSname());

                courseCommentService.insert(entity);
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseCommentService.selectById(entity.getCommentid());
    }

    @UserAuth
    @ApiOperation(value = "删除课程讨论", notes = "删除课程讨论")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int commentid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );
        CourseComment entity = new CourseComment();
        if (user != null) {
            entity.setCommentid(commentid);
            entity.setLastupdateuser(user.getSname());
            entity.setDelstate(2);
            return courseCommentService.updateById(entity);
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新课程讨论",notes = "更新课程讨论")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody CourseComment m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseComment entity = new CourseComment();
        if (user != null) {
            CourseInfo course = courseInfoService.selectById(m.getCoursepk());
            if(course != null) {
                if (m.getCommentid() > 0) {
                    entity.setCommentid(m.getCommentid());
                    entity.setCoursedate(course.getCoursedate());
                    entity.setCoursename(course.getCoursename());
                    entity.setCoursename(m.getCoursename());
                    entity.setContent(m.getContent());
                    entity.setCommentdate(new Date());
                    entity.setParentid(m.getParentid());
                    entity.setDelstate(1);
                    entity.setLastupdateuser(user.getSname());

                    courseCommentService.updateById(entity);
                } else {
                    return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
                }
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseCommentService.selectById(entity.getCommentid());
    }


    @UserAuth
    @ApiOperation(value ="审核讨论",notes = "审核课程讨论")
    @RequestMapping(value = "verify",method = RequestMethod.POST)
    public Object Verify(@RequestBody CourseVerifyCommentModel m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseComment entity = new CourseComment();
        if (user != null) {
            entity.setReviewdate(new Date());
            entity.setCommentstate(m.getCommentstate());
            entity.setReviewuser(m.getReviewuser());
            entity.setDelstate(1);
            entity.setCreatetime(new Date());
            entity.setCreateuser(user.getSname());
            entity.setLastupdateuser(user.getSname());

            courseCommentService.updateById(entity);

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseCommentService.selectById(entity.getCommentid());
    }
}
