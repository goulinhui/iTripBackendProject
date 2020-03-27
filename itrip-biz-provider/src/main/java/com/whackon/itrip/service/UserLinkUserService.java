package com.whackon.itrip.service;

import com.whackon.itrip.pojo.entity.UserLinkUser;
import com.whackon.itrip.pojo.vo.ItripAddUserLinkUserVO;

import java.util.List;

public interface UserLinkUserService {
	/**
	 * <b>根据查询信息查询联系人列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> getUserLinkUserListByQuery(UserLinkUser query) throws  Exception;

	/**
	 * <b>添加常用联系人</b>
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
