/** 
 * Project Name:shiroBoot 
 * File Name:UserController.java 
 * Package Name:com.hgl.controller 
 * Date:2019年12月7日下午5:23:28 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgl.common.JsonResult;
import com.hgl.service.IUserService;
import com.hgl.util.filter.JsonFilter;

/** 
* @author  Administrator
* @date 2019年12月7日 下午5:23:28 
* @version 1.0  
* @since   
*/
@RestController
@RequestMapping("/sys/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("filter")
	public JsonResult doFilter(@RequestBody JsonFilter filter) {
		return userService.filter(filter);
	}

}
