package com.chenxin.httpTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.bysj.utils.HttpClientUtil;

/**
 * @author created by licx
 * @data 2017年5月16日---上午11:09:27
 */
public class DuanxinTest {

	public static void main(String[] args) {
		
		// 时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());

		
		String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
		String accountSid = "7f7c3a4528ea44a2a2d620559e18687a";
		Map<String, String> param = new HashMap<String, String>();
		
		param.put("accountSid", accountSid);
		param.put("smsContent", "【CX科技】验证码：1234，打死都不要告诉别人哦！");
		param.put("to", "18580770052");
		// 签名
		String sig = DigestUtils.md5Hex(accountSid + "e4648f114a2e41299870a16ca71670cb" + timestamp);
		param.put("timestamp", timestamp);
		param.put("sig", sig);
		param.put("respDataType", "json");
		String response = HttpClientUtil.doPost(url, param);
		
		System.out.println(response);
	}
}
