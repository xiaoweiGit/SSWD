package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.BaseRankMapper;
import com.misumi.service.internal_trainserver.pojo.entity.BaseRank;
import com.misumi.service.internal_trainserver.service.BaseRankService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Service
public class BaseRankServiceImpl extends ServiceImpl<BaseRankMapper, BaseRank> implements BaseRankService {

    @Resource
    private BaseRankMapper baseRankMapper;

    @Override
    public List<BaseRank> findAll() {
        return  baseRankMapper.selectList(null
        );
    }

    @Override
    public boolean add(BaseRank m) {
        return baseRankMapper.insert(m) == 1
                ? true
                : false;
    }
}
