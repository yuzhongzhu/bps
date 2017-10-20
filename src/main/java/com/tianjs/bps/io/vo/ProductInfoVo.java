package com.tianjs.bps.io.vo;

import java.math.BigDecimal;

public class ProductInfoVo extends Page {
	private String productCd;
	private String productNm;
	private BigDecimal basePrice;//进价
	private BigDecimal price;//预定售价
	private String unit;//计数单位
	private String id;
	private String param;
	
	
	
	
	
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	public String getProductNm() {
		return productNm;
	}
	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
