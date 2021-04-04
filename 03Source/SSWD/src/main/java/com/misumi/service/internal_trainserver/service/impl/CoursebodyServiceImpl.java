package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.CoursebodyMapper;
import com.misumi.service.internal_trainserver.pojo.entity.Coursebody;
import com.misumi.service.internal_trainserver.service.CoursebodyService;
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
public class CoursebodyServiceImpl extends ServiceImpl<CoursebodyMapper, Coursebody> implements CoursebodyService {

    @Resource
    private CoursebodyMapper coursebodyMapper;

    @Override
    public List<Coursebody> findAll() {
        return  coursebodyMapper.selectList(null
        );
    }

    @Override
    public boolean add(Coursebody m) {
        return coursebodyMapper.insert(m) == 1
                ? true
                : false;
    }
}
