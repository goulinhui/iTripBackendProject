package com.whackon.itrip.dao;

import com.whackon.itrip.pojo.entity.LabelDic;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * <b>爱旅行-系统字典信息数据持久层接口</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface LabelDicDao {
	/**
	 * <b>按照条件查询信息列表</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<LabelDic> findListByQuery(LabelDic query) throws Exception;

}
