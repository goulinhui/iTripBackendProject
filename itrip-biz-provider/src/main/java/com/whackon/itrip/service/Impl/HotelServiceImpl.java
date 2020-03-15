package com.whackon.itrip.service.Impl;

import com.github.pagehelper.PageHelper;
import com.whackon.itrip.dao.HotelDao;
import com.whackon.itrip.pojo.entity.Hotel;
import com.whackon.itrip.pojo.vo.SearchHotCityVO;
import com.whackon.itrip.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-酒店模块业务层接口实现类</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDao hotelDao;

	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	public List<Hotel> searchItripHotelListByHotCity(SearchHotCityVO queryVO) throws Exception {
		// 封装查询对象
		Hotel query = new Hotel();
		query.setCityId((long) queryVO.getCityId());

		// 为了获得前六条，那么可以变相的使用分页查询来进行
		PageHelper.startPage(1, queryVO.getCount());
		List<Hotel> hotelList = hotelDao.findListByQuery(query);

		if (hotelList != null) {
			return hotelList;
		}
		return new ArrayList<Hotel>();
	}
}
