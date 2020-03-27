package com.whackon.itrip.pojo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>返回前端-根据订单Id查询出个人订单详情</b>
 */
public class ItripPersonalHotelOrderVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;//订单ID

	private String orderNo;//订单号

	private Integer orderStatus;//订单状态（0：待支付 1:已取消 2:支付成功 3:已消费）

	private Double payAmount;//支付金额

	private Integer payType;//支付方式:1:支付宝 2:微信 3:到店付

	private Date creationDate;//预定时间

	private Integer bookType;//预定方式（0:WEB端 1:手机端 2:其他客户端）

	private Integer roomPayType;//房间支持的支付方式

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getBookType() {
		return bookType;
	}

	public void setBookType(Integer bookType) {
		this.bookType = bookType;
	}

	public Integer getRoomPayType() {
		return roomPayType;
	}

	public void setRoomPayType(Integer roomPayType) {
		this.roomPayType = roomPayType;
	}
}
