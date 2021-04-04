package com.misumi.service.internal_trainserver.handler.aop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Log4j2
public class AuthAspect {
    @Resource
    BaseUserService baseUserService;

    @Pointcut("@annotation(com.misumi.service.internal_trainserver.handler.aop.UserAuth)")
    public void verify(){}

    @Before("verify()")
    public void doVerify() throws AuthException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取请求头
        Enumeration<String> enumeration = request.getHeaderNames();
        int id = 0;
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            if (name.equals("id")) {
                id = Integer.parseInt(value);
                break;
            }
        }
        int count = baseUserService.selectCount(
                new EntityWrapper<BaseUser>()
                        .eq("delstate", 1)
                        .eq("uid", id)
        );
        if (count <= 0)
            throw new AuthException("用户身份 验证失败");
    }
}
