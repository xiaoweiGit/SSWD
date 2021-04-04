package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.SysUser;

import java.util.List;


public interface SysUserService extends IService<SysUser> {


	List<SysUser> findAll();

}
