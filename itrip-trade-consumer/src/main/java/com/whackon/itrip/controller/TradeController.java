package com.whackon.itrip.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.whackon.itrip.base.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("tradeController")
@RequestMapping("/trade/api")
public class TradeController extends BaseController {


	@GetMapping(value = "/prepay/{tradeNo}")
	public void testTrade(@PathVariable("tradeNo") String tradeNo) throws Exception{
		AlipayClient alipayClient =  new DefaultAlipayClient(
				"https://openapi.alipaydev.com/gateway.do" ,
				"2016101800713556",
				"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCyaACpmw8op0q0rRXM864XOnvn+0PmnGvtb539JwR4N2hgl5hfqgZA0WWjhvJe1TTvPfO66EmzmMg8lrTNzMVCTyJdLS0P5L5s3J196I0uroeqiNEoS+K8vEAvtGgj3Jlxg/J0b65tX9PtAxeyoHFo7b8xbHWAuSUussoO8ZX75Zr2l8JGcjaq03HhJjfmTVR/j9b2MRnl25+pcJ3pPVdoAUEeV4GCQORkCghd2jYOP/tSUAZE8mFb4ucVx00GrqR2a6wibJi1wFAQG1d03vOt2tZ6bFnZBHRuG1oCAEnMhox/HxJc88rsokMHIkaFYSZB1UcZxByPTW4dNQzkkeixAgMBAAECggEBAI74mc9R3AwQROYV72qXveQPkkyOKBQfNr7IvCuroQFWJeeClTHU5736ESHDe2hUJF+1niUjEi1DOvSTMcHbYBmLoVZaZcpe3dwP0IaeXsYSR9Z6XmOUrNfjZOzV/r7+glleDGcTOQ2dxhAiclNMEJauMJJDAMdvmEScMyFWqYN7Wq0hB33sP2XJBpuXPEX/NB41t9+v6h6LoiJnk1qAu/2iO8Y6wlC374dUvJWxAiQivqKOk/yT7ltPHxocniCb6d4hqtOLG/fULxgalXXgw4hGLUMYmtZ2G+RjL3AnKf1Opv9ddy2TtN/B2i37aLHsZWliXcuXdF6kwI75tjktmiECgYEA+kM6E9uoqG/vR16DN5gXzjr3024BB2b2L5+j+uhFuS54ZmLtrxPoPhsoS8QhbPEtlXAOFFl7OlxNR9BQNVnoRs4DNdUdPtzubEDcxP+tBQ1K/lX1t87zJweSywQfnF5lY61W3a7E80/bGquZphsZIcXQmW7IJYT018Ur+EO6RnMCgYEAtn8OV/iXu8QSjF1KU/ZqRiJi846LgYVhXAEsVzAhgXRi3eNt1fZtPM7EyJlX9nB1KHD93g5dtqiPhvi+m4eGZwur1xmw6wKBIx2xik4/ftMNOWORMsrGTds1wRVl82dhXNkXXz9sjxDBGqHaU6/ItAKhAxOA2+jOHwCFNtn9Z0sCgYBzFxWPalYe2BNHVAyuNXDFM9Mi1ZT9jXksH5Nu4QCnj9po45gBCvukDCM07Maebi+TaMvgyeHkzevwWbl5P5aVcUqCqDZh4YJ4IEAnDJnKF/nkCy4MUMz7pvz4BjZvV+3ysBWhryz95DyUAFSR0iZ1pJ4w4YSD1KgwzolRC/yPRwKBgEo2kwOtQS8HRi+0hFRuobsRosG+1vZ94iDDDWALX6TASrBHG1RmWPfgcd/NlBrQkqQ2htZ1ayCrnWpa31BqJXrkISZg+TQomZFJMvi2Z1XQx9Dtr49DLK9elJaHeCUqhkp2se124lOvkYeeCCX+FxU0+HtCxCUpoCC1Wnb64PTPAoGBAPn9yrL8X6YOSnToWIdeiQTsdiPG3OxZfX7+dojWs1cNgl3e9Nz6LsEmhFjfOZnNAOBgRwq+OoeN2hnnHZq0NVu/NvBX93hlPUB6Ebo0f/rijvSx3YhhyfoavEgXe9vzieQZwM7Rnvi0JpIcVCndgs0SqFcP0ja78JaaFR6TNJVB",
				"json",
				"UTF-8",
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsmgAqZsPKKdKtK0VzPOuFzp75/tD5pxr7W+d/ScEeDdoYJeYX6oGQNFlo4byXtU07z3zuuhJs5jIPJa0zczFQk8iXS0tD+S+bNydfeiNLq6HqojRKEvivLxAL7RoI9yZcYPydG+ubV/T7QMXsqBxaO2/MWx1gLklLrLKDvGV++Wa9pfCRnI2qtNx4SY35k1Uf4/W9jEZ5dufqXCd6T1XaAFBHleBgkDkZAoIXdo2Dj/7UlAGRPJhW+LnFcdNBq6kdmusImyYtcBQEBtXdN7zrdrWemxZ2QR0bhtaAgBJzIaMfx8SXPPK7KJDByJGhWEmQdVHGcQcj01uHTUM5JHosQIDAQAB",
				"RSA2");  //获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request
		alipayRequest.setReturnUrl( "http://localhost/itrip" );
		alipayRequest.setNotifyUrl( "http://domain.com/CallBack/notify_url.jsp" ); //在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent( "{"  +
				"    \"out_trade_no\":\"20150320010101001\","  +
				"    \"product_code\":\"FAST_INSTANT_TRADE_PAY\","  +
				"    \"total_amount\":88.88,"  +
				"    \"subject\":\"Iphone6 16G\","  +
				"    \"body\":\"Iphone6 16G\","  +
				"    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","  +
				"    \"extend_params\":{"  +
				"    \"sys_service_provider_id\":\"2088511833207846\""  +
				"    }" +
				"  }" ); //填充业务参数
		String form= "" ;
		try  {
			form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
		}  catch  (AlipayApiException e) {
			e.printStackTrace();
		}
		response.setContentType( "text/html;charset=UTF-8");
		response.getWriter().write(form); //直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
	}
}
