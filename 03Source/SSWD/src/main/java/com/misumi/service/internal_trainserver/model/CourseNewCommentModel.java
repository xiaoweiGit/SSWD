package com.misumi.service.internal_trainserver.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import  lombok.Data;

import java.util.Date;

@Data
public class CourseNewCommentModel {

    @ApiModelProperty("讨论编号pk")
    private Integer commentid;

    @ApiModelProperty("父id")
    private Integer parentid;

    @ApiModelProperty("课程编号fk")
    private Integer coursepk;

    @ApiModelProperty("课程名称")
    private String coursename;

    @ApiModelProperty("课程开始日期")
    private Date coursedate;

    @ApiModelProperty("评论人id")
    private Integer commentperid;

    @ApiModelProperty("评论人")
    private String commentpername;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("评论时间")
    private Date commentdate;

    /**
     * 单据状态1 未审核 2 已审核
     */
    @ApiModelProperty("评论审核")
    private Integer commentstate;

    @ApiModelProperty("审核日期")
    private Date reviewdate;

    @ApiModelProperty("审核人（用户名）")
    private String reviewuser;
}

