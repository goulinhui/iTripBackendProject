package com.whackon.itrip.pojo.vo;

import java.io.Serializable;

public class ItripOrderLinkUserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long linkUserId;
	private String linkUserName;

	public Long getLinkUserId() {
		return linkUserId;
	}

	public void setLinkUserId(Long linkUserId) {
		this.linkUserId = linkUserId;
	}

	public String getLinkUserName() {
		return linkUserName;
	}

	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}
}
