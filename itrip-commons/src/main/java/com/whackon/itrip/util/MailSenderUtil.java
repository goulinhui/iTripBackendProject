package com.whackon.itrip.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * <b>邮件发送工具类</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since
 * 1.0.0
 */
@Component("mailSenderUtil")
public class MailSenderUtil {
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * <b>通过注册用户邮箱地址发送激活码邮件</b>
	 * @param email
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	public boolean sendActiveCodeMail(String email,String activeCode) throws Exception{
		try {
			//可以使用带有HTML样式的邮件
			MimeMessage mailMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true);
			//设置发件人邮箱地址
			messageHelper.setFrom("goulinhui@163.com");
			//设置抄送人地址
			messageHelper.setCc("goulinhui@163.com");
			//设置收件人地址
			messageHelper.setTo(email);
			//设置邮件主题
			messageHelper.setSubject("爱旅行-用户注册激活码");
			//设定发送信息字符串
			String content = "<div>亲爱的&nbsp;" + email + "&nbsp;你好:<br>" +
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>" +
					"感谢您注册为爱旅行会员！</div><div><br>以下是您的会员激活码：" +
					"<span style='font-size: 24px;'><b>" + activeCode + "</b></span></div>" +
					"<div>请在<span style='font-size: 24px;'><b>30分钟</b></span>内登录网站进行激活！！！</div>" +
					"<div>&nbsp; &nbsp; &nbsp;&nbsp;</div>";
			//设置发送邮件的内容
			mailMessage.setText(content);
			//发送邮件
			mailSender.send(mailMessage);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
