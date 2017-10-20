package com.tianjs.bps.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;

public class CsBdInvestB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String bdId;
	private String sysPubBdId;
	private String oldestInvestDt;
	private String oldestProdId;
	private String sta;
	private BigDecimal bdAmt;
	private BigDecimal bidAmt;
	private String ciDueDt;
	private Integer version;

	public BigDecimal getBdAmt() {
		return this.bdAmt;
	}
	public void setBdAmt(BigDecimal bdAmt) {
		this.bdAmt = bdAmt;
	}

	
	public String getBdId() {
		return this.bdId;
	}
	public void setBdId(String bdId) {
		this.bdId = bdId;
	}

	

	public BigDecimal getBidAmt() {
		return this.bidAmt;
	}
	public void setBidAmt(BigDecimal bidAmt) {
		this.bidAmt = bidAmt;
	}


	public String getCiDueDt() {
		return this.ciDueDt;
	}
	public void setCiDueDt(String ciDueDt) {
		this.ciDueDt = ciDueDt;
	}

	
	public String getOldestInvestDt() {
		return this.oldestInvestDt;
	}
	public void setOldestInvestDt(String oldestInvestDt) {
		this.oldestInvestDt = oldestInvestDt;
	}

	public String getOldestProdId() {
		return this.oldestProdId;
	}
	public void setOldestProdId(String oldestProdId) {
		this.oldestProdId = oldestProdId;
	}

	
	
	public String getSta() {
		return this.sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}

	public String getSysPubBdId() {
		return this.sysPubBdId;
	}
	public void setSysPubBdId(String sysPubBdId) {
		this.sysPubBdId = sysPubBdId;
	}


	public Integer getVersion() {
		return this.version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	

	public String toString() {
		return new ToStringBuilder(this)
					.append("bdId", this.getBdId())
					.toString();
	}
	public CsBdInvestB() {
		super();
	}
	public CsBdInvestB(String bdId,  String sysPubBdId, String oldestInvestDt,
			String oldestProdId, String sta, BigDecimal bdAmt, BigDecimal bidAmt, String ciDueDt, 
			Integer version) {
		super();
		this.bdId = bdId;
		this.sysPubBdId = sysPubBdId;
		this.oldestInvestDt = oldestInvestDt;
		this.oldestProdId = oldestProdId;
		this.sta = sta;
		this.bdAmt = bdAmt;
		this.bidAmt = bidAmt;
		this.ciDueDt = ciDueDt;
		this.version = version;
	}

	
}