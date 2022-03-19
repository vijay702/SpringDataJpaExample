package com.fastxpo.bean;

import java.util.Date;

public class Master {
	private Date createdate;
	private Date modifytime;
	private String status;
	private String createby;
	private String modifyby;
	private String channel;
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public String getModifyby() {
		return modifyby;
	}
	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	
	

}
