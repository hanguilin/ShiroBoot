/** 
 * Project Name:shiroBoot 
 * File Name:CustomShiroFilter.java 
 * Package Name:com.hgl.config.shiro 
 * Date:2019年12月7日下午3:18:02 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.config.shiro;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;

import com.alibaba.fastjson.JSON;
import com.hgl.common.ErrorCode;
import com.hgl.common.JsonResult;

/** 
* @author  Administrator
* @date 2019年12月7日 下午3:18:02 
* @version 1.0  
* @since   
*/
public class CustomShiroFilter extends UserFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		String json = JSON.toJSONString(new JsonResult(ErrorCode.ACCESS_DENIED, "请求拦截", null));
		PrintWriter writer = response.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
		return false;
	}
	
}
