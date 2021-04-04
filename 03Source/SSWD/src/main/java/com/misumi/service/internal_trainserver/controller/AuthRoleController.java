package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.pojo.entity.AuthRole;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.service.AuthRoleService;
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
@Api(value = "AuthRole RESTful", description = "用户角色")
@RestController
@Controller
@RequestMapping("api/authRole")
public class AuthRoleController {

    @Resource
    AuthRoleService authRoleService;

    @Resource
    BaseUserService baseUserService;

    @ApiOperation(value = "查询用户角色", notes = "查询用户角色")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AuthRole> list() {
        List<AuthRole> authRoleList = authRoleService.findAll();
        return authRoleList;
    }

    @UserAuth
    @ApiOperation(value ="新增用户角色",notes = "新增用户角色")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody AuthRole m, @RequestHeader int id) {

        BaseUser user = baseUserService.selectById(id);
        AuthRole entity = new AuthRole();
        if (user != null) {
            entity.setRolename(m.getRolename());
            entity.setDescription(m.getDescription());
            entity.setCreatetime(new Date());
            entity.setCreateuser(user.getSname());
            entity.setLastupdateuser(user.getSname());

            authRoleService.insert(entity);
        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return authRoleService.selectById(entity.getRoleid());
    }

    @UserAuth
    @ApiOperation(value = "删除用户角色", notes = "删除用户角色")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int roleid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );
        AuthRole role = authRoleService.selectOne(
                new EntityWrapper<AuthRole>()
                        .eq("roleid", roleid)
        );

        if (user != null && role.getRoleid() != user.getRoleid()) {//不能删除本账号角色
            //删除关联数据（数据库里彻底删除，非改删除状态值）
            baseUserService.deleteById(
                    new EntityWrapper<BaseUser>()
                            .eq("roleid",roleid)
            );

            return authRoleService.deleteById(new EntityWrapper<AuthRole>().eq("roleid",roleid));
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新用户角色",notes = "更新用户角色")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody AuthRole m, @RequestHeader int id) {

        BaseUser user = baseUserService.selectById(id);
        AuthRole entity = new AuthRole();
        if (user != null) {
            if (m.getRoleid() > 0) {
                entity.setRolename(m.getRolename());
                entity.setDescription(m.getDescription());
                entity.setLastupdateuser(user.getSname());

                authRoleService.insert(entity);
            } else {
                return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
            }
        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return authRoleService.selectById(entity.getRoleid());
    }
}
