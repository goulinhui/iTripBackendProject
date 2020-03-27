package com.whackon.itrip.controller;

import com.whackon.itrip.base.controller.BaseController;
import com.whackon.itrip.base.pojo.vo.ResponseDto;
import com.whackon.itrip.pojo.entity.User;
import com.whackon.itrip.pojo.entity.UserLinkUser;
import com.whackon.itrip.pojo.vo.ItripAddUserLinkUserVO;
import com.whackon.itrip.pojo.vo.ModifyUserLinkUserVO;
import com.whackon.itrip.transport.UserLinkUserTransport;
import com.whackon.itrip.transport.UserTransport;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.List;

@RestController("userLinkUserController")
@RequestMapping("biz/api/userinfo")
public class UserLinkUserController extends BaseController {
	   @Autowired
       private UserLinkUserTransport userLinkUserTransport;
	   @Autowired
	   private UserTransport userTransport;

	/**
	 * <b>根据当前登录用户，获得联系人</b>
	 * @return
	 * @throws Exception
	 */
	   @PostMapping(value = "/queryuserlinkuser")
	   public ResponseDto<Object> queryUserLinkUser() throws Exception{
	   	//通过Cookies 获得当前登陆对象
		   String userCode="";
		   Cookie[] cookies = request.getCookies();
		   for (Cookie cookie: cookies) {
			   if("user".equals(cookie.getName())){
			   	userCode = cookie.getValue();
			   }
		   }
		   //封装查询对象
		   UserLinkUser query = new UserLinkUser();
		   query.setUserCode(userCode);
		   return ResponseDto.success(userLinkUserTransport.queryUserLinkUserListByQuery(query));
	   }

	/**
	 * <b>添加常用联系人信息</b>
	 * @param itripAddUserLinkUserVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/adduserlinkuser")
	public ResponseDto<Object> addUserLinkUser(@RequestBody ItripAddUserLinkUserVO itripAddUserLinkUserVO)throws Exception {
		//获得cookie对象
		Cookie cookies[] = request.getCookies();
		String userCode = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				userCode = cookie.getValue();
			}
		}
		User user = new User();
		List<User> userList = userTransport.getListByQuery(user);
		Long userId = userList.get(1).getId();

		//封装参数
		UserLinkUser userLinkUser = new UserLinkUser();
		userLinkUser.setLinkUserName(itripAddUserLinkUserVO.getLinkUserName());
		userLinkUser.setLinkIdCard(itripAddUserLinkUserVO.getLinkIdCard());
		userLinkUser.setLinkPhone(itripAddUserLinkUserVO.getLinkPhone());
		userLinkUser.setUserId(userId);
		userLinkUser.setCreationDate(new Date());
		userLinkUser.setModifyDate(new Date());

		//进行增加联系人
		int count = userLinkUserTransport.insertUserLink(userLinkUser);
		if (count > 0) {
			return ResponseDto.success("新增联系人成功");
		}
		return ResponseDto.failure("新增联系人失败");
	}
	@PostMapping("/modifyuserlinkuser")
	public ResponseDto<Object> modifyUserLinkUser(@RequestBody ModifyUserLinkUserVO modifyUserLinkUserVO) throws Exception{
		//封装常用联系人信息，复制对象
		ItripAddUserLinkUserVO addUserLinkUserVO = new ItripAddUserLinkUserVO();
		BeanUtils.copyProperties(modifyUserLinkUserVO, addUserLinkUserVO);

		addUserLinkUserVO.setUserId(modifyUserLinkUserVO.getId());
		//进行修改
		int count = userLinkUserTransport.updateUserLink(addUserLinkUserVO);
		if(count>0){
			return ResponseDto.success("修改联系人成功");
		}
		return ResponseDto.failure("修改联系人失败");
	}
}

