/** 
 * Project Name:shiroBoot 
 * File Name:ServiceException.java 
 * Package Name:com.hgl.exception 
 * Date:2019年12月7日下午3:26:22 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.exception;

/** 
* @author  Administrator
* @date 2019年12月7日 下午3:26:22 
* @version 1.0  
* @since   
*/
public class ServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public ServiceException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
	
}
