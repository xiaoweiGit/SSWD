package com.misumi.service.internal_trainserver.service;

import com.baomidou.mybatisplus.service.IService;
import com.misumi.service.internal_trainserver.pojo.entity.CourseAttachmentinfo;

import java.util.List;

/**
 * <p>
 * 界面附件 服务类
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
public interface CourseAttachmentinfoService extends IService<CourseAttachmentinfo> {
    /**
     * 查询所有附件信息
     * @return
     */
    List<CourseAttachmentinfo> findAll();

    boolean add(CourseAttachmentinfo m);
}
