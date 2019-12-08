/** 
 * Project Name:shiroBoot 
 * File Name:FilterInput.java 
 * Package Name:com.hgl.util 
 * Date:2019年12月7日下午7:33:57 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.util.filter;
/** 
* @author  Administrator
* @date 2019年12月7日 下午7:33:57 
* @version 1.0  
* @since   
*/
public class FilterCompoment {
	
	private String field;
	
	private FilterType type;
	
	private String value;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public FilterType getType() {
		return type;
	}

	public void setType(FilterType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
