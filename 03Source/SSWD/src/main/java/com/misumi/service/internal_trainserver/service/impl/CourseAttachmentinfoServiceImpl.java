package com.misumi.service.internal_trainserver.service.impl;

import com.misumi.service.internal_trainserver.mapper.CourseAttachmentinfoMapper;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAttachmentinfo;
import com.misumi.service.internal_trainserver.service.CourseAttachmentinfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 界面附件 服务实现类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Service
public class CourseAttachmentinfoServiceImpl extends ServiceImpl<CourseAttachmentinfoMapper, CourseAttachmentinfo> implements CourseAttachmentinfoService {

    @Resource
    private CourseAttachmentinfoMapper courseAttachmentinfoMapper;

    @Override
    public List<CourseAttachmentinfo> findAll() {
        return  courseAttachmentinfoMapper.selectList(null
        );
    }

    @Override
    public boolean add(CourseAttachmentinfo m) {
        return courseAttachmentinfoMapper.insert(m) == 1
                ? true
                : false;
    }
}
