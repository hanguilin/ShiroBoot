/** 
 * Project Name:shiroBoot 
 * File Name:ExcceptionAdvice.java 
 * Package Name:com.hgl.exception 
 * Date:2019年12月7日下午3:28:52 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hgl.common.JsonResult;

/** 
* @author  Administrator
* @date 2019年12月7日 下午3:28:52 
* @version 1.0  
* @since   
*/

@RestControllerAdvice
public class ExcceptionAdvice {

	@ExceptionHandler(ServiceException.class)
	public JsonResult doCatch(ServiceException e) {
		return JsonResult.fail(e.getMessage(), null);
	}
}
