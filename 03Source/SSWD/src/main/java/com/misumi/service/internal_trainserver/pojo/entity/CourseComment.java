package com.misumi.service.internal_trainserver.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Data
@TableName("course_comment")
public class CourseComment implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("讨论编号pk")
	@TableId(value="commentid", type= IdType.AUTO)
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
    /**
     * 1:未删除 2:已删除
     */
	@ApiModelProperty("删除状态")
	private Integer delstate;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	private Date createtime;
    /**
     * 创建人
     */
	@ApiModelProperty("创建人")
	private String createuser;
    /**
     * 最后修改时间
     */
	@ApiModelProperty("最后修改时间")
	private Date lastupdatetime;
    /**
     * 最后修改人
     */
	@ApiModelProperty("最后修改人")
	private String lastupdateuser;

	@Override
	public String toString() {
		return "CourseComment{" +
			", commentid=" + commentid +
			", coursepk=" + coursepk +
			", coursename=" + coursename +
			", coursedate=" + coursedate +
			", content=" + content +
			", commentdate=" + commentdate +
			", commentstate=" + commentstate +
			", reviewdate=" + reviewdate +
			", reviewuser=" + reviewuser +
			", delstate=" + delstate +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", lastupdatetime=" + lastupdatetime +
			", lastupdateuser=" + lastupdateuser +
			"}";
	}
}
