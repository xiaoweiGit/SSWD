package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.CourseAnswerMapper;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAnswer;
import com.misumi.service.internal_trainserver.service.CourseAnswerService;
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
public class CourseAnswerServiceImpl extends ServiceImpl<CourseAnswerMapper, CourseAnswer> implements CourseAnswerService {

    @Resource
    private CourseAnswerMapper courseAnswerMapper;

    @Override
    public List<CourseAnswer> findAll() {
        return  courseAnswerMapper.selectList(null
        );
    }

    @Override
    public boolean add(CourseAnswer m) {
        return courseAnswerMapper.insert(m) == 1
                ? true
                : false;
    }
}
