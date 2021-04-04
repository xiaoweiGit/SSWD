package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.CourseCommentMapper;
import com.misumi.service.internal_trainserver.pojo.entity.CourseComment;
import com.misumi.service.internal_trainserver.service.CourseCommentService;
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
public class CourseCommentServiceImpl extends ServiceImpl<CourseCommentMapper, CourseComment> implements CourseCommentService {

    @Resource
    private CourseCommentMapper courseCommentMapper;

    @Override
    public List<CourseComment> findAll() {
        return  courseCommentMapper.selectList(null
        );
    }

    @Override
    public boolean add(CourseComment m) {
        return courseCommentMapper.insert(m) == 1
                ? true
                : false;
    }
}
