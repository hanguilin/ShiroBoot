/** 
 * Project Name:shiroBoot 
 * File Name:UserDao.java 
 * Package Name:com.hgl.dao 
 * Date:2019年12月7日下午3:43:29 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hgl.entity.User;

/** 
* @author  Administrator
* @date 2019年12月7日 下午3:43:29 
* @version 1.0  
* @since   
*/
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	/** 
	 * findByUserName
	 *
	 * @param userName
	 * @return User
	 */
	User findByUserName(String userName);

}
