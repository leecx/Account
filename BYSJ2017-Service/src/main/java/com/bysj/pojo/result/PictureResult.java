package com.bysj.pojo.result;
/**
 *@author  created by licx
 *@data    2017年5月18日---上午9:58:01
 */
public class PictureResult {

	/**
	 * 上传图片返回值，成功：200	失败：404	
	 */
	private Integer error;
	/**
	 * 回显图片使用的url
	 */
	private String url;
	/**
	 * 错误时的错误消息
	 */
	private String message;
	public PictureResult(Integer state, String url) {
		this.url = url;
		this.error = state;
	}
	public PictureResult(Integer state, String url, String errorMessage) {
		this.url = url;
		this.error = state;
		this.message = errorMessage;
	}
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

