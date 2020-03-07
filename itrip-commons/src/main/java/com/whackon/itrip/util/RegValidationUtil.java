package com.whackon.itrip.util;

/**
 * <b>爱旅行-使用正则验证工具类</b>
 */
public class RegValidationUtil {
	//设置电子邮件正则表达式
	private static final  String eamilRegEx="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

	/**
	 * <b>判断电子邮件是否格式正确</b>
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email) {
		//判断此时的email地址不能为null,并且不能是空字符串
		if(email != null && ! "".equals(email)){
			return email.matches(eamilRegEx);
		}
		return false;
	}

	public static void main(String[] args) {
		String email = "123@163.com";
		System.out.println(validateEmail(email));
	}
}
