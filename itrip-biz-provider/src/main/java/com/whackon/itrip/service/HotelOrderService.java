package com.whackon.itrip.service;

import com.whackon.itrip.pojo.entity.HotelOrder;
import com.whackon.itrip.pojo.entity.UserLinkUser;

import java.util.List;

public interface HotelOrderService {
	List<HotelOrder> getListByQuery(HotelOrder query) throws Exception;
	/**
	 * <b>保存订单对象</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	boolean save(HotelOrder hotelOrder) throws Exception;
	/**
	 * <b>修改对象信息</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	boolean update(HotelOrder hotelOrder) throws Exception;

	HotelOrder getHotelOrderById(Long orderId) throws Exception;

	HotelOrder getHotelOrderByNo(String orderNo) throws Exception;
	/**
	 * <b>查询常用联系人列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> 	getfindOrderListBYQuery(HotelOrder query) throws Exception;

}
