package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.AuthRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface AuthRoleService extends IService<AuthRole> {
    /**
     * 查询所有用户角色
     * @return
     */
    List<AuthRole> findAll();

    boolean add(AuthRole m);
}
