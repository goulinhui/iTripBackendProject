package com.whackon.itrip.dao;

import com.whackon.itrip.pojo.entity.User;

import java.util.List;

/**
 * <b>爱旅行-用户信息持久层接口</b>
 * @author Administrator
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserDao {
	List<User> findListByQuery(User query) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int saveUser(User user) throws  Exception;
}
