package com.whackon.itrip.transport;


import com.whackon.itrip.base.pojo.vo.Page;
import com.whackon.itrip.pojo.entity.HotelComment;
import com.whackon.itrip.pojo.vo.ScoreCommentVO;
import com.whackon.itrip.pojo.vo.SearchCommentVo;
import com.whackon.itrip.service.HotelCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

/**
 * <b>爱旅行-酒店评论传输层接口实现类</b>、
 * @author ls
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("/hotelCommentTransport")
@RequestMapping("/hotel/trans")
public class HotelCommentTransportImpl implements HotelCommentTransport {

	@Autowired
	private HotelCommentService hotelCommentService;

	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelComment
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/comment")
	public ScoreCommentVO getHotelScore(@RequestBody HotelComment hotelComment) throws Exception {
		return hotelCommentService.getHotelScore(hotelComment);
	}

	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param searchCommentVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/commentlist")
	public Page<HotelComment> getcommentlist(@RequestBody SearchCommentVo searchCommentVO) throws Exception {
		return hotelCommentService.getcommentlist(searchCommentVO);
	}


	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/count")
	public Integer getCommentCounts(@RequestBody Map<String, Object> map) throws Exception {
		return hotelCommentService.getCommentCounts(map);
	}
}
