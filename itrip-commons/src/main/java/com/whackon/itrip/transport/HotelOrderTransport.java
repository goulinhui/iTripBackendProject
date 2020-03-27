package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.HotelOrder;
import com.whackon.itrip.pojo.entity.UserLinkUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/hotelorder/trans")
public interface HotelOrderTransport {
	@PostMapping(value = "/list")
	List<HotelOrder> getHotelListByQuery(@RequestBody HotelOrder query) throws Exception;
	/**
	 * <b>保存订单对象</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/save")
	boolean save(@RequestBody HotelOrder hotelOrder) throws Exception;
	/**
	 * <b>修改对象信息</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/update")
	boolean update(@RequestBody HotelOrder hotelOrder) throws Exception;

	@PostMapping(value = "/id")
	HotelOrder getHotelOrderById(@RequestParam Long orderId) throws Exception;

	@PostMapping(value = "/no")
	HotelOrder getHotelOrderByNo(@RequestParam String orderNo) throws Exception;

	/**
	 * <b>查询常用联系人列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/link")
	List<UserLinkUser> getFindOrderListBYQuery(@RequestBody HotelOrder query) throws Exception;
}
