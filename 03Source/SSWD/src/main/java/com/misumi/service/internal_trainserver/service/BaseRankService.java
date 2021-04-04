package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.BaseRank;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface BaseRankService extends IService<BaseRank> {
    /**
     * 查询所有职级
     * @return
     */
    List<BaseRank> findAll();

    boolean add(BaseRank m);
}
