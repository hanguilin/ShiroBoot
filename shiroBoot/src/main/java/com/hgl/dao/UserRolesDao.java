/** 
 * Project Name:shiroBoot 
 * File Name:UserRolesDao.java 
 * Package Name:com.hgl.dao 
 * Date:2019年12月7日下午3:43:54 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hgl.entity.UserRoles;

/** 
* @author  Administrator
* @date 2019年12月7日 下午3:43:54 
* @version 1.0  
* @since   
*/
public interface UserRolesDao extends JpaRepository<UserRoles, Long> {

	/** 
	 * findRoleIdByUserId
	 *
	 * @param id
	 * @return 
	 */
	List<Long> findRoleIdByUserId(Long id);

}
