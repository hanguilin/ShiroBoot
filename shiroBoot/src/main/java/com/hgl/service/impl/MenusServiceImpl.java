/** 
 * Project Name:shiroBoot 
 * File Name:MenusServiceImpl.java 
 * Package Name:com.hgl.service.impl 
 * Date:2019年12月7日下午7:19:20 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgl.common.JsonFilter;
import com.hgl.common.JsonResult;
import com.hgl.dao.MenusDao;
import com.hgl.entity.Menus;
import com.hgl.service.IMenusService;
import com.hgl.util.FilterUtil;

/** 
* @author  Administrator
* @date 2019年12月7日 下午7:19:20 
* @version 1.0  
* @since   
*/
@Service
public class MenusServiceImpl implements IMenusService {

	@Autowired
	private MenusDao menusDao;
	
	/** 
	 * filter
	 *
	 * @param filter
	 * @return 
	 */
	@Override
	public JsonResult filter(JsonFilter<Menus> filter) {
		if(null == filter) {
			return JsonResult.fail("参数为空", null);
		}
		List<Menus> data = new FilterUtil<Menus>().filter(menusDao, filter, Menus.class);
		return JsonResult.success("success", data);
	}

}
