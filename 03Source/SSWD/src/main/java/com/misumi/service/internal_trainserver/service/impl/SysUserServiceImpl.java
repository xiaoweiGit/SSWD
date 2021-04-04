package com.misumi.service.internal_trainserver.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.misumi.service.internal_trainserver.mapper.SysUserMapper;
import com.misumi.service.internal_trainserver.pojo.entity.SysUser;
import com.misumi.service.internal_trainserver.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


	@Resource
	private SysUserMapper sysUserMapper;

	//=====================================业务处理 start=====================================

	@Override
	public List<SysUser> findAll() {
		return sysUserMapper.findAll();
	}
	//=====================================业务处理  end=====================================

	//=====================================私有方法 start=====================================

	//=====================================私有方法  end=====================================

}
