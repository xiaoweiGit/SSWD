package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAttend;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface CourseAttendService extends IService<CourseAttend> {
    /**
     * 查询所有出席信息
     * @return
     */
    List<CourseAttend> findAll();

    boolean add(CourseAttend m);
}
