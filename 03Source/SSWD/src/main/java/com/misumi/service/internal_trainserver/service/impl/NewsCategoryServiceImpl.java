package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.NewsCategoryMapper;
import com.misumi.service.internal_trainserver.pojo.entity.NewsCategory;
import com.misumi.service.internal_trainserver.service.NewsCategoryService;
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
public class NewsCategoryServiceImpl extends ServiceImpl<NewsCategoryMapper, NewsCategory> implements NewsCategoryService {

    @Resource
    private NewsCategoryMapper newsCategoryMapper;

    @Override
    public List<NewsCategory> findAll() {
        return  newsCategoryMapper.selectList(null
        );
    }

    @Override
    public boolean add(NewsCategory m) {
        return newsCategoryMapper.insert(m) == 1
                ? true
                : false;
    }
}
