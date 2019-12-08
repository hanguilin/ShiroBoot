/** 
 * Project Name:shiroBoot 
 * File Name:JsonFilter.java 
 * Package Name:com.hgl.common 
 * Date:2019年12月7日下午5:21:07 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.util.filter;

import java.util.List;

/** 
* @author  Administrator
* @date 2019年12月7日 下午5:21:07 
* @version 1.0  
* @since   
*/
public class JsonFilter {
	
	private List<FilterCompoment> rules;
	
	private Integer page;
	
	private Integer pageSize;
	
	private String sortField;
	
	private String sortOrder;
	
	private String searchWords;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}

	public List<FilterCompoment> getRules() {
		return rules;
	}

	public void setRules(List<FilterCompoment> rules) {
		this.rules = rules;
	}
}
