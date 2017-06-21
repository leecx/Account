package com.bysj.utils;

import java.util.Map;
import org.apache.log4j.Logger;
import com.bysj.pojo.result.Result;

/**
 * 发送验证码短信 http://www.miaodiyun.com/doc/status_code.html
 * 
 * @author created by licx
 * @data 2017年5月16日---下午12:51:36
 */
public class SendSMS_new {

	private static final Logger LOGGER = Logger.getLogger(SendSMS_new.class);

	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;

	public static Result send (String code, String phone)throws Exception {

			String smsContent = "【CX科技】验证码：" + code + "，打死都不要告诉别人哦！";

			String url = Config.BASE_URL + operation;
			String body = "accountSid=" + accountSid + "&to=" + phone
					+ "&smsContent=" + smsContent
					+ HttpUtil.createCommonParam();
			
			String response = HttpUtil.post(url, body);
			Map<String, String> map = JsonUtils.jsonToMap(response);
			/*
			 * { "respCode":"00000", "failCount":"1", "failList": [ {
			 * "phone":"13896543210", "respCode":"00111" } ],
			 * "smsId":"913945fec0204b1e94baa75a5c013f59" }
			 */
			if (map!=null&&map.get("respCode").equals("00000")) { // 发送成功
				return new Result(200, code);
			}
			//LOGGER.error("错误码：" + map.get("respCode") + ",验证码发送失败");
			return new Result(404, "失败");
	}
}
