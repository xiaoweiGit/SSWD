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
@TableName("base_rank")
public class BaseRank implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("职级pk")
	@TableId(value="rankid", type= IdType.AUTO)
	private Integer rankid;

	@ApiModelProperty("职级名称")
	private String rankname;

	@ApiModelProperty("序号")
	private Integer rankno;

	@ApiModelProperty("备注")
	private String remark;
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


	public Integer getRankid() {
		return rankid;
	}

	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}

	public String getRankname() {
		return rankname;
	}

	public void setRankname(String rankname) {
		this.rankname = rankname;
	}

	public Integer getRankno() {
		return rankno;
	}

	public void setRankno(Integer rankno) {
		this.rankno = rankno;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "BaseRank{" +
			", rankid=" + rankid +
			", rankname=" + rankname +
			", rankno=" + rankno +
			", remark=" + remark +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", lastupdatetime=" + lastupdatetime +
			", lastupdateuser=" + lastupdateuser +
			"}";
	}
}
