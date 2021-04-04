package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface BaseUserService extends IService<BaseUser> {

    /**
     * 查询所有基本用户
     * @return
     */
    List<BaseUser> findAll();

    boolean add(BaseUser m);
}
