/** 
 * Project Name:shiroBoot 
 * File Name:IMenusService.java 
 * Package Name:com.hgl.service 
 * Date:2019年12月7日下午7:18:04 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.service;

import com.hgl.common.JsonFilter;
import com.hgl.common.JsonResult;
import com.hgl.entity.Menus;

/** 
* @author  Administrator
* @date 2019年12月7日 下午7:18:04 
* @version 1.0  
* @since   
*/
public interface IMenusService {

	/** 
	 * filter
	 *
	 * @param filter
	 * @return 
	 */
	JsonResult filter(JsonFilter<Menus> filter);

}
