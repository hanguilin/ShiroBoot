/** 
 * Project Name:shiroBoot 
 * File Name:IMenusService.java 
 * Package Name:com.hgl.service 
 * Date:2019年12月7日下午7:18:04 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.service;

import com.hgl.common.JsonResult;
import com.hgl.entity.Menus;
import com.hgl.util.filter.JsonFilter;

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
	JsonResult filter(JsonFilter filter);

	/** 
	 * findList
	 *
	 * @return 
	 */
	JsonResult findList();

}
