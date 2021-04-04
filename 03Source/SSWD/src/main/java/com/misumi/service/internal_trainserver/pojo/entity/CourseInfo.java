package com.misumi.service.internal_trainserver.pojo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("courseInfo")
public class CourseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("课程pk")
	@TableId(value="courseid", type= IdType.AUTO)
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
    /**
     * 0 发布 1 草稿
     */
	@ApiModelProperty("课程状态 0 发布 1 草稿")
	private Integer status;
	@ApiModelProperty("课程开始日期")
	private Date coursedate;
	@ApiModelProperty("课程号")
	private String courseno;
    /**
     *  1 未结束 2，已结束
     */
	@ApiModelProperty("课程结束标记 1 未结束 2，已结束 ")
	private Integer endflag;
	@ApiModelProperty("职级开始范围")
	private Integer rankstart;
	@ApiModelProperty("职级结束范围")
	private Integer rankend;
    /**
     * 单据状态1 未审核 2 已审核 
     */
	@ApiModelProperty("评论审核 单据状态1 未审核 2 已审核  ")
	private Integer commentstate;
	@ApiModelProperty("审核日期")
	private Date reviewdate;
	@ApiModelProperty("审核人（用户名）")
	private String reviewuser;
	@ApiModelProperty("打分")
	private Integer star;
	@ApiModelProperty("已报名人数")
	private Integer regperson;
	@ApiModelProperty("实到人数")
	private Integer realregperson;
    /**
     * 1:未删除 2:已删除
     */
	@ApiModelProperty("删除状态 1:未删除 2:已删除")
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
	@ApiModelProperty("最后更新人")
	private String lastupdateuser;


	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursetime() {
		return coursetime;
	}

	public void setCoursetime(String coursetime) {
		this.coursetime = coursetime;
	}

	public Integer getMaxperson() {
		return maxperson;
	}

	public void setMaxperson(Integer maxperson) {
		this.maxperson = maxperson;
	}

	public Integer getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Integer questionid) {
		this.teacherid = questionid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCoursedate() {
		return coursedate;
	}

	public void setCoursedate(Date coursedate) {
		this.coursedate = coursedate;
	}

	public String getCourseno() {
		return courseno;
	}

	public void setCourseno(String courseno) {
		this.courseno = courseno;
	}

	public Integer getEndflag() {
		return endflag;
	}

	public void setEndflag(Integer endflag) {
		this.endflag = endflag;
	}

	public Integer getRankstart() {
		return rankstart;
	}

	public void setRankstart(Integer rankstart) {
		this.rankstart = rankstart;
	}

	public Integer getRankend() {
		return rankend;
	}

	public void setRankend(Integer rankend) {
		this.rankend = rankend;
	}

	public Integer getCommentstate() {
		return commentstate;
	}

	public void setCommentstate(Integer commentstate) {
		this.commentstate = commentstate;
	}

	public Date getReviewdate() {
		return reviewdate;
	}

	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}

	public String getReviewuser() {
		return reviewuser;
	}

	public void setReviewuser(String reviewuser) {
		this.reviewuser = reviewuser;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Integer getRegperson() {
		return regperson;
	}

	public void setRegperson(Integer regperson) {
		this.regperson = regperson;
	}

	public Integer getRealregperson() {
		return realregperson;
	}

	public void setRealregperson(Integer realregperson) {
		this.realregperson = realregperson;
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
		return "CourseInfo{" +
			", courseid=" + courseid +
			", coursename=" + coursename +
			", coursetime=" + coursetime +
			", maxperson=" + maxperson +
			", teacherid=" + teacherid +
			", remark=" + remark +
			", description=" + description +
			", status=" + status +
			", coursedate=" + coursedate +
			", courseno=" + courseno +
			", endflag=" + endflag +
			", rankstart=" + rankstart +
			", rankend=" + rankend +
			", commentstate=" + commentstate +
			", reviewdate=" + reviewdate +
			", reviewuser=" + reviewuser +
			", star=" + star +
			", regperson=" + regperson +
			", realregperson=" + realregperson +
			", delstate=" + delstate +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", lastupdatetime=" + lastupdatetime +
			", lastupdateuser=" + lastupdateuser +
			"}";
	}
}
