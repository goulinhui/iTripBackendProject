package com.whackon.itrip.controller;

import com.whackon.itrip.base.controller.BaseController;
import com.whackon.itrip.base.enums.OrderStatusEnum;
import com.whackon.itrip.base.pojo.vo.ResponseDto;
import com.whackon.itrip.pojo.entity.*;
import com.whackon.itrip.pojo.vo.*;
import com.whackon.itrip.transport.HotelOrderTransport;
import com.whackon.itrip.transport.HotelRoomTransport;
import com.whackon.itrip.transport.HotelTransport;
import com.whackon.itrip.transport.UserTransport;
import com.whackon.itrip.util.HotelOrderNoCreator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>爱旅行-主业务酒店订单模块控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("hotelOrderController")
@RequestMapping("/biz/api/hotelorder")
public class HotelOrderController extends BaseController {
	@Autowired
	private HotelTransport hotelTransport;
	@Autowired
	private HotelRoomTransport hotelRoomTransport;
	@Autowired
	private HotelOrderTransport hotelOrderTransport;
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getpreorderinfo")
	public ResponseDto<Object> getPreOrderInfo(@RequestBody ValidateRoomStoreVO validateRoomStoreVO) throws Exception {
		RoomStoreVO roomStoreVO = new RoomStoreVO();

		// 根据 hotelId 查询对应的 Hotel 对象
		Hotel hotel = hotelTransport.getHotelById(validateRoomStoreVO.getHotelId());
		roomStoreVO.setHotelId(hotel.getId());
		roomStoreVO.setHotelName(hotel.getHotelName());

		// 根据 roomId 查询对应的 HotelRoom 对象
		HotelRoom hotelRoom = hotelRoomTransport.queryHotelRoomById(validateRoomStoreVO.getRoomId());
		roomStoreVO.setRoomId(hotelRoom.getId());
		roomStoreVO.setPrice(hotelRoom.getRoomPrice());

		// 根据入住时间和退房时间，查询该房间所剩数量
		int store = hotelRoomTransport.queryHotelRoomStoreByDate(validateRoomStoreVO);
		roomStoreVO.setStore(store);

		roomStoreVO.setCheckInDate(validateRoomStoreVO.getCheckInDate());
		roomStoreVO.setCheckOutDate(validateRoomStoreVO.getCheckOutDate());
		roomStoreVO.setCount(validateRoomStoreVO.getCount());

		return ResponseDto.success(roomStoreVO);
	}

