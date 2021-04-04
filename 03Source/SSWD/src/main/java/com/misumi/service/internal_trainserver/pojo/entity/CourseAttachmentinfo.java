package com.misumi.service.internal_trainserver.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 界面附件
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@TableName("course_attachmentinfo")
public class CourseAttachmentinfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("附件编号pk")
	@TableId(value="attpk", type= IdType.AUTO)
	private Integer attpk;

	@ApiModelProperty("课程编号fk")
	private Integer courseid;
    /**
     * 1 视频  2.图片 3, ppt
     */
	@ApiModelProperty("附件类型")
	private Integer atttype;

	@ApiModelProperty("名称")
	private String attname;

	@ApiModelProperty("链接")
	private String url;
    /**
     * 0 发布 1 草稿
     */
	@ApiModelProperty("课程状态")
	private Integer status;

	@ApiModelProperty("备注")
	private String remark;
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


	public Integer getAttpk() {
		return attpk;
	}

	public void setAttpk(Integer attpk) {
		this.attpk = attpk;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public Integer getAtttype() {
		return atttype;
	}

	public void setAtttype(Integer atttype) {
		this.atttype = atttype;
	}

	public String getAttname() {
		return attname;
	}

	public void setAttname(String attname) {
		this.attname = attname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "CourseAttachmentinfo{" +
			", attpk=" + attpk +
			", courseid=" + courseid +
			", atttype=" + atttype +
			", attname=" + attname +
			", url=" + url +
			", status=" + status +
			", remark=" + remark +
			", delstate=" + delstate +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", lastupdatetime=" + lastupdatetime +
			", lastupdateuser=" + lastupdateuser +
			"}";
	}
}
