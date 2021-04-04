package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.NewsCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface NewsCategoryService extends IService<NewsCategory> {
    /**
     * 查询所有新闻分类
     * @return
     */
    List<NewsCategory> findAll();

    boolean add(NewsCategory m);
}
