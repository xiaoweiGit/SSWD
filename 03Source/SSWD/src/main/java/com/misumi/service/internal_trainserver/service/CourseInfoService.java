package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.CourseInfo;
import com.misumi.service.internal_trainserver.pojo.entity.SysUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface CourseInfoService extends IService<CourseInfo> {

    /**
     * 查询所有课程
     * @return
     */
    List<CourseInfo> findAll();

    boolean add(CourseInfo m);
}
