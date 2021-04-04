package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAttend;
import com.misumi.service.internal_trainserver.pojo.entity.CourseInfo;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import com.misumi.service.internal_trainserver.service.CourseAttendService;
import com.misumi.service.internal_trainserver.service.CourseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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
@Api(value = "CourseAttend RESTful", description = "出席信息")
@RestController
@Controller
@RequestMapping("api/courseAttend")
public class CourseAttendController {

    @Resource
    CourseAttendService courseAttendService;

    @Resource
    BaseUserService baseUserService;

    @Resource
    CourseInfoService courseInfoService;

    @ApiOperation(value = "查询出席信息", notes = "查询出席信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CourseAttend> list() {
        Map<String, Object> para = new HashMap<>();
        para.put("delstate", 1);
        List<CourseAttend> courseAttendList = courseAttendService.selectByMap(para);
        return courseAttendList;
    }

    @ApiOperation(value ="新增出席信息",notes = "新增出席信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody CourseAttend m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseAttend entity = new CourseAttend();
        if (user != null) {
            CourseInfo course = courseInfoService.selectById(m.getCourseid());
            if(course != null) {
                entity.setCoursename(m.getCoursename());
                entity.setCoursedate(m.getCoursedate());
                entity.setStudentid(m.getStudentid());
                entity.setAttendstate(m.getAttendstate());
                entity.setRemark(m.getRemark());

                courseAttendService.insert(entity);
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseAttendService.selectById(entity.getAttendid());
    }

    @UserAuth
    @ApiOperation(value = "删除出席信息", notes = "删除出席信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int attendid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );
        CourseAttend entity = new CourseAttend();
        if (user != null) {
            return courseAttendService.deleteById(new EntityWrapper<CourseAttend>().eq("attendid",attendid));
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新出席信息",notes = "更新出席信息")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody CourseAttend m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseAttend entity = new CourseAttend();
        if (user != null) {
            CourseInfo course = courseInfoService.selectById(m.getCourseid());
            if(course != null) {
                if (m.getAttendid() > 0) {

                    entity.setCoursename(m.getCoursename());
                    entity.setCoursedate(m.getCoursedate());
                    entity.setStudentid(m.getStudentid());
                    entity.setAttendstate(m.getAttendstate());
                    entity.setRemark(m.getRemark());

                    courseAttendService.insert(entity);
                } else {
                    return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
                }
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseAttendService.selectById(entity.getAttendid());
    }
}
