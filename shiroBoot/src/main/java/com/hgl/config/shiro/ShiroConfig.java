/** 
 * Project Name:shiroBoot 
 * File Name:ShiroConfig.java 
 * Package Name:com.hgl.config.shiro 
 * Date:2019年12月7日下午3:17:18 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.config.shiro;

import java.util.LinkedHashMap;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.google.common.collect.Maps;

/** 
* @author  Administrator
* @date 2019年12月7日 下午3:17:18 
* @version 1.0  
* @since   
*/
@Configuration
public class ShiroConfig {
	
	/**
	 * 配置shiro的SecurityManager
	 */
	@Bean("securityManager")
	public SecurityManager newSecurityManager(@Autowired AuthorizingRealm realm) {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		//通过realm访问数据库
		sManager.setRealm(realm);
		//注入Cookie管理器
		//sManager.setRememberMeManager(newCookieRememberMeManager());
		return sManager;
	}

	/**
	 * 配置ShiroFilterFactory工厂
	 * @param securityManager
	 * @return
	 */
	@Bean("shiroFilterFactoryBean")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean filterBean = new ShiroFilterFactoryBean();
		filterBean.setSecurityManager(securityManager);

		LinkedHashMap<String, Filter> filterMap = Maps.newLinkedHashMap();
		filterMap.put("authc", new CustomShiroFilter());
		filterBean.setFilters(filterMap);
		
		LinkedHashMap<String,String> fcMap = Maps.newLinkedHashMap();
		// fcMap.put("/bower_components/**","anon");//anon表示允许匿名访问
//		fcMap.put("/doLogout.do ","logout");
		// authc表示访问该地址用户必须身份验证通过
		//user表示访问该地址的用户是身份验证通过或RememberMe登录
//		fcMap.put("/**", "authc");
		filterBean.setFilterChainDefinitionMap(fcMap);
		return filterBean;
	}
	/***
	 * 配置shiro框架组件的生命周期管理对象
	 * @return
	 */
	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor newLifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}

	/**配置负责为Bean对象(需要授权访问的方法所在的对象)
	 * 创建代理对象的Bean组件*/
	@DependsOn(value="lifecycleBeanPostProcessor")
	@Bean
	public DefaultAdvisorAutoProxyCreator newDefaultAdvisorAutoProxyCreator(){
		return new DefaultAdvisorAutoProxyCreator();
	}
	
	/**
	 * 配置授权属性应用对象(在执行授权操作时需要用到此对象)
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor newAuthorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor bean = new AuthorizationAttributeSourceAdvisor();
		bean.setSecurityManager(securityManager);
		return bean;
	}
}