	/**
	 * <b>生成订单</b>
	 * @param addHotelOrderVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/addhotelorder")
	public ResponseDto<Object> addHotelOrder(@RequestBody AddHotelOrderVO addHotelOrderVO) throws Exception {
		// 查询此时是否有房
		ValidateRoomStoreVO validateRoomStoreVO = new ValidateRoomStoreVO();
		BeanUtils.copyProperties(addHotelOrderVO, validateRoomStoreVO);
		int store = hotelRoomTransport.queryHotelRoomStoreByDate(validateRoomStoreVO);

		if (store >= addHotelOrderVO.getCount()) {
			// 有房的情况下，保存订单数据表
			// 创建HotelOrder对象
			String userCode = "";
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if ("user".equals(cookie.getName())) {
					userCode = cookie.getValue();
				}
			}

			User userQuery = new User();
			userQuery.setUserCode(userCode);

			User user = userTransport.getListByQuery(userQuery).get(0);

			HotelOrder hotelOrder = new HotelOrder();
			hotelOrder.setUserId(user.getId());
			BeanUtils.copyProperties(addHotelOrderVO, hotelOrder);
			String orderNo = HotelOrderNoCreator.createHotelOrderNo(addHotelOrderVO.getHotelId(), addHotelOrderVO.getRoomId());
			hotelOrder.setOrderNo(orderNo);
			// 交易编号
			hotelOrder.setTradeNo(orderNo);
			// 订单状态
			hotelOrder.setOrderStatus(OrderStatusEnum.ORDER_STATUS_PREPAY.getCode());
			// 订单价格
			HotelRoom hotelRoom = hotelRoomTransport.queryHotelRoomById(addHotelOrderVO.getRoomId());
			hotelOrder.setPayAmount(addHotelOrderVO.getCount() * hotelRoom.getRoomPrice());
			// 添加联系人信息
			List<UserLinkUser> userLinkUserList = addHotelOrderVO.getLinkUser();
			StringBuffer sb = new StringBuffer();
			for (UserLinkUser userLinkUser : userLinkUserList) {
				sb.append(userLinkUser.getLinkUserName() + ",");
			}
			hotelOrder.setLinkUserName(sb.toString().substring(0, sb.toString().length() - 1));
			// 保存订单
			hotelOrderTransport.save(hotelOrder);
			// 获得 HotelOrder 对象的 id 和 OrderId 添加为 Map 集合
			// 查询对象
			HotelOrder query = new HotelOrder();
			query.setOrderNo(orderNo);
			HotelOrder order = hotelOrderTransport.getHotelOrderByNo(orderNo);

			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("id", order.getId());
			resultMap.put("orderNo", order.getOrderNo());
			// 返回该 Map 集合
			return ResponseDto.success(resultMap);
		}
		return null;
	}

	/**
	 * <b>根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getpersonalorderinfo/{orderId}")
	public ResponseDto<Object> getPersonalOrderInfo(@PathVariable("orderId") Long orderId) throws Exception{
		ItripPersonalHotelOrderVo personalHotelOrderVo = new ItripPersonalHotelOrderVo();
		//根据订单id查询订单信息
		HotelOrder hotelOrder = new HotelOrder();
		hotelOrder.setId(orderId);
		//进行查询
		List<HotelOrder> orderList = hotelOrderTransport.getHotelListByQuery(hotelOrder);
		return ResponseDto.success(orderList.get(0));
	}
	@GetMapping("/getpersonalorderroominfo/{orderId}")
	public ResponseDto<Object> getPersonalOrderRoomInfo(@PathVariable("orderId")Long orderId) throws Exception{
		//根据订单Id查询酒店Id和房间Id
		HotelOrder hotelOrder = new HotelOrder();
		hotelOrder.setId(orderId);
		List<HotelOrder> hotelOrderList = hotelOrderTransport.getHotelListByQuery(hotelOrder);
		//只能查到一个订单信息
		HotelOrder order = hotelOrderList.get(0);
		//根据酒店订单信息封装查询参数，查询酒店房间信息
		HotelRoom hotelRoom = new HotelRoom();
		//进行查询
		hotelRoom = hotelRoomTransport.queryHotelRoomById(order.getRoomId());
		System.out.println(hotelRoom);
		return ResponseDto.success(hotelRoom);
	}


	@GetMapping("/queryOrderById/{orderId}")
	public ResponseDto<Object> queryOrderById(@PathVariable("orderId") Long orderId) throws Exception{
		ModifyHotelOrderVO modifyHotelOrderVO = new ModifyHotelOrderVO();
		//根据订单ID查询订单信息
		HotelOrder query = new HotelOrder();
		query.setId(orderId);
		//查询订单列表
		List<HotelOrder> linkUserList = hotelOrderTransport.getHotelListByQuery(query);
		HotelOrder hotelOrder = linkUserList.get(0);
		modifyHotelOrderVO.setId(hotelOrder.getId());
		modifyHotelOrderVO.setPayType(hotelOrder.getPayType());
		modifyHotelOrderVO.setOrderType(hotelOrder.getOrderType());
		modifyHotelOrderVO.setOrderNo(hotelOrder.getOrderNo());
		modifyHotelOrderVO.setHotelId(hotelOrder.getHotelId());
		modifyHotelOrderVO.setHotelName(hotelOrder.getHotelName());
		modifyHotelOrderVO.setRoomId(hotelOrder.getRoomId());
		modifyHotelOrderVO.setCount(hotelOrder.getCount());
		modifyHotelOrderVO.setCheckInDate(hotelOrder.getCheckInDate());
		modifyHotelOrderVO.setCheckOutDate(hotelOrder.getCheckOutDate());
		modifyHotelOrderVO.setNoticePhone(hotelOrder.getNoticePhone());
		modifyHotelOrderVO.setNoticeEmail(hotelOrder.getNoticeEmail());
		modifyHotelOrderVO.setSpecialRequirement(hotelOrder.getSpecialRequirement());
		modifyHotelOrderVO.setIsNeedInvoice(hotelOrder.getIsNeedInvoice());
		modifyHotelOrderVO.setInvoiceType(hotelOrder.getInvoiceType());
		modifyHotelOrderVO.setInvoiceHead(hotelOrder.getInvoiceHead());
		modifyHotelOrderVO.setLinkUserName(hotelOrder.getLinkUserName());
		modifyHotelOrderVO.setBookType(hotelOrder.getBookType());
		modifyHotelOrderVO.setBookingDays(hotelOrder.getBookingDays());
		//根据订单编号查询联系人列表
		HotelOrder queryOrder = new HotelOrder();
		queryOrder.setId(orderId);
		List<ItripOrderLinkUserVO> itripOrderLinkUserVO = new ArrayList<ItripOrderLinkUserVO>();
		List<UserLinkUser> userLinkUserList = hotelOrderTransport.getFindOrderListBYQuery(query);
		for (UserLinkUser userLinkUser: userLinkUserList) {
			ItripOrderLinkUserVO  orderLinkUserVO = new ItripOrderLinkUserVO();
			BeanUtils.copyProperties(userLinkUser, orderLinkUserVO);
			itripOrderLinkUserVO.add(orderLinkUserVO);
		}
		modifyHotelOrderVO.setItripOrderLinkUserList(itripOrderLinkUserVO);
		return ResponseDto.success(modifyHotelOrderVO);
	}
}
