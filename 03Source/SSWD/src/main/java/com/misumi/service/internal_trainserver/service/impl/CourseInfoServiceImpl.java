package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.CourseInfoMapper;
import com.misumi.service.internal_trainserver.pojo.entity.CourseInfo;
import com.misumi.service.internal_trainserver.service.CourseInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  课程信息服务实现类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Service
public class CourseInfoServiceImpl extends ServiceImpl<CourseInfoMapper, CourseInfo> implements CourseInfoService {

    @Resource
    private CourseInfoMapper courseInfoMapper;

    @Override
    public List<CourseInfo> findAll() {
        return  courseInfoMapper.selectList(null
        );
    }

    @Override
    public boolean add(CourseInfo m) {
        return courseInfoMapper.insert(m) == 1
                ? true
                : false;
    }
}
