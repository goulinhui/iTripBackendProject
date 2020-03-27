package com.whackon.itrip.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whackon.itrip.base.pojo.vo.Page;
import com.whackon.itrip.dao.HotelCommentDao;
import com.whackon.itrip.pojo.entity.HotelComment;
import com.whackon.itrip.pojo.vo.ScoreCommentVO;
import com.whackon.itrip.pojo.vo.SearchCommentVo;
import com.whackon.itrip.service.HotelCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;

/**
 * <b>爱旅行-酒店评论业务层接口实现类</b>、
 * @author ls
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("hotelCommentService")
@Transactional
public class HotelCommentServiceImpl implements HotelCommentService {

	@Autowired
	private HotelCommentDao hotelCommentDao;

	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelComment
	 * @return
	 * @throws Exception
	 */
	public ScoreCommentVO getHotelScore(HotelComment hotelComment) throws Exception {
		ScoreCommentVO scoreCommentVO = hotelCommentDao.queryHotelScore(hotelComment);

		DecimalFormat fnum = new DecimalFormat("##0.0");
		scoreCommentVO.setFacilitiesScore(Float.parseFloat(fnum.format(scoreCommentVO.getFacilitiesScore())));
		scoreCommentVO.setHygieneScore(Float.parseFloat(fnum.format(scoreCommentVO.getHygieneScore())));
		scoreCommentVO.setPositionScore(Float.parseFloat(fnum.format(scoreCommentVO.getPositionScore())));
		scoreCommentVO.setServiceScore(Float.parseFloat(fnum.format(scoreCommentVO.getServiceScore())));
		scoreCommentVO.setScore(Float.parseFloat(fnum.format(scoreCommentVO.getScore())));

		return hotelCommentDao.queryHotelScore(hotelComment);
	}

	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param searchCommentVO
	 * @return
	 * @throws Exception
	 */
	public Page<HotelComment> getcommentlist(SearchCommentVo searchCommentVO) throws Exception {
		Page<HotelComment> page = new Page<HotelComment>();
		//封装查询参数
		HotelComment hotelComment = new HotelComment();
		hotelComment.setHotelId(searchCommentVO.getHotelId());
		hotelComment.setIsHavingImg(searchCommentVO.getIsHavingImg());
		hotelComment.setIsOk(searchCommentVO.getIsOK());
		//设置分页信息

		PageHelper.startPage(searchCommentVO.getPageNo(), searchCommentVO.getPageSize());
		//直接进行查询
		List<HotelComment> hotelCommentList = hotelCommentDao.queryHotelCommentList(hotelComment);
		//使用pageInfo对结果进行封装
		PageInfo<HotelComment> pageInfo = new PageInfo<HotelComment>(hotelCommentList);

		if(hotelCommentList != null && hotelCommentList.size() > 0){
			page.setCurPage(searchCommentVO.getPageNo());
			page.setPageSize(searchCommentVO.getPageSize());
			page.setRows(hotelCommentList);
			page.setTotal((int)pageInfo.getTotal());
			//总页数
			page.setPageCount(pageInfo.getPages());
			page.setBeginPos(pageInfo.getStartRow());

			return page;
		}
		return new Page<HotelComment>();
	}

	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer getCommentCounts(Map<String, Object> map) throws Exception {
		Integer counts = hotelCommentDao.findCommentCounts(map);
		if(counts != null){
			return counts;
		}
		return 0;
	}


}
