package com.misumi.service.internal_trainserver.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CourseVerifyCommentModel
{
    @ApiModelProperty("讨论编号pk")
    private Integer commentid;
    /**
     * 单据状态1 未审核 2 已审核
     */
    @ApiModelProperty("评论审核 单据状态1 未审核 2 已审核")
    private Integer commentstate;

    @ApiModelProperty("审核日期")
    private Date reviewdate;

    @ApiModelProperty("审核人（用户名）")
    private String reviewuser;
}
