/** 
 * Project Name:shiroBoot 
 * File Name:MenusDao.java 
 * Package Name:com.hgl.dao 
 * Date:2019年12月7日下午3:44:43 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hgl.entity.Menus;

/** 
* @author  Administrator
* @date 2019年12月7日 下午3:44:43 
* @version 1.0  
* @since   
*/
public interface MenusDao extends JpaRepository<Menus, Long>, JpaSpecificationExecutor<Menus> {

	/** 
	 * findPermissionByMenuIdIn
	 *
	 * @param menuIds
	 * @return 
	 */
	List<String> findPermissionByIdIn(List<Long> menuIds);

}
