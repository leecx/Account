package com.bysj.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

/**
 * 发送验证码短信
 * http://www.miaodiyun.com/doc/status_code.html
 * @author created by licx
 * @data 2017年5月16日---下午12:51:36
 */
public class SendSMS {
	
	private static final Logger LOGGER = Logger.getLogger(SendSMS.class);
	
	private static final String accountSid = "7f7c3a4528ea44a2a2d620559e18687a";

	private static final String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

	public static boolean send(String code, String phone) {
		// 时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());

		// 签名
		String sig = DigestUtils.md5Hex(accountSid
				+ "e4648f114a2e41299870a16ca71670cb" + timestamp);

		Map<String, String> param = new HashMap<String, String>();

		param.put("accountSid", accountSid);
		param.put("smsContent", "【CX科技】验证码：" + code + "，打死都不要告诉别人哦！");
		param.put("to", phone);
		param.put("timestamp", timestamp);
		param.put("sig", sig);
		param.put("respDataType", "json");
		//执行发送短信，返回结果集
		String response = HttpClientUtil.doPost(url, param);
		Map<String, String> map = JsonUtils.jsonToMap(response);
		/*{
			"respCode":"00000",
			"failCount":"1",
			"failList":
			[
    			{
        			"phone":"13896543210",
        			"respCode":"00111"
    			}
			],
			"smsId":"913945fec0204b1e94baa75a5c013f59"
		}*/
		if(map.get("respCode").equals("00000")){   //发送成功
			return true;
		}
		LOGGER.error("错误码："+map.get("respCode")+",验证码发送失败");
		return false;
	}
}
