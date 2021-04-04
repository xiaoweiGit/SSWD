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
@TableName("auth_role")
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("编号pk")
	@TableId(value="roleid", type= IdType.AUTO)
	private Integer roleid;

	@ApiModelProperty("角色名称")
	private String rolename;

	@ApiModelProperty("角色描述")
	private String description;
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


	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "AuthRole{" +
			", roleid=" + roleid +
			", rolename=" + rolename +
			", description=" + description +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", lastupdatetime=" + lastupdatetime +
			", lastupdateuser=" + lastupdateuser +
			"}";
	}
}
