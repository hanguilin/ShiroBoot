/** 
 * Project Name:shiroBoot 
 * File Name:MenusController.java 
 * Package Name:com.hgl.controller 
 * Date:2019年12月7日下午7:17:14 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgl.common.JsonFilter;
import com.hgl.common.JsonResult;
import com.hgl.entity.Roles;
import com.hgl.service.IRolesService;

/** 
* @author  Administrator
* @date 2019年12月7日 下午7:17:14 
* @version 1.0  
* @since   
*/
@RestController
@RequestMapping("/sys/roles")
public class RolesController {
	
	@Autowired
	private IRolesService rolesService;
	
	@PostMapping("filter")
	public JsonResult doFilter(@RequestBody JsonFilter<Roles> filter) {
		return rolesService.filter(filter);
	}
}
