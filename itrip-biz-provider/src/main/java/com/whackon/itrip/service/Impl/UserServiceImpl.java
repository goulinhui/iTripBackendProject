package com.whackon.itrip.service.Impl;

import com.whackon.itrip.dao.UserDao;
import com.whackon.itrip.pojo.entity.User;
import com.whackon.itrip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
/**
		* <b>爱旅行-用户信息业务层接口实现类</b>
		* @author Administrator
		* @version 1.0.0
		* @since 1.0.0
		*/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	/**
	 * <b>根据查询对象查询用户信息</b>
	 * @param query
	 * @return
	 */
	public List<User> getListByQuery(User query) throws Exception {
		return userDao.findListByQuery(query);
	}
	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Boolean saveUser(User user) throws Exception {
		//设定用户注册时间
		user.setCreationDate(new Date());
		//使用数据持久层保存用户信息
		int count = userDao.saveUser(user);
		if(count>0){
			//产生激活码，将激活码保存到HttpSession中
			return true;
		}
		return false;
	}
}
