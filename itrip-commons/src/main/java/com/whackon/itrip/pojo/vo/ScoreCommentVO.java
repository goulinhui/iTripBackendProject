package com.whackon.itrip.pojo.vo;

import java.io.Serializable;
/**
 * <b>爱旅行-服务评分视图对象</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class ScoreCommentVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Float PositionScore;   //查询酒店位置评分
	private Float FacilitiesScore; //查询酒店设施评分
	private Float ServiceScore;   //查询酒店服务评分
	private Float HygieneScore;   //查询酒店卫生评分
	private Float Score;          //查询酒店总评分public Integer getPositionScore() {

	public Float getPositionScore() {
		return PositionScore;
	}

	public void setPositionScore(Float positionScore) {
		PositionScore = positionScore;
	}

	public Float getFacilitiesScore() {
		return FacilitiesScore;
	}

	public void setFacilitiesScore(Float facilitiesScore) {
		FacilitiesScore = facilitiesScore;
	}

	public Float getServiceScore() {
		return ServiceScore;
	}

	public void setServiceScore(Float serviceScore) {
		ServiceScore = serviceScore;
	}

	public Float getHygieneScore() {
		return HygieneScore;
	}

	public void setHygieneScore(Float hygieneScore) {
		HygieneScore = hygieneScore;
	}

	public Float getScore() {
		return Score;
	}

	public void setScore(Float score) {
		Score = score;
	}
}
