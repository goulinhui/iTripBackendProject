package com.whackon.itrip.service.Impl;

import com.whackon.itrip.dao.UserDao;
import com.whackon.itrip.pojo.entity.User;
import com.whackon.itrip.service.UserService;
import com.whackon.itrip.util.ActiveCodeUtil;
import com.whackon.itrip.util.MailSenderUtil;
import com.whackon.itrip.util.RegValidationUtil;
import com.whackon.itrip.util.SmsSenderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	@Autowired
	private MailSenderUtil mailSenderUtil;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private SmsSenderUtil smsSenderUtil;
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
			//产生激活码，将激活码保存到Redis中
			String activeCode = ActiveCodeUtil.createActiveCode();
			//使用StringRedisTemplate将验证码进行保存，key为用户的email地址，value是激活码
			redisTemplate.opsForValue().set(user.getUserCode(), activeCode);
			//设置存储于redis中数据存活时间
			redisTemplate.expire(user.getUserCode(), 30, TimeUnit.MINUTES);
			//判断此时用户注册使用的手机号码还是邮箱地址
			if(RegValidationUtil.validateEmail(user.getUserCode())){
				//通过发送邮件，将激活码发送给用户
				return mailSenderUtil.sendActiveCodeMail(user.getUserCode(), activeCode);
			}else if(RegValidationUtil.validateCellphone(user.getUserCode())){
				//使用手机号码注册，将激活码发送到对方的手机中
				return smsSenderUtil.sendSms(user.getUserCode(), activeCode);
			}
		}
		return false;
	}

	/**
	 * <b>通过userCode在Redis中查询对应的激活码</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public String getActiveCodeByUserCode(String userCode) throws Exception {
		//通过Redis查询对应的激活码
		String activeCode = redisTemplate.opsForValue().get(userCode);
		return activeCode;
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(User user) throws Exception {
		int count = userDao.updateUser(user);
		if(count>0){
			return true;
		}
		return false;
	}
}
