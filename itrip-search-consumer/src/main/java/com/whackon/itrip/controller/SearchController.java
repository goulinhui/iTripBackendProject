package com.whackon.itrip.controller;

import com.whackon.itrip.base.controller.BaseController;
import com.whackon.itrip.base.pojo.vo.ResponseDto;
import com.whackon.itrip.pojo.entity.Hotel;
import com.whackon.itrip.pojo.vo.SearchHotCityVO;
import com.whackon.itrip.transport.HotelTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-搜索模块控制器</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("searchController")
@RequestMapping("/search/api")
public class SearchController extends BaseController {
	@Autowired
	private HotelTransport hotelTransport;

	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/hotellist/searchItripHotelListByHotCity")
	public ResponseDto<Object> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO queryVO)
			throws Exception {
		List<Hotel> hotelList = hotelTransport.searchItripHotelListByHotCity(queryVO);
		return ResponseDto.success(hotelList);
	}
}
