package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.HotelOrder;
import com.whackon.itrip.pojo.entity.UserLinkUser;
import com.whackon.itrip.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("hotelOrderTransport")
@RequestMapping("/hotelorder/trans")
public class HotelOrderTransportImpl implements HotelOrderTransport {
	@Autowired
	private HotelOrderService hotelOrderService;

	@PostMapping(value = "/list")
	public List<HotelOrder> getHotelListByQuery(@RequestBody HotelOrder query) throws Exception {
		return hotelOrderService.getListByQuery(query);
	}
	/**
	 * <b>保存订单对象</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/save")
	public boolean save(@RequestBody HotelOrder hotelOrder) throws Exception {
		return hotelOrderService.save(hotelOrder);
	}
	/**
	 * <b>修改对象信息</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/update")
	public boolean update(@RequestBody HotelOrder hotelOrder) throws Exception {
		return hotelOrderService.update(hotelOrder);
	}

	@PostMapping(value = "/id")
	public HotelOrder getHotelOrderById(@RequestParam Long orderId) throws Exception {
		return hotelOrderService.getHotelOrderById(orderId);
	}

	@PostMapping(value = "/no")
	public HotelOrder getHotelOrderByNo(@RequestParam String orderNo) throws Exception {
		return hotelOrderService.getHotelOrderByNo(orderNo);
	}

	/**
	 * <b>查询常用联系人列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/link")
	public List<UserLinkUser> getFindOrderListBYQuery(@RequestBody HotelOrder query) throws Exception {
		return hotelOrderService.getfindOrderListBYQuery(query);
	}
}
