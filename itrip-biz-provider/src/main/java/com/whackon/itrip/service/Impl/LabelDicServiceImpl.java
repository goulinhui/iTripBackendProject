package com.whackon.itrip.service.Impl;

import com.whackon.itrip.dao.LabelDicDao;
import com.whackon.itrip.pojo.entity.LabelDic;
import com.whackon.itrip.service.LabelDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-区域字典信息业务层接口实现类</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("labelDicService")
@Transactional
public class LabelDicServiceImpl implements LabelDicService {
	@Autowired
	private LabelDicDao LabelDicDao;
	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<LabelDic> getListByQuery(LabelDic query) throws Exception {
		//通过数据持久层查询结果
		List<LabelDic> labelDicList = LabelDicDao.findListByQuery(query);
		if (labelDicList != null){
			return labelDicList;
		}
		return new ArrayList<LabelDic>();
	}
}
