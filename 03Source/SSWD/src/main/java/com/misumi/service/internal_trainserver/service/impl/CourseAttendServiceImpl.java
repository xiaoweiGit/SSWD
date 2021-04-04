package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.CourseAttendMapper;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAttend;
import com.misumi.service.internal_trainserver.service.CourseAttendService;
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
public class CourseAttendServiceImpl extends ServiceImpl<CourseAttendMapper, CourseAttend> implements CourseAttendService {

    @Resource
    private CourseAttendMapper courseAttendMapper;

    @Override
    public List<CourseAttend> findAll() {
        return  courseAttendMapper.selectList(null
        );
    }

    @Override
    public boolean add(CourseAttend m) {
        return courseAttendMapper.insert(m) == 1
                ? true
                : false;
    }
}
