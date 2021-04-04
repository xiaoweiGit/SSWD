package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.NewsInfoMapper;
import com.misumi.service.internal_trainserver.pojo.entity.NewsInfo;
import com.misumi.service.internal_trainserver.service.NewsInfoService;
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
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {

    @Resource
    private NewsInfoMapper newsInfoMapper;

    @Override
    public List<NewsInfo> findAll() {
        return  newsInfoMapper.selectList(null
        );
    }

    @Override
    public boolean add(NewsInfo m) {
        return newsInfoMapper.insert(m) == 1
                ? true
                : false;
    }
}
