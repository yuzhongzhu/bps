package com.tianjs.bps.io.entity;

public class IoMenuBean {
	private Integer id;
	private Integer parentId;
	private String menuNm;
	private String url;
	private Integer isUsable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIsUsable() {
		return isUsable;
	}
	public void setIsUsable(Integer isUsable) {
		this.isUsable = isUsable;
	}
	
	
	
}
