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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgl.common.JsonResult;
import com.hgl.service.IMenusService;

/** 
* @author  Administrator
* @date 2019年12月7日 下午7:17:14 
* @version 1.0  
* @since   
*/
@RestController
@RequestMapping("/sys/menus")
public class MenusController {
	
	@Autowired
	private IMenusService menusService;
	
	@GetMapping("list")
	public JsonResult doFilter() {
		return menusService.findList();
	}
}
