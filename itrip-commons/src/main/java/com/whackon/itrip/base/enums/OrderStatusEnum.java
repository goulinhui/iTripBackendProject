package com.whackon.itrip.base.enums;

public enum OrderStatusEnum {
	ORDER_STATUS_PREPAY(0),   //待支付
	ORDER_STATUS_CANCEL(1),   //已取消
	ORDER_STATUS_PAYED(2),   // 支付成功
	ORDER_STATUS_SUCCESS(3), // 已取消
	ORDER_STATUS_COMMENT(4)  //支付金额
	;
	private int code;

	private OrderStatusEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
