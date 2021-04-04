package com.misumi.service.internal_trainserver.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("auth_log")
public class AuthLog implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("编号pk")
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;

	@ApiModelProperty("用户IDfk")
	private Integer uid;

	@ApiModelProperty("业务名称")
	private String name;

	@ApiModelProperty("操作类型")
	private Integer type;

	@ApiModelProperty("操作人员")
	private Integer userid;

	@ApiModelProperty("操作结果")
	private String result;

	@ApiModelProperty("操作人员名称")
	private String username;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AuthLog{" +
			", id=" + id +
			", uid=" + uid +
			", name=" + name +
			", type=" + type +
			", userid=" + userid +
			", result=" + result +
			", username=" + username +
			"}";
	}
}
