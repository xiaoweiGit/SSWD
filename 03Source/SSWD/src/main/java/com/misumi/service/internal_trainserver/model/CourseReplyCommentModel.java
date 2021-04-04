package com.misumi.service.internal_trainserver.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CourseReplyCommentModel
{
    @ApiModelProperty("讨论编号pk")
    private Integer commentid;

    @ApiModelProperty("回复人id")
    private Integer answerperid;

    @ApiModelProperty("回复人")
    private Integer answerpername;

    @ApiModelProperty("回复内容")
    private String answercontent;

    @ApiModelProperty("回复时间")
    private Date anserdate;
}
