package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.AuthLog;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface AuthLogService extends IService<AuthLog> {
    /**
     * 查询所有系统日志
     * @return
     */
    List<AuthLog> findAll();
}
