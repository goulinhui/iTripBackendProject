package com.whackon.itrip.service.Impl;

import com.whackon.itrip.dao.HotelOrderDao;
import com.whackon.itrip.pojo.entity.HotelOrder;
import com.whackon.itrip.pojo.entity.UserLinkUser;
import com.whackon.itrip.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("hotelOrderService")
@Transactional
public class HotelOrderServiceImpl implements HotelOrderService {
	@Autowired
	private HotelOrderDao hotelOrderDao;

	public List<HotelOrder> getListByQuery(HotelOrder query) throws Exception {
		List<HotelOrder> hotelOrderList = hotelOrderDao.findHotelOrderListByQuery(query);
		if (hotelOrderList != null) {
			return hotelOrderList;
		}
		return new ArrayList<HotelOrder>();
	}
	/**
	 * <b>保存订单对象</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	public boolean save(HotelOrder hotelOrder) throws Exception {
		int count = hotelOrderDao.save(hotelOrder);
		if (count > 0) {
			return true;
		}
		return false;
	}
	/**
	 * <b>修改对象信息</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	public boolean update(HotelOrder hotelOrder) throws Exception {
		int count = hotelOrderDao.update(hotelOrder);
		if (count > 0) {
			return true;
		}
		return false;
	}

	public HotelOrder getHotelOrderById(Long orderId) throws Exception {
		HotelOrder query = new HotelOrder();
		query.setId(orderId);

		List<HotelOrder> hotelOrderList = hotelOrderDao.findHotelOrderListByQuery(query);
		if (hotelOrderList != null && hotelOrderList.size() > 0) {
			return hotelOrderList.get(0);
		}
		return null;
	}

	public HotelOrder getHotelOrderByNo(String orderNo) throws Exception {
		HotelOrder query = new HotelOrder();
		query.setOrderNo(orderNo);

		List<HotelOrder> hotelOrderList = hotelOrderDao.findHotelOrderListByQuery(query);
		if (hotelOrderList != null && hotelOrderList.size() > 0) {
			return hotelOrderList.get(0);
		}
		return null;
	}

	/**
	 * <b>查询常用联系人列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<UserLinkUser> getfindOrderListBYQuery(HotelOrder query) throws Exception {
		List<UserLinkUser> linkUserList = hotelOrderDao.findOrderListBYQuery(query);
		if(linkUserList != null && linkUserList.size()>0){
			return linkUserList;
		}
		return new ArrayList<UserLinkUser>();
	}
}
