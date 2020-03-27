package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.ItripImage;
import com.whackon.itrip.service.ItripImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-图片传输层接口实现类</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("itripImageTransport")
@RequestMapping("/img/trans")
public class ItripImageTransportImpl implements ItripImageTransport {
	@Autowired
	private ItripImageService itripImageService;
	/**
	 * <b>根据查询条件查询信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	public List<ItripImage> getItripImageListByQuery(@RequestBody ItripImage query) throws Exception {
		return itripImageService.getImageListByQuery(query);
	}
}
