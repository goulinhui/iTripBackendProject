package com.whackon.itrip.controller;

import com.whackon.itrip.base.controller.BaseController;
import com.whackon.itrip.base.enums.AreaHotEnum;
import com.whackon.itrip.base.pojo.vo.ResponseDto;
import com.whackon.itrip.pojo.entity.AreaDic;
import com.whackon.itrip.pojo.entity.Hotel;
import com.whackon.itrip.pojo.entity.LabelDic;
import com.whackon.itrip.transport.AreaDicTransport;
import com.whackon.itrip.transport.HotelTransport;
import com.whackon.itrip.transport.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-主业务酒店模块控制器</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("hotelController")
@RequestMapping("/biz/api/hotel")
public class HotelController extends BaseController {
	@Autowired
	private LabelDicTransport labelDicTransport;
	@Autowired
	private AreaDicTransport areaDicTransport;
	@Autowired
	private HotelTransport hotelTransport;
	/**
	 * <b>查询热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/queryhotcity/{isChina}")
	public ResponseDto<Object> queryHotCityList(@PathVariable("isChina") Integer isChina)throws Exception{
		//创建查询对象
		AreaDic query= new AreaDic();
		//设置查询条件：是否属于国内城市
		query.setIsChina(isChina);
		//设置查询条件，热门城市
		query.setIsHot(AreaHotEnum.AREA_HOT_YES.getCode());

		//查询列表
		List<AreaDic> areaDicList = areaDicTransport.getListByQuery(query);
		return ResponseDto.success(areaDicList);
	}
	@GetMapping(value = "/queryhotelfeature")
	public ResponseDto<Object> queryHotelFeature() throws Exception{
		//创建查询对象
		LabelDic query = new LabelDic();
		query.setParentId(16L);

		List<LabelDic> labelDicList = labelDicTransport.getListByQuery(query);

		return ResponseDto.success(labelDicList);
	}

	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称（视频文字描述）</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getVideodesc/{hotelId}")
	public ResponseDto<Object> getVideoDesc(@PathVariable("hotelId") Long hotelId) throws Exception{
		Hotel hotel = hotelTransport.getHotelById(hotelId);
		return ResponseDto.success(hotel);
	}
}
























