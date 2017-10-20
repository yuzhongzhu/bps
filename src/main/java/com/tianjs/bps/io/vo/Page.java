package com.tianjs.bps.io.vo;

public class Page {
	
	public Integer totalRows =0;
	public Integer curPageNum = 1	;
	public Integer pageSize = 10;
	public Integer startRow = 0;
	
	
	
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow() {
		this.startRow = (curPageNum-1)*pageSize;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	public Integer getCurPageNum() {
		return curPageNum;
	}
	public void setCurPageNum(Integer curPageNum) {
		this.curPageNum = curPageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
