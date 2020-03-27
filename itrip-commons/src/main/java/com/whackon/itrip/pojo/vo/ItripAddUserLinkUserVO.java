package com.whackon.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>新增常用联系人</b>
 */
public class ItripAddUserLinkUserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String linkUserName;
	private Integer linkIdCardType;
	private String linkIdCard;
	private String linkPhone;
	private Long userId;

	public String getLinkUserName() {
		return linkUserName;
	}

	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}

	public Integer getLinkIdCardType() {
		return linkIdCardType;
	}

	public void setLinkIdCardType(Integer linkIdCardType) {
		this.linkIdCardType = linkIdCardType;
	}

	public String getLinkIdCard() {
		return linkIdCard;
	}

	public void setLinkIdCard(String linkIdCard) {
		this.linkIdCard = linkIdCard;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
