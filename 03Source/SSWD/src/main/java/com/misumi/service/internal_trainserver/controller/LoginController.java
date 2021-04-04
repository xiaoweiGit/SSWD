package com.misumi.service.internal_trainserver.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.common.EncrypMD5;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.model.LoginModel;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

public class LoginController {

    @Resource
    BaseUserService baseUserService;

    @ApiOperation(value ="登陆",notes = "登陆")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestBody LoginModel m) throws Exception{
        EncrypMD5 md5 = new EncrypMD5();
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("sanme",m.getSname())
                        .eq("password",md5.eccryptString(m.getPassword()))
        );
        LoginModel entity = new LoginModel();
        if(user != null)
        {
            return baseUserService.selectById(user.getUid());
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }
}
