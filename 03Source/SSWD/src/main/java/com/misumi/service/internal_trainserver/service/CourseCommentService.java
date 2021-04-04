package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.CourseComment;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface CourseCommentService extends IService<CourseComment> {
    /**
     * 查询所有课程讨论
     * @return
     */
    List<CourseComment> findAll();

    boolean add(CourseComment m);
}
