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
@TableName("course_answer")
public class CourseAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("编号pk")
	@TableId(value="qwid", type= IdType.AUTO)
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

	@ApiModelProperty("回答人数")
	private Integer approve;
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

	public String getAnswercontent() {
		return answercontent;
	}

	public void setAnswercontent(String answercontent) {
		this.answercontent = answercontent;
	}
	public Integer getQwid() {
		return qwid;
	}

	public void setQwid(Integer qwid) {
		this.qwid = qwid;
	}

	public Integer getCoursepk() {
		return coursepk;
	}

	public void setCoursepk(Integer coursepk) {
		this.coursepk = coursepk;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Date getCoursedate() {
		return coursedate;
	}

	public void setCoursedate(Date coursedate) {
		this.coursedate = coursedate;
	}

	public Integer getQwpersonid() {
		return qwpersonid;
	}

	public void setQwpersonid(Integer questionid) {
		this.qwpersonid = questionid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getQdate() {
		return qdate;
	}

	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}

	public Integer getAnswerid() {
		return answerid;
	}

	public void setAnswerid(Integer answerid) {
		this.answerid = answerid;
	}

	public Date getAnswerdate() {
		return answerdate;
	}

	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}

	public Integer getApprove() {
		return approve;
	}

	public void setApprove(Integer approve) {
		this.approve = approve;
	}

	public Integer getDelstate() {
		return delstate;
	}

	public void setDelstate(Integer delstate) {
		this.delstate = delstate;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public Date getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	public String getLastupdateuser() {
		return lastupdateuser;
	}

	public void setLastupdateuser(String lastupdateuser) {
		this.lastupdateuser = lastupdateuser;
	}

	@Override
	public String toString() {
		return "CourseAnswer{" +
			", qwid=" + qwid +
			", coursepk=" + coursepk +
			", coursename=" + coursename +
			", coursedate=" + coursedate +
			", qwpersonid=" + qwpersonid +
			", question=" + question +
			", qdate=" + qdate +
			", answerid=" + answerid +
			", answerdate=" + answerdate +
			", approve=" + approve +
			", delstate=" + delstate +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", lastupdatetime=" + lastupdatetime +
			", lastupdateuser=" + lastupdateuser +
			"}";
	}
}
