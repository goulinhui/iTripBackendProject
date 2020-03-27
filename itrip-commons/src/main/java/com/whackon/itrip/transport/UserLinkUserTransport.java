package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.HotelOrder;
import com.whackon.itrip.pojo.entity.UserLinkUser;
import com.whackon.itrip.pojo.vo.ItripAddUserLinkUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/linkuser/trans")
public interface UserLinkUserTransport {
	/**
	 * <b>根据查询信息获得查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	List<UserLinkUser> queryUserLinkUserListByQuery(@RequestBody UserLinkUser query) throws Exception;

	/**
	 * <b>添加常用联系人</b>
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/addLinkUser")
	int insertUserLink(@RequestBody UserLinkUser userLinkUser)throws Exception;

	@PostMapping("update")
	int updateUserLink(@RequestBody ItripAddUserLinkUserVO itripAddUserLinkUserVO)throws Exception;

}
