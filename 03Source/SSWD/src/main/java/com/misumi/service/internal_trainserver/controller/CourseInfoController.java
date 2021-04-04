package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturn;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.model.CourseInfoModel;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.pojo.entity.CourseInfo;
import com.misumi.service.internal_trainserver.pojo.entity.SysUser;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import com.misumi.service.internal_trainserver.service.CourseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
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
@Api(value = "CourseInfo Restful", description = "课程管理模块")
@RestController
@Controller
@RequestMapping("api/courseInfo")
public class CourseInfoController {

    @Resource
    CourseInfoService courseInfoService;

    @Resource
    BaseUserService baseUserService;


    @ApiOperation(value = "查询课程列表", notes = "查询课程列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CourseInfo> list() {
        Map<String, Object> para = new HashMap<>();
        para.put("delstate", 1);
        List<CourseInfo> courseinfoList = courseInfoService.selectByMap(para);
        return courseinfoList;
    }

    @UserAuth
    @ApiOperation(value ="新增课程",notes = "新增课程")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Object add(@RequestBody CourseInfoModel m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        CourseInfo entity = new CourseInfo();
        if (user != null) {
            entity.setCoursename(m.getCoursename());
            entity.setCoursetime(m.getCoursetime());
            entity.setMaxperson(m.getMaxperson());
            entity.setTeacherid(m.getTeacherid());
            entity.setRemark(m.getRemark());
            entity.setDescription(m.getDescription());
            entity.setCoursedate(m.getCoursedate());
            entity.setCreatetime(new Date());
            entity.setCreateuser(user.getSname());
            entity.setLastupdateuser(user.getSname());
            entity.setEndflag(1);//未结束
            entity.setRankstart(m.getRankstart());
            entity.setRankend(m.getRankend());

            courseInfoService.insert(entity);
        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseInfoService.selectById(entity.getCourseid());
    }

    @UserAuth
    @ApiOperation(value = "删除课程", notes = "查询课程列表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int courseid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );
        CourseInfo entity = new CourseInfo();
        if (user != null) {
            entity.setCourseid(courseid);
            entity.setLastupdateuser(user.getSname());
            entity.setDelstate(2);
            boolean rel= courseInfoService.updateById(entity);
            if(!rel)
            {
                ResponseReturnUtils.error(ResponseEnum.RUN_ERROR);
            }
            return  entity.getCourseid();
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }



    @UserAuth
    @ApiOperation(value ="更新课程",notes = "更新课程")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody CourseInfoModel m, @RequestHeader int id) {

        BaseUser user = baseUserService.selectById(id);
        CourseInfo entity = new CourseInfo();
        if (user != null) {
            if (m.getCourseid() > 0) {
                entity.setCourseid(m.getCourseid());
                entity.setCoursename(m.getCoursename());
                entity.setCoursetime(m.getCoursetime());
                entity.setMaxperson(m.getMaxperson());
                entity.setTeacherid(m.getTeacherid());
                entity.setRemark(m.getRemark());
                entity.setCoursedate(m.getCoursedate());
                entity.setDescription(m.getDescription());
                entity.setLastupdateuser(user.getSname());
                entity.setRankstart(m.getRankstart());
                entity.setRankend(m.getRankend());

                courseInfoService.updateById(entity);
            } else {
                return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
            }
        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return courseInfoService.selectById(entity.getCourseid());
    }
}
