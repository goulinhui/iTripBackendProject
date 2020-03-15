package com.whackon.itrip.pojo.vo;

import java.io.Serializable;

public class SearchHotCityVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer cityId;
	private Integer count;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
