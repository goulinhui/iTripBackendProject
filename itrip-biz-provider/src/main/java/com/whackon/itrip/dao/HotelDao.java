package com.whackon.itrip.dao;

import com.whackon.itrip.pojo.entity.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-酒店功能数据持久层接口</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface HotelDao {
	public List<Hotel> findListByQuery(Hotel query) throws Exception;
}
