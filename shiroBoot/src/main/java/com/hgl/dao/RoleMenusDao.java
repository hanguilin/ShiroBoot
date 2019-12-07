/** 
 * Project Name:shiroBoot 
 * File Name:RoleMenusDao.java 
 * Package Name:com.hgl.dao 
 * Date:2019年12月7日下午3:44:20 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hgl.entity.RoleMenus;

/** 
* @author  Administrator
* @date 2019年12月7日 下午3:44:20 
* @version 1.0  
* @since   
*/
public interface RoleMenusDao extends JpaRepository<RoleMenus, Long> {

	/** 
	 * findMenuIdByRoleIdIn
	 *
	 * @param array
	 * @return 
	 */
	List<Long> findMenuIdByRoleIdIn(List<Long> roleIds);

}
