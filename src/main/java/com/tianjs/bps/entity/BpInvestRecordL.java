package com.tianjs.bps.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class BpInvestRecordL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String seqNo;
	private String investId;
	private String custId;
	private BigDecimal buyAmt;
	private BigDecimal costAmt;
	private BigDecimal promAmt;
	private BigDecimal disCountRate;
	private String bdId;
	private String traDt;
	private String traTm;
	private String oppCustId;
	private String lbDt;
	private String lbTm;
	private String isLbYn;
	private String lbOprId;
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getInvestId() {
		return investId;
	}
	public void setInvestId(String investId) {
		this.investId = investId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public BigDecimal getBuyAmt() {
		return buyAmt;
	}
	public void setBuyAmt(BigDecimal buyAmt) {
		this.buyAmt = buyAmt;
	}
	public BigDecimal getCostAmt() {
		return costAmt;
	}
	public void setCostAmt(BigDecimal costAmt) {
		this.costAmt = costAmt;
	}
	public BigDecimal getDisCountRate() {
		return disCountRate;
	}
	public void setDisCountRate(BigDecimal disCountRate) {
		this.disCountRate = disCountRate;
	}
	public String getBdId() {
		return bdId;
	}
	public void setBdId(String bdId) {
		this.bdId = bdId;
	}
	public String getTraDt() {
		return traDt;
	}
	public void setTraDt(String traDt) {
		this.traDt = traDt;
	}
	public String getTraTm() {
		return traTm;
	}
	public void setTraTm(String traTm) {
		this.traTm = traTm;
	}
	public String getOppCustId() {
		return oppCustId;
	}
	public void setOppCustId(String oppCustId) {
		this.oppCustId = oppCustId;
	}
	public String getLbDt() {
		return lbDt;
	}
	public void setLbDt(String lbDt) {
		this.lbDt = lbDt;
	}
	public String getLbTm() {
		return lbTm;
	}
	public void setLbTm(String lbTm) {
		this.lbTm = lbTm;
	}
	public String getIsLbYn() {
		return isLbYn;
	}
	public void setIsLbYn(String isLbYn) {
		this.isLbYn = isLbYn;
	}
	public String getLbOprId() {
		return lbOprId;
	}
	public void setLbOprId(String lbOprId) {
		this.lbOprId = lbOprId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BigDecimal getPromAmt() {
		return promAmt;
	}
	public void setPromAmt(BigDecimal promAmt) {
		this.promAmt = promAmt;
	}
	
	
	
}
