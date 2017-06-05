package com.bysj.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bysj.pojo.User;
import com.bysj.pojo.result.Result;
import com.bysj.utils.JsonUtils;

/**
 *@author  created by licx
 *@data    2017年6月5日---下午2:53:41
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
			return true;
		}else{
			PrintWriter out = null;
			try{
				Result result = Result.notLogin();
				String resultOfJson = JsonUtils.objectToJson(result);
				response.setContentType("application/json;charset=utf-8");
				out = response.getWriter();
				out.append(resultOfJson);
			}finally{
				out.close();
			}
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
