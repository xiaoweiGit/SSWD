package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.AuthLogMapper;
import com.misumi.service.internal_trainserver.pojo.entity.AuthLog;
import com.misumi.service.internal_trainserver.service.AuthLogService;
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
public class AuthLogServiceImpl extends ServiceImpl<AuthLogMapper, AuthLog> implements AuthLogService {

    @Resource
    private AuthLogMapper authLogMapper;

    @Override
    public List<AuthLog> findAll() {
        return  authLogMapper.selectList(null
        );
    }
}
