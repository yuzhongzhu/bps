package com.tianjs.bps.io.entity;

import java.math.BigDecimal;

public class OutProductLogBean {
	private String id;
	private String outBatchNo;
	private String outRegisterTm;
	private String productCd;
	private String productNm;
	private Integer outCount;
	private BigDecimal salePrice;
	private BigDecimal disCount;
	private BigDecimal outSumAmt;
	private String rmk;
	private String sta;
	
	
	
	
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOutBatchNo() {
		return outBatchNo;
	}
	public void setOutBatchNo(String outBatchNo) {
		this.outBatchNo = outBatchNo;
	}
	public String getOutRegisterTm() {
		return outRegisterTm;
	}
	public void setOutRegisterTm(String outRegisterTm) {
		this.outRegisterTm = outRegisterTm;
	}
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	
	public Integer getOutCount() {
		return outCount;
	}
	public void setOutCount(Integer outCount) {
		this.outCount = outCount;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public BigDecimal getDisCount() {
		return disCount;
	}
	public void setDisCount(BigDecimal disCount) {
		this.disCount = disCount;
	}
	public BigDecimal getOutSumAmt() {
		return outSumAmt;
	}
	public void setOutSumAmt(BigDecimal outSumAmt) {
		this.outSumAmt = outSumAmt;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getProductNm() {
		return productNm;
	}
	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	
	
	
}
