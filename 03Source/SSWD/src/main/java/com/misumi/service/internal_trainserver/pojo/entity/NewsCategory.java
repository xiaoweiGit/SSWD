package com.misumi.service.internal_trainserver.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@TableName("news_category")
public class NewsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("分类pk")
	@TableId(value="categoryid", type= IdType.AUTO)
	private Integer categoryid;

	@ApiModelProperty("分类名称")
	private String categoryname;

	@ApiModelProperty("排序号")
	private Integer serino;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	private Date createtime;
    /**
     * 最后修改时间
     */
	@ApiModelProperty("最后修改时间")
	private Date lastupdatetime;


	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getSerino() {
		return serino;
	}

	public void setSerino(Integer serino) {
		this.serino = serino;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	@Override
	public String toString() {
		return "NewsCategory{" +
			", categoryid=" + categoryid +
			", categoryname=" + categoryname +
			", serino=" + serino +
			", createtime=" + createtime +
			", lastupdatetime=" + lastupdatetime +
			"}";
	}
}
