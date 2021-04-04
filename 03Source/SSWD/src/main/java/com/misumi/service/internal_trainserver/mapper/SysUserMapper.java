package com.misumi.service.internal_trainserver.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.misumi.service.internal_trainserver.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface SysUserMapper extends BaseMapper<SysUser> {


	@Select("select * from sys_user")
	List<SysUser> findAllBySelectSQL();

	//======================================================


	List<SysUser> findAll();


}
