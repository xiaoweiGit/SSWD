package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.common.EncrypMD5;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.pojo.entity.AuthRole;
import com.misumi.service.internal_trainserver.pojo.entity.BaseRank;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.service.AuthRoleService;
import com.misumi.service.internal_trainserver.service.BaseRankService;
import com.misumi.service.internal_trainserver.service.BaseUserService;
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
@Api(value = "BaseUser RESTful", description = "基本用户")
@RestController
@Controller
@RequestMapping("api/baseUser")
public class BaseUserController {

    @Resource
    AuthRoleService authRoleService;

    @Resource
    BaseRankService baseRankService;

    @Resource
    BaseUserService baseUserService;

    @ApiOperation(value = "查询基本用户", notes = "查询基本用户")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<BaseUser> list() {
        Map<String, Object> para = new HashMap<>();
        para.put("delstate", 1);
        List<BaseUser> baseUserList = baseUserService.selectByMap(para);
        return baseUserList;
    }

    @UserAuth
    @ApiOperation(value ="新增基本用户",notes = "新增基本用户")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody BaseUser m, @RequestHeader int id) throws Exception{

        BaseUser user = baseUserService.selectById(id);
        BaseUser entity = new BaseUser();
        if (user != null) {
            AuthRole role = authRoleService.selectById(m.getRoleid());
            BaseRank rank = baseRankService.selectById(m.getRankid());
            if(role != null && rank != null) {
                EncrypMD5 md5 = new EncrypMD5();//加密算法

                entity.setSname(m.getSname());
                entity.setDepartentCh(m.getDepartentCh());
                entity.setDepartentJp(m.getDepartentJp());
                entity.setMinistryCh(m.getMinistryCh());
                entity.setMinistryJp(m.getMinistryJp());
                entity.setGroupCh(m.getGroupCh());
                entity.setGroupJp(m.getGroupJp());
                entity.setSex(m.getSex());
                entity.setJoindate(m.getJoindate());
                entity.setLocation(m.getLocation());
                entity.setPosition(m.getPosition());
                entity.setEmail(m.getEmail());
                entity.setPassword(md5.eccryptString(m.getPassword()));//密码加密
                entity.setLabel(m.getLabel());
                entity.setUsetype(m.getUsetype());
                entity.setDelstate(1);
                entity.setCreatetime(new Date());
                entity.setCreateuser(user.getSname());
                entity.setLastupdateuser(user.getSname());

                baseUserService.insert(entity);
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return baseUserService.selectById(entity.getUid());
    }

    @UserAuth
    @ApiOperation(value = "删除基本用户", notes = "删除基本用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int uid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );
        BaseUser entity = new BaseUser();
        if (user != null && user.getUid() != id) {//不能删自己
            entity.setUid(uid);
            entity.setLastupdateuser(user.getSname());
            entity.setDelstate(2);
            return baseUserService.updateById(entity);
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新基本用户",notes = "更新基本用户")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody BaseUser m, @RequestHeader int id) throws Exception{

        BaseUser user = baseUserService.selectById(id);
        BaseUser entity = new BaseUser();
        if (user != null) {
            AuthRole role = authRoleService.selectById(m.getRoleid());
            BaseRank rank = baseRankService.selectById(m.getRankid());
            if(role != null && rank != null) {

                if (m.getUid() > 0) {
                    EncrypMD5 md5 = new EncrypMD5();//加密算法

                    entity.setSname(m.getSname());
                    entity.setDepartentCh(m.getDepartentCh());
                    entity.setDepartentJp(m.getDepartentJp());
                    entity.setMinistryCh(m.getMinistryCh());
                    entity.setMinistryJp(m.getMinistryJp());
                    entity.setGroupCh(m.getGroupCh());
                    entity.setGroupJp(m.getGroupJp());
                    entity.setSex(m.getSex());
                    entity.setJoindate(m.getJoindate());
                    entity.setLocation(m.getLocation());
                    entity.setPosition(m.getPosition());
                    entity.setEmail(m.getEmail());
                    entity.setPassword(md5.eccryptString(m.getPassword()));//密码加密
                    entity.setLabel(m.getLabel());
                    entity.setUsetype(m.getUsetype());
                    entity.setLastupdateuser(user.getSname());

                    baseUserService.insert(entity);
                } else {
                    return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
                }
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return baseUserService.selectById(entity.getUid());
    }
}
