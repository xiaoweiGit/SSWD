package com.misumi.service.internal_trainserver.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@TableName("coursebody")
public class Coursebody implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("编号pk")
	@TableId(value="coursebodyid", type= IdType.AUTO)
	private Integer coursebodyid;

	@ApiModelProperty("课程编号fk")
	private Integer courseid;

	@ApiModelProperty("报名学生")
	private Integer questionid;

	@ApiModelProperty("报名时间")
	private Date regdate;

	@ApiModelProperty("学习心得")
	private String learnsumup;

	@ApiModelProperty("备注")
	private String remark;


	public Integer getCoursebodyid() {
		return coursebodyid;
	}

	public void setCoursebodyid(Integer coursebodyid) {
		this.coursebodyid = coursebodyid;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public Integer getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getLearnsumup() {
		return learnsumup;
	}

	public void setLearnsumup(String learnsumup) {
		this.learnsumup = learnsumup;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Coursebody{" +
			", coursebodyid=" + coursebodyid +
			", courseid=" + courseid +
			", questionid=" + questionid +
			", regdate=" + regdate +
			", learnsumup=" + learnsumup +
			", remark=" + remark +
			"}";
	}
}
