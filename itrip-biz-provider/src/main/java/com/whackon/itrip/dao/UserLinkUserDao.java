package com.whackon.itrip.dao;

import com.whackon.itrip.pojo.entity.UserLinkUser;
import com.whackon.itrip.pojo.vo.ItripAddUserLinkUserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-用户联系人信息数据持久层接口</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface UserLinkUserDao {
	/**
	 * <b>根据查询获得列表信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> findUserLinkUserListByQuery(UserLinkUser query) throws Exception;
	/**
	 * <b>保存用户信息</b>
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	int insertUserLink(UserLinkUser userLinkUser) throws Exception;

	/**
	 * <b>修改常用联系人信息</b>
	 * @param itripAddUserLinkUserVO
	 * @return
	 * @throws Exception
	 */
	int updateUserLink(ItripAddUserLinkUserVO itripAddUserLinkUserVO)throws Exception;
}
