/** 
 * Project Name:shiroBoot 
 * File Name:IRolesService.java 
 * Package Name:com.hgl.service 
 * Date:2019年12月7日下午7:23:07 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.service;

import com.hgl.common.JsonResult;
import com.hgl.util.filter.JsonFilter;

/** 
* @author  Administrator
* @date 2019年12月7日 下午7:23:07 
* @version 1.0  
* @since   
*/
public interface IRolesService {

	/** 
	 * filter
	 *
	 * @param filter
	 * @return 
	 */
	JsonResult filter(JsonFilter filter);

}
