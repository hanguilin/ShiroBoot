/** 
 * Project Name:shiroBoot 
 * File Name:IUserService.java 
 * Package Name:com.hgl.service 
 * Date:2019年12月7日下午5:25:36 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.service;

import com.hgl.common.JsonFilter;
import com.hgl.common.JsonResult;
import com.hgl.entity.User;

/** 
* @author  Administrator
* @date 2019年12月7日 下午5:25:36 
* @version 1.0  
* @since   
*/
public interface IUserService {

	/** 
	 * filter
	 *
	 * @param filter
	 * @return 
	 */
	JsonResult filter(JsonFilter<User> filter);

}
