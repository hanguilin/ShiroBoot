/** 
 * Project Name:shiroBoot 
 * File Name:FilterUtil.java 
 * Package Name:com.hgl.util 
 * Date:2019年12月7日下午6:56:11 
 * Copyright (c) 2019, hanguilin All Rights Reserved. 
 * 
 */
package com.hgl.util.filter;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.google.common.collect.Lists;
import com.hgl.util.PrivateUtils;
import com.hgl.util.VerifyUtil;

/** 
* @author  Administrator
* @date 2019年12月7日 下午6:56:11 
* @version 1.0  
* @since   
*/
public class FilterUtil<T> {
	
	private static final String ORDER_ASC = "asc";
	
	private static final String ORDER_FIELD_DEFAULT = "id";
	
	private static final Integer PAGE_SIZE_DEFAULT = 10;
	
	public Page<T> filter(JpaSpecificationExecutor<T> executor, JsonFilter filter, Class<T> clazz){
		if(VerifyUtil.isEmpty(filter)) {
			List<T> all = executor.findAll(null);
			return new PageImpl<T>(all, null, all.size());
		}
		Direction direction = ORDER_ASC.equals(filter.getSortOrder()) ? Direction.ASC : Direction.DESC;
		String filterSortField = StringUtils.isBlank(filter.getSortField()) ? ORDER_FIELD_DEFAULT : filter.getSortField();
		Sort sort = new Sort(direction, filterSortField);
		Integer page = filter.getPage();
		Integer pageSize = filter.getPageSize();
		Integer filterPage = (null == page || page < 1) ? 0 : page - 1;
		Integer filterPageSize = (null == pageSize || pageSize < 0) ? PAGE_SIZE_DEFAULT : pageSize;
		PageRequest pageRequest = new PageRequest(filterPage, filterPageSize, sort);
		Page<T> pageData = executor.findAll(spec(filter, clazz), pageRequest);
		return pageData;
	}
	
	private Specification<T> spec(JsonFilter filter, Class<T> clazz) {
		return new Specification<T>() {
			
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				List<String> filedColumns = PrivateUtils.getEntityFieldNames(clazz);
				List<Predicate> predicates = Lists.newArrayList();
				if(!VerifyUtil.isEmpty(filter.getRules())) {
					List<Predicate> and = Lists.newArrayList();
					List<FilterCompoment> rules = filter.getRules();
					rules.forEach(rule -> {
						String field = rule.getField();
						if(filedColumns.contains(field)) {
							FilterType type = rule.getType();
							String value = rule.getValue();
							switch (type) {
								case EQ :
									and.add(cb.equal(root.get(field).as(String.class), value));
									break;
								case NE :
									and.add(cb.notEqual(root.get(field).as(String.class), value));
									break;
								case GT :
									and.add(cb.greaterThan(root.get(field).as(String.class), value));
									break;
								case GTE :
									and.add(cb.greaterThanOrEqualTo(root.get(field).as(String.class), value));
									break;
								case LT :
									and.add(cb.lessThanOrEqualTo(root.get(field).as(String.class), value));
									break;
								case LTE :
									and.add(cb.lessThanOrEqualTo(root.get(field).as(String.class), value));
									break;
								case LIKE :
									and.add(cb.like(root.get(field).as(String.class), "%" + value + "%"));
									break;
								case NL :
									and.add(cb.notLike(root.get(field).as(String.class), "%" + value + "%"));
									break;
								default :
									break;
							}
							Predicate[] andList = new Predicate[and.size()];
							Predicate predicate = cb.and(and.toArray(andList));
							predicates.add(predicate);
						}
					});
				}
				String searchWords = filter.getSearchWords();
				if(StringUtils.isNotBlank(searchWords)) {
					List<Predicate> or = Lists.newArrayList();
					filedColumns.forEach(name -> {
						or.add(cb.like(root.get(name).as(String.class), "%" + searchWords + "%"));
					});
					Predicate[] orList = new Predicate[or.size()];
					Predicate predicate = cb.or(or.toArray(orList));
					predicates.add(predicate);
				}
				Predicate[] list = new Predicate[predicates.size()];
				return cb.and(predicates.toArray(list));
			}
		};
	}
}
