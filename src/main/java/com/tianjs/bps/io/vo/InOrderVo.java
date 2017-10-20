package com.tianjs.bps.io.vo;

import java.math.BigDecimal;

public class InOrderVo {
	private String productCd;
	private String productNm;
	private BigDecimal inSumAmt;
	private Integer inCount;
	private BigDecimal basePrice;
	private String batchNo;
	private String prdAddress;
	private String rmk;
	private String inRegisterTm;
	
	private String id;
	
	
	
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
	public BigDecimal getInSumAmt() {
		return inSumAmt;
	}
	public void setInSumAmt(BigDecimal inSumAmt) {
		this.inSumAmt = inSumAmt;
	}
	public Integer getInCount() {
		return inCount;
	}
	public void setInCount(Integer inCount) {
		this.inCount = inCount;
	}
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getPrdAddress() {
		return prdAddress;
	}
	public void setPrdAddress(String prdAddress) {
		this.prdAddress = prdAddress;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getInRegisterTm() {
		return inRegisterTm;
	}
	public void setInRegisterTm(String inRegisterTm) {
		this.inRegisterTm = inRegisterTm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
