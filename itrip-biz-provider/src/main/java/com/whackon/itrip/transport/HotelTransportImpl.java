package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.Hotel;
import com.whackon.itrip.pojo.vo.SearchHotCityVO;
import com.whackon.itrip.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-酒店模块传输层接口实现类</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("hotelTransport")
@RequestMapping("/hotel/trans")
public class HotelTransportImpl implements HotelTransport {
	@Autowired
	private HotelService hotelService;

	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/searchItripHotelListByHotCity")
	public List<Hotel> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO queryVO)
			throws Exception {
		return hotelService.searchItripHotelListByHotCity(queryVO);
	}
}
