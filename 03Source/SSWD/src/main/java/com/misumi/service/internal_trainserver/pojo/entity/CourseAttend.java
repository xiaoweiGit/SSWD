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
@TableName("course_attend")
public class CourseAttend implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("编号pk")
	@TableId(value="attendid", type= IdType.AUTO)
	private Integer attendid;

	@ApiModelProperty("课程编号fk")
	private Integer courseid;

	@ApiModelProperty("课程名称")
	private String coursename;

	@ApiModelProperty("课程开始日期")
	private Date coursedate;

	@ApiModelProperty("学员")
	private Integer studentid;
    /**
     * 1 未出席 2 已出席
     */
	@ApiModelProperty("出席状态")
	private Integer attendstate;

	@ApiModelProperty("备注")
	private String remark;


	public Integer getAttendid() {
		return attendid;
	}

	public void setAttendid(Integer attendid) {
		this.attendid = attendid;
	}

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

	public Date getCoursedate() {
		return coursedate;
	}

	public void setCoursedate(Date coursedate) {
		this.coursedate = coursedate;
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Integer getAttendstate() {
		return attendstate;
	}

	public void setAttendstate(Integer attendstate) {
		this.attendstate = attendstate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CourseAttend{" +
			", attendid=" + attendid +
			", courseid=" + courseid +
			", coursename=" + coursename +
			", coursedate=" + coursedate +
			", studentid=" + studentid +
			", attendstate=" + attendstate +
			", remark=" + remark +
			"}";
	}
}
