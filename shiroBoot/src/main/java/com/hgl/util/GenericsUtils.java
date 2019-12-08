/** 
 * Project Name:shiroBoot 
 * File Name:GenericsUtils.java 
 * Package Name:com.hgl.util 
 * Date:2019年12月7日下午8:47:37 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/** 
 * @author  Administrator
 * @date 2019年12月7日 下午8:47:37 
 * @version 1.0  
 * @since   
 */
public class GenericsUtils {  
	/**   
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型.   
	 * 如public BookManager extends GenricManager<Book>   
	 *   
	 * @param clazz The class to introspect   
	 * @return the first generic declaration, or <code>Object.class</code> if cannot be determined   
	 */  
	public static Class getSuperClassGenricType(Class clazz) {  
		return getSuperClassGenricType(clazz, 0);  
	}  

	/**   
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型.   
	 * 如public BookManager extends GenricManager<Book>   
	 *   
	 * @param clazz clazz The class to introspect   
	 * @param index the Index of the generic ddeclaration,start from 0.   
	 */  
	public static Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {  

		Type genType = clazz.getGenericSuperclass();  

		if (!(genType instanceof ParameterizedType)) {  
			return Object.class;  
		}  

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  

		if (index >= params.length || index < 0) {  
			return Object.class;  
		}  
		if (!(params[index] instanceof Class)) {  
			return Object.class;  
		}  
		return (Class) params[index];  
	}  
}  
