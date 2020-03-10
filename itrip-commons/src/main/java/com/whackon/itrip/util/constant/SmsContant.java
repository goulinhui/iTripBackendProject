package com.whackon.itrip.util.constant;



import java.util.Properties;

public class SmsContant {
	private static final Properties prpos = new Properties();

	static {
		try {
			prpos.load(SmsContant.class.getClassLoader().getResourceAsStream("prpo/sms.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static final String SMS_ADDRESS = prpos.getProperty("sms.address");

	public static final String SMS_PORT = prpos.getProperty("sms.port");

	public static final String SMS_ACCOUNTSID = prpos.getProperty("sms.accountsid");

	public static final String SMS_ACCOUNTTOKEN = prpos.getProperty("sms.accounttoken");

	public static final String SMS_APPID = prpos.getProperty("sms.appid");

	public static final String SMS_TEMPID = prpos.getProperty("sms.tempid");
}

