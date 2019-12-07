/** 
 * Project Name:shiroBoot 
 * File Name:RolesServiceImpl.java 
 * Package Name:com.hgl.service.impl 
 * Date:2019年12月7日下午7:23:40 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgl.common.JsonFilter;
import com.hgl.common.JsonResult;
import com.hgl.dao.RolesDao;
import com.hgl.entity.Roles;
import com.hgl.service.IRolesService;
import com.hgl.util.FilterUtil;

/** 
* @author  Administrator
* @date 2019年12月7日 下午7:23:40 
* @version 1.0  
* @since   
*/
@Service
public class RolesServiceImpl implements IRolesService {

	@Autowired
	private RolesDao rolesDao;
	
	/** 
	 * filter
	 *
	 * @param filter
	 * @return 
	 */
	@Override
	public JsonResult filter(JsonFilter<Roles> filter) {
		if(null == filter) {
			return JsonResult.fail("参数为空", null);
		}
		List<Roles> data = new FilterUtil<Roles>().filter(rolesDao, filter, Roles.class);
		return JsonResult.success("success", data);
	}

}
