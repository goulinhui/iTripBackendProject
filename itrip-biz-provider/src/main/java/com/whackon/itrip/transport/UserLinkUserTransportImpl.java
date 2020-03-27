package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.UserLinkUser;
import com.whackon.itrip.pojo.vo.ItripAddUserLinkUserVO;
import com.whackon.itrip.service.UserLinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("userLinkUserTransport")
@RequestMapping("linkuser/trans")
public class UserLinkUserTransportImpl implements UserLinkUserTransport {
	@Autowired
	private UserLinkUserService userLinkUserService;

	/**
	 * <b>根据查询信息获得查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	public List<UserLinkUser> queryUserLinkUserListByQuery(@RequestBody UserLinkUser query) throws Exception {
		return userLinkUserService.getUserLinkUserListByQuery(query);
	}

	/**
	 * <b>添加常用联系人</b>
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/addLinkUser")
	public int insertUserLink(UserLinkUser userLinkUser) throws Exception {
		return userLinkUserService.insertUserLink(userLinkUser);
	}

	/**
	 * <b>修改常用联系人</b>
	 * @param itripAddUserLinkUserVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("update")
	public int updateUserLink(ItripAddUserLinkUserVO itripAddUserLinkUserVO) throws Exception {
		return userLinkUserService.updateUserLink(itripAddUserLinkUserVO);
	}
}
