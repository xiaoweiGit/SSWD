package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.BaseUserMapper;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.service.BaseUserService;
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
public class BaseUserServiceImpl extends ServiceImpl<BaseUserMapper, BaseUser> implements BaseUserService {

    @Resource
    private BaseUserMapper baseUserMapper;

    @Override
    public List<BaseUser> findAll() {
        return  baseUserMapper.selectList(null
        );
    }

    @Override
    public boolean add(BaseUser m) {
        return baseUserMapper.insert(m) == 1
                ? true
                : false;
    }
}
