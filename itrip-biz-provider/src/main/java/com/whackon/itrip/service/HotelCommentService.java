package com.whackon.itrip.service;



import com.whackon.itrip.base.pojo.vo.Page;
import com.whackon.itrip.pojo.entity.HotelComment;
import com.whackon.itrip.pojo.vo.ScoreCommentVO;
import com.whackon.itrip.pojo.vo.SearchCommentVo;

import java.util.List;
import java.util.Map;

/**
 * <b>爱旅行-酒店评论业务层接口</b>、
 * @author ls
 * @version 1.0.0
 * @since 1.0.0
 */
public interface HotelCommentService {

	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelComment
	 * @return
	 * @throws Exception
	 */
	ScoreCommentVO getHotelScore(HotelComment hotelComment)throws Exception;

	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param searchCommentVO
	 * @return
	 * @throws Exception
	 */
	Page<HotelComment> getcommentlist(SearchCommentVo searchCommentVO)throws Exception;

	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Integer getCommentCounts(Map<String, Object> map)throws Exception;

}
