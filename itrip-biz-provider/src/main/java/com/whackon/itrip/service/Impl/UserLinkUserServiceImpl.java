package com.whackon.itrip.service.Impl;

import com.whackon.itrip.dao.UserLinkUserDao;
import com.whackon.itrip.pojo.entity.UserLinkUser;
import com.whackon.itrip.pojo.vo.ItripAddUserLinkUserVO;
import com.whackon.itrip.service.UserLinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userLinkUserService")
@Transactional
public class UserLinkUserServiceImpl implements UserLinkUserService{
    @Autowired
	private UserLinkUserDao userLinkUserDao;

	/**
	 * <b>根据查询信息查询联系人列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<UserLinkUser> getUserLinkUserListByQuery(UserLinkUser query) throws Exception {
		List<UserLinkUser> userLinkUserList = userLinkUserDao.findUserLinkUserListByQuery(query);
		if(userLinkUserList!= null){
			return userLinkUserList;
		}
		return new ArrayList<UserLinkUser>();
	}

	/**
	 * <b>添加常用联系人</b>
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	public int insertUserLink(UserLinkUser userLinkUser) throws Exception {
		return userLinkUserDao.insertUserLink(userLinkUser);
	}

	/**
	 * <b>修改常用联系人信息</b>
	 * @param itripAddUserLinkUserVO
	 * @return
	 * @throws Exception
	 */
	public int updateUserLink(ItripAddUserLinkUserVO itripAddUserLinkUserVO) throws Exception {
		int count = 0;
		count = userLinkUserDao.updateUserLink(itripAddUserLinkUserVO);
		return count;
	}
}
