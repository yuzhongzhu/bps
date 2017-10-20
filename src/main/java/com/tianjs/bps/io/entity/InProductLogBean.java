package com.tianjs.bps.io.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class InProductLogBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String batchId;
	private String batchNo;
	private String productCd;
	private Integer inCount;
	private String inRegisterTm;
	private String productAddress;
	private BigDecimal inAmout;
	private BigDecimal basePrice;
	private String rmk;
	
	
	
	
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	
	public String getInRegisterTm() {
		return inRegisterTm;
	}
	public void setInRegisterTm(String inRegisterTm) {
		this.inRegisterTm = inRegisterTm;
	}
	public String getProductAddress() {
		return productAddress;
	}
	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress;
	}
	
	public Integer getInCount() {
		return inCount;
	}
	public void setInCount(Integer inCount) {
		this.inCount = inCount;
	}
	public BigDecimal getInAmout() {
		return inAmout;
	}
	public void setInAmout(BigDecimal inAmout) {
		this.inAmout = inAmout;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	
	
}
