/** 
 * Project Name:shiroBoot 
 * File Name:UserServiceImpl.java 
 * Package Name:com.hgl.service.impl 
 * Date:2019年12月7日下午5:26:21 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.hgl.common.JsonResult;
import com.hgl.dao.UserDao;
import com.hgl.entity.User;
import com.hgl.service.IUserService;
import com.hgl.util.filter.FilterUtil;
import com.hgl.util.filter.JsonFilter;

/** 
* @author  Administrator
* @date 2019年12月7日 下午5:26:21 
* @version 1.0  
* @since   
*/
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;
	
	/** 
	 * filter
	 *
	 * @param filter
	 * @return 
	 */
	@Override
	public JsonResult filter(JsonFilter filter) {
		if(null == filter) {
			return JsonResult.fail("参数为空", null);
		}
		Page<User> page = new FilterUtil<User>().filter(userDao, filter, User.class);
		return JsonResult.success("success", page.getContent(), page.getTotalElements());
	}
}
