/** 
 * Project Name:api-utils 
 * File Name:RestResult.java 
 * Package Name:com.hanguilin.apiutils.returns 
 * Date:2019年10月3日下午12:06:18 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.common;
/** 
* @author  Administrator
* @date 2019年10月3日 下午12:06:18 
* @version 1.0  
* @since   
*/
public class JsonResult {
	
	private int code;
	
	private String msg;
	
	private Object data;
	
	private Long count;
	
	public JsonResult() {
		super();
	}
	
	public JsonResult(int code, String msg, Object data, Long count) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.count = count;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static JsonResult success(String msg, Object data) {
		return new JsonResult(ErrorCode.SUCCESS, msg, data, null);
	}
	
	public static JsonResult success(String msg, Object data, Long count) {
		return new JsonResult(ErrorCode.SUCCESS, msg, data, count);
	}
	
	public static JsonResult fail(String msg, Object data) {
		return new JsonResult(ErrorCode.FAIL, msg, data, null);
	}
	
	public static JsonResult fail(String msg, Object data, Long count) {
		return new JsonResult(ErrorCode.FAIL, msg, data, count);
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
}
