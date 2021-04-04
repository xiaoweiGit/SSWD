package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.Coursebody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface CoursebodyService extends IService<Coursebody> {
    /**
     * 查询所有课程计划表体
     * @return
     */
    List<Coursebody> findAll();

    boolean add(Coursebody m);
}
