package com.whackon.itrip;

import com.whackon.itrip.pojo.entity.User;
import com.whackon.itrip.pojo.vo.UserVO;
import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.BeanUtils;

public class BeanUtilTest {
	public static void main(String[] args) {
		UserVO userVO = new UserVO();
		userVO.setUserCode("chen@163.com");
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		System.out.print(user.getUserCode());
	}
}
