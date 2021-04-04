package com.misumi.service.internal_trainserver.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CourseAnswerModel {
    @ApiModelProperty("编号pk")
    private Integer qwid;

    @ApiModelProperty("课程编号fk")
    private Integer coursepk;

    @ApiModelProperty("课程名称")
    private String coursename;

    @ApiModelProperty("课程开始日期")
    private Date coursedate;

    @ApiModelProperty("报名学生")
    private Integer qwpersonid;

    @ApiModelProperty("问题")
    private String question;

    @ApiModelProperty("提问日期")
    private Date qdate;

    @ApiModelProperty("回复内容")
    private String answercontent;

    @ApiModelProperty("回答人")
    private Integer answerid;

    @ApiModelProperty("回答时间")
    private Date answerdate;

//    @ApiModelProperty("回答人数")
//    private Integer approve;
}
