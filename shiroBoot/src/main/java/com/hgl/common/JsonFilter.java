/** 
 * Project Name:shiroBoot 
 * File Name:JsonFilter.java 
 * Package Name:com.hgl.common 
 * Date:2019年12月7日下午5:21:07 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.common;
/** 
* @author  Administrator
* @date 2019年12月7日 下午5:21:07 
* @version 1.0  
* @since   
*/
public class JsonFilter<T> {
	
	private T filterObj;
	
	private Integer page;
	
	private Integer pageSize;
	
	private String sortField;
	
	private String sortOrder;
	
	private String searchWords;

	public T getFilterObj() {
		return filterObj;
	}

	public void setFilterObj(T filterObj) {
		this.filterObj = filterObj;
	}

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
	
}
