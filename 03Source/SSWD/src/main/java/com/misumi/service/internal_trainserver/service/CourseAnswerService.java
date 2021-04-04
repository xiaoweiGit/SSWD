package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAnswer;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface CourseAnswerService extends IService<CourseAnswer> {
    /**
     * 查询所有咨询信息
     * @return
     */
    List<CourseAnswer> findAll();

    boolean add(CourseAnswer m);
}
