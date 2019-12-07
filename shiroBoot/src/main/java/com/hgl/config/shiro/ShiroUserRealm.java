/** 
 * Project Name:shiroBoot 
 * File Name:ShiroUserRealm.java 
 * Package Name:com.hgl.config.shiro 
 * Date:2019年12月7日下午3:21:31 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.config.shiro;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgl.dao.MenusDao;
import com.hgl.dao.RoleMenusDao;
import com.hgl.dao.UserDao;
import com.hgl.dao.UserRolesDao;
import com.hgl.entity.User;
import com.hgl.exception.ServiceException;

/**
 * Shiro框架中核心业务组件之一
 * 通过此对象可以完成数据业务的获取以及封装
 * @author Administrator
 *
 */
@Service
public class ShiroUserRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRolesDao userRolesDao;
	
	@Autowired
	private RoleMenusDao roleMenusDao;
	
	@Autowired
	private MenusDao menusDao;
	
	/**
	 * 设置凭证匹配器(CredentialsMatcher)
	 * 
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		//设置加密的次数(这个次数应该与保存密码时那个加密次数一致)
		cMatcher.setHashIterations(5);
		super.setCredentialsMatcher(cMatcher);
	}

	/**
	 * 在此方法中完成认证信息的获取以及封装
	 * 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.获取用户身份信息(例如用户名)
		String username = (String) token.getPrincipal();
		//2.基于用户名从数据库查询记录
		User user = userDao.findByUserName(username);
		//3.对查询结果进行验证,用户不存在会报异常
		if(user == null) {
			throw new AuthenticationException("此用户不存在");
		}
		if(user.getValid()==0)
			throw new AuthenticationException("此用户已被禁用");
		//4.对数据库查询出的相关信息进行封装
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user,//principal 用户身份
				user.getPassword(),//hashedCredentials已加密的凭证
				credentialsSalt,//credentialsSalt 密码加密时使用的盐
				getName());//realmName 当前方法所在对象的名字
		//5.返回封装结果(传递给认证管理器)
		return info;
	}

	/**
	 * 在此方法中完成授权信息的获取以及封装
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1.获取登录用户具有的权限信息
		//1.1获取用户身份对象
		User user = (User) principals.getPrimaryPrincipal();
		//1.2基于用户id获取角色id(可能多个):查中间表admin_roles;
		List<Long> roleIds = userRolesDao.findRoleIdByUserId(user.getId());
		if(roleIds.isEmpty()) {
			throw new ServiceException("当前用户未分配角色");
		}
		//1.3基于角色id获取菜单id(可能多个):查中间表role_menus;
		//menuIds可能重复
		List<Long> menuIds = roleMenusDao.findMenuIdByRoleIdIn(roleIds);
		if(menuIds.isEmpty()) {
			throw new ServiceException("当前用户角色未分配菜单");
		}
		//1.4基于菜单获取权限标识("sys:user:view"):查menus;
		List<String> permissions = menusDao.findPermissionByIdIn(menuIds);
		if(permissions.isEmpty()) {
			throw new ServiceException("当前用户角色没有可操作权限");
		}
		//2.权限信息去重和去空
		Set<String> permissionsSet = permissions.stream().filter(o->StringUtils.isNotBlank(o)).distinct().collect(Collectors.toSet());
		//3.对权限信息进行封装
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permissionsSet);
		//4.返回封装结果
		return info;
	}

}

