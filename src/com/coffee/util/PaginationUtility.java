package com.coffee.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author Ross Zarsuela
 */

public class PaginationUtility {

	/**
	 * Computes the current page given the 
	 * size per page, and begin index. 
	 */
	public static Integer getCurrentPage(Integer begin, Integer size) {
		
		if(begin == null || size == null)
			return 1;
		
		return getQuotient(begin * size, size);
	}
	
	/**
	 * Computes the total number of pages
	 * given the size per page and the total number of records.
	 */
	public static Integer getTotalPages(Integer totalRecords, Integer size) {
		
		return getQuotient(totalRecords, size);
	}
	
	private static Integer getQuotient(Integer dividend, Integer divisor) {
		if(InventoryUtility.hasEmpty(dividend, divisor))
			return 1;
		
		int quotient = (int) Math.ceil(dividend.doubleValue() / divisor.doubleValue());
		return quotient;	
	}
	
	public static Page getPage(Integer totalRecords, Integer size, Integer begin) {
		Integer totalPages = getTotalPages(totalRecords, size);
		Integer currentPage = getCurrentPage(begin, size);
		if(currentPage > totalPages) {
			currentPage = totalPages;
		}
		
		Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSizePerPage(size);
			page.setTotalPages(totalPages);
			page.setTotalRecords(totalRecords);
			
		return page;
	}
	
	public static synchronized String escapeApos(String str) {
		if(StringUtils.isNotEmpty(str) && !InventoryUtility.isNull(str) && str.contains("'")) {
			str = str.replace("'", "''");
		}
		return str;
	}
	
	public static synchronized String escapeComma(String str) {
		if(StringUtils.isNotEmpty(str) && !InventoryUtility.isNull(str) && str.contains(",")) {
			str = str.replace(",", "");
		}
		return str;
	}
	
	public static synchronized String escapeAposComma(String str) {
		str = escapeApos(str);
		str = escapeComma(str);
		return str;
	}
	
}