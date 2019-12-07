/** 
 * Project Name:shiroBoot 
 * File Name:RolesDao.java 
 * Package Name:com.hgl.dao 
 * Date:2019年12月7日下午7:24:47 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hgl.entity.Roles;

/** 
* @author  Administrator
* @date 2019年12月7日 下午7:24:47 
* @version 1.0  
* @since   
*/
public interface RolesDao extends JpaRepository<Roles, Long>, JpaSpecificationExecutor<Roles> {

}
