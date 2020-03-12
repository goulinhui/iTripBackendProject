package com.whackon.itrip.service.Impl;

import com.whackon.itrip.dao.AreaDicDao;
import com.whackon.itrip.pojo.entity.AreaDic;
import com.whackon.itrip.service.AreaDicService;
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
@Service("areaDicService")
@Transactional
public class AreaDicServiceImpl implements AreaDicService {
	@Autowired
	private AreaDicDao areaDicDao;
	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<AreaDic> getListByQuery(AreaDic query) throws Exception {
		//通过数据持久层查询结果
		List<AreaDic> areaDicList = areaDicDao.findListByQuery(query);
		if (areaDicList != null){
			return areaDicList;
		}
		return new ArrayList<AreaDic>();
	}
}










