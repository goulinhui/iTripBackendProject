package com.whackon.itrip.dao;


import com.whackon.itrip.pojo.entity.HotelComment;
import com.whackon.itrip.pojo.vo.ScoreCommentVO;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

/**
 * <b>爱旅行-酒店评论数据持久层接口</b>、
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface HotelCommentDao {

	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelComment
	 * @return
	 * @throws Exception
	 */
	ScoreCommentVO queryHotelScore(HotelComment hotelComment)throws Exception;


	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param hotelComment
	 * @return
	 * @throws Exception
	 */
	List<HotelComment> queryHotelCommentList(HotelComment hotelComment)throws Exception;


	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Integer findCommentCounts(Map<String, Object> map)throws Exception;

}
