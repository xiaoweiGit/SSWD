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
@TableName("base_user")
public class BaseUser implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("用户IDpk")
	@TableId(value="uid", type= IdType.AUTO)
	private Integer uid;

	@ApiModelProperty("角色编号fk2")
	private Integer roleid;

	@ApiModelProperty("姓名")
	private String sname;

	@ApiModelProperty("事业部")
	private String departentCh;

	@ApiModelProperty("事业部2")
	private String departentJp;

	@ApiModelProperty("部")
	private String ministryCh;

	@ApiModelProperty("部2")
	private String ministryJp;

	@ApiModelProperty("课")
	private String groupCh;

	@ApiModelProperty("课2")
	private String groupJp;

	@ApiModelProperty("性别")
	private Integer sex;

	@ApiModelProperty("入职日期")
	private Date joindate;

	@ApiModelProperty("所在地")
	private String location;

	@ApiModelProperty("职位")
	private String position;

	@ApiModelProperty("职位编号fk1")
	private Integer rankid;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("标签")
	private String label;
    /**
     * 1 老师 2 学生
     */
	@ApiModelProperty("类型")
	private Integer usetype;
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


	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDepartentCh() {
		return departentCh;
	}

	public void setDepartentCh(String departentCh) {
		this.departentCh = departentCh;
	}

	public String getDepartentJp() {
		return departentJp;
	}

	public void setDepartentJp(String departentJp) {
		this.departentJp = departentJp;
	}

	public String getMinistryCh() {
		return ministryCh;
	}

	public void setMinistryCh(String ministryCh) {
		this.ministryCh = ministryCh;
	}

	public String getMinistryJp() {
		return ministryJp;
	}

	public void setMinistryJp(String ministryJp) {
		this.ministryJp = ministryJp;
	}

	public String getGroupCh() {
		return groupCh;
	}

	public void setGroupCh(String groupCh) {
		this.groupCh = groupCh;
	}

	public String getGroupJp() {
		return groupJp;
	}

	public void setGroupJp(String groupJp) {
		this.groupJp = groupJp;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getRankid() {
		return rankid;
	}

	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getUsetype() {
		return usetype;
	}

	public void setUsetype(Integer usetype) {
		this.usetype = usetype;
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
		return "BaseUser{" +
			", uid=" + uid +
			", roleid=" + roleid +
			", sname=" + sname +
			", departentCh=" + departentCh +
			", departentJp=" + departentJp +
			", ministryCh=" + ministryCh +
			", ministryJp=" + ministryJp +
			", groupCh=" + groupCh +
			", groupJp=" + groupJp +
			", sex=" + sex +
			", joindate=" + joindate +
			", location=" + location +
			", position=" + position +
			", rankid=" + rankid +
			", email=" + email +
			", password=" + password +
			", label=" + label +
			", usetype=" + usetype +
			", delstate=" + delstate +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", lastupdatetime=" + lastupdatetime +
			", lastupdateuser=" + lastupdateuser +
			"}";
	}
}
