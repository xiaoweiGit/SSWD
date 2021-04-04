package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.NewsInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface NewsInfoService extends IService<NewsInfo> {
    /**
     * 查询所有新闻
     * @return
     */
    List<NewsInfo> findAll();

    boolean add(NewsInfo m);
}
