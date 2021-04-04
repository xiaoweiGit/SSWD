package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.AuthRoleMapper;
import com.misumi.service.internal_trainserver.pojo.entity.AuthRole;
import com.misumi.service.internal_trainserver.service.AuthRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Service
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole> implements AuthRoleService {

    @Resource
    private AuthRoleMapper authRoleMapper;

    @Override
    public List<AuthRole> findAll() {
        return  authRoleMapper.selectList(null
        );
    }

    @Override
    public boolean add(AuthRole m) {
        return authRoleMapper.insert(m) == 1
                ? true
                : false;
    }
}
