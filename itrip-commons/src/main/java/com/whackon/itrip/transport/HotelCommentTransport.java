package com.whackon.itrip.transport;


import com.whackon.itrip.base.pojo.vo.Page;
import com.whackon.itrip.pojo.entity.HotelComment;
import com.whackon.itrip.pojo.vo.ScoreCommentVO;
import com.whackon.itrip.pojo.vo.SearchCommentVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * <b>爱旅行-酒店评论传输层接口</b>、
 * @author ls
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "itrip-biz-provider")
@RequestMapping("/hotel/trans")
public interface HotelCommentTransport {

	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelComment
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/comment")
	ScoreCommentVO getHotelScore(@RequestBody HotelComment hotelComment)throws Exception;

	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param searchCommentVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/commentlist")
	Page<HotelComment> getcommentlist(@RequestBody SearchCommentVo searchCommentVO)throws Exception;

	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/count")
	Integer getCommentCounts(@RequestBody Map<String, Object> map)throws Exception;


}
