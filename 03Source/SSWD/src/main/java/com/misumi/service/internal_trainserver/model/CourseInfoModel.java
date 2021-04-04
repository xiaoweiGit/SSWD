package com.misumi.service.internal_trainserver.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CourseInfoModel {
    @ApiModelProperty("课程pk")
    private Integer courseid;

    @ApiModelProperty("课程名称")
    private String coursename;

    @ApiModelProperty("课程时长")
    private String coursetime;

    @ApiModelProperty("限定人数")
    private Integer maxperson;

    @ApiModelProperty("讲师")
    private Integer teacherid;

    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("课程开始日期")
    private Date coursedate;
   // @ApiModelProperty("课程号")
    //private String courseno;
    /**
     *  1 未结束 2，已结束
     */
    @ApiModelProperty("课程结束标记 1 未结束 2，已结束 ")
    private Integer endflag;
    @ApiModelProperty("职级开始范围")
    private Integer rankstart;
    @ApiModelProperty("职级结束范围")
    private Integer rankend;
//    @ApiModelProperty("已报名人数")
//    private Integer regperson;
//    @ApiModelProperty("实到人数")
//    private Integer realregperson;

    @ApiModelProperty("创建人")
    private String createuser;

}
