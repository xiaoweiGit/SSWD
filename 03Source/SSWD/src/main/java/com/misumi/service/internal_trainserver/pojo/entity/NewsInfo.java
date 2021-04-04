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
@TableName("news_info")
public class NewsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("新闻pk")
	@TableId(value="newid", type= IdType.AUTO)
	private Integer newid;

	@ApiModelProperty("分类fk")
	private Integer categoryid;

	@ApiModelProperty("标题")
	private String newtitile;

	@ApiModelProperty("路径")
	private String url;

	@ApiModelProperty("发布内容")
	private String content;

	@ApiModelProperty("发布状态")
	private Integer newstatus;
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


	public Integer getNewid() {
		return newid;
	}

	public void setNewid(Integer newid) {
		this.newid = newid;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getNewtitile() {
		return newtitile;
	}

	public void setNewtitile(String newtitile) {
		this.newtitile = newtitile;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNewstatus() {
		return newstatus;
	}

	public void setNewstatus(Integer newstatus) {
		this.newstatus = newstatus;
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
		return "NewsInfo{" +
			", newid=" + newid +
			", categoryid=" + categoryid +
			", newtitile=" + newtitile +
			", url=" + url +
			", content=" + content +
			", newstatus=" + newstatus +
			", createtime=" + createtime +
			", lastupdatetime=" + lastupdatetime +
			"}";
	}
}
