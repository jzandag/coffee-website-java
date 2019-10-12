package com.coffee.util;

import java.util.List;

import org.directwebremoting.annotations.DataTransferObject;

import com.google.gson.annotations.Expose;

/**
 * @author Ross Zarsuela
 */
@DataTransferObject
public class Page {

	@Expose
	private List<?> content;
	@Expose
	private Integer currentPage;
	@Expose
	private Integer totalPages;
	@Expose
	private Integer actualSize;
	@Expose
	private Integer totalRecords;
	@Expose
	private Integer sizePerPage;
	@Expose
	private Integer totalInventoryCount;
	public static final Integer PAGE_BEGIN = 1;
	public static final Integer PAGE_SIZE = 5;

	public Page() {
	}

	public Page(List<?> content, Integer currentPage, Integer totalPages,
			Integer actualSize, Integer sizePerPage) {
		this.content = content;
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.actualSize = actualSize;
		this.sizePerPage = sizePerPage;
	}

	public List<?> getContent() {
		return content;
	}

	public Integer getCurrentPage() {
		if (currentPage.equals(0)) {
			currentPage = 1;
		}
		return currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public Integer getActualSize() {
		return actualSize;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public Integer getSizePerPage() {
		return sizePerPage;
	}

	public Integer getLeftRange() {

		if (InventoryUtility.isEmpty(this.currentPage, this.sizePerPage)) {
			return 0;
		}

		return ((this.currentPage - 1) * this.sizePerPage) + 1;
	}

	public Integer getRightRange() {

		if (InventoryUtility.isEmpty(this.actualSize)) {
			return 0;
		}

		return getLeftRange() - 1 + this.actualSize;
	}

	public void setContent(List<?> content) {
		this.content = content;
		this.actualSize = InventoryUtility.hasEmpty(content) ? 0 : content
				.size();
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public void setActualSize(Integer actualSize) {
		this.actualSize = actualSize;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public void setSizePerPage(Integer sizePerPage) {
		this.sizePerPage = sizePerPage;
	}

	public Integer getTotalInventoryCount() {
		return totalInventoryCount;
	}

	public void setTotalInventoryCount(Integer totalInventoryCount) {
		this.totalInventoryCount = totalInventoryCount;
	}

}