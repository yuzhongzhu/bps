package com.tianjs.bps.io.vo;

public class OutOrderVo extends Page {
	private String productCd;
	private String outRegisterTm;
	private String outBatchNo;
	private String id;
	private String sta;
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	
	public String getOutRegisterTm() {
		return outRegisterTm;
	}
	public void setOutRegisterTm(String outRegisterTm) {
		this.outRegisterTm = outRegisterTm;
	}
	public String getOutBatchNo() {
		return outBatchNo;
	}
	public void setOutBatchNo(String outBatchNo) {
		this.outBatchNo = outBatchNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
}
