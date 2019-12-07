/** 
 * Project Name:shiroBoot 
 * File Name:CustomWebMvcConfig.java 
 * Package Name:com.hgl.config 
 * Date:2019年12月7日下午3:13:22 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/** 
* @author  Administrator
* @date 2019年12月7日 下午3:13:22 
* @version 1.0  
* @since   
*/
@Configuration
public class CustomWebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		super.addCorsMappings(registry);
		registry.addMapping("/").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
	}

}
