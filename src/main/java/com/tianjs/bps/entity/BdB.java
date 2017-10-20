package com.tianjs.bps.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BdB implements Serializable {
		private static final long serialVersionUID = 1L;
		/**
		 * 产品标识
		 */
		private String id;
		/**
		 * 产品子分类
		 */
		private String prodId;
		/**
		 * 原产品编号
		 */
		private String oldestProdId;
		/**
		 * 产品名称
		 */
		private String bdNm;
		/**
		 * 产品描述
		 */
		private String bdDesp;
		/**
		 * 计息模式
		 */
		private String bdCiMod;
		/**
		 * 计息开始天数
		 */
		private Integer bdCiStartDayCnt;
		/**
		 * 标的募集开始日期
		 */
		private String bdStartDt;
		/**
		 * 标的募集开始时间
		 */
		private String bdStartTm;
		/**
		 * 标的募集结束日期
		 */
		private String bdEndDt;
		/**
		 * 标的募集结束时间
		 */
		private String bdEndTm;
		/**
		 * 创建日期
		 */
		private String crtDt;
		/**
		 * 创建时间
		 */
		private String crtTm;
		/**
		 * 满标日期
		 */
		private String fullBdDt;
		/**
		 * 满标时间
		 */
		private String fullBdTm;
		/**
		 * 标的的状态
		 */
		private String sta;
		/**
		 * 标的成立的优先级
		 */
		private String lockYn;
		/**
		 * 累计投标的最大限额
		 */
		private BigDecimal bidLmtMaxAmt;
		/**
		 * 单笔投资的最小限额
		 */
		private BigDecimal bidLmtMinAmt;
		/**
		 * 投资的递增金额
		 */
		private BigDecimal bidLmtNextAmt;
		/**
		 * 标的投标的最大利率
		 */
		private BigDecimal bidLmtMaxRate;
		/**
		 * 发布用户ID
		 */
		private String pubUserId;
		/**
		 * 促销描述文件ID
		 */
		private String promDespFileId;
		/**
		 * 借款项目申明文件ID
		 */
		private String loanItemFileId;
		private String recvCustId;
		private String recvLoginNm;
		private String loanContId;
		private String accDepCd;
		private String bxBzf;
		private String ddBzf;
		private Integer lmtBbPerDayCnt;
		private BigDecimal lmtBbPerAmt;
		private BigDecimal lmtBbPerMonAmt;
		private String pubCustId;
		private String pubLoginNm;
		private String bidCustId;
		private String bidLoginNm;
		private String pubYn;
		private String bdOverDt;
		private String bdOverTm;
		private Integer lmtInvestTransDay;
		private String bdTyp;
		private String lastChgRealYrtDt;
		private Integer limitCnt;
		private Integer orderNum;
		private BigDecimal donationYrt;
		private String donationYn;
		private String bdTag;
		
		private String investReq;//投资人条件
		private String escrowOrgNm;//托管机构
		private String prjSecSclCd;//项目安全等级: 10 一般  20 安全 30 特别安全  
		private Integer estiCashDayCnt;
		private String dxwttzbdDesc;
		private String estiCashDt;
		private String policyNm;
		private String isTop;
		private String newFlag; //是否新手专享
		private String seckillFlag; //是否秒杀产品
		private String policyFlag; //是否发送保单短信
		
		private String bdId;
		private String sysPubBdId;
		private String oldestInvestDt;
		private BigDecimal bdAmt;
		private BigDecimal bidAmt;
		private String ciDueDt;
		private Integer version;
		
	
	
		public String getPolicyNm() {
			return policyNm;
		}

		public void setPolicyNm(String policyNm) {
			this.policyNm = policyNm;
		}

		

		public Integer getEstiCashDayCnt() {
			return estiCashDayCnt;
		}

		public void setEstiCashDayCnt(Integer estiCashDayCnt) {
			this.estiCashDayCnt = estiCashDayCnt;
		}

		public String getDxwttzbdDesc() {
			return dxwttzbdDesc;
		}

		public void setDxwttzbdDesc(String dxwttzbdDesc) {
			this.dxwttzbdDesc = dxwttzbdDesc;
		}
		public String getEstiCashDt() {
			return estiCashDt;
		}

		public void setEstiCashDt(String estiCashDt) {
			this.estiCashDt = estiCashDt;
		}
		

		/**get and set 方法，构造方法**/
		public BdB() {
		}

		public BdB(String bdTag, String investReq, String escrowOrgNm, String prjSecSclCd, String accDepCd,
				String bdCiMod, Integer bdCiStartDayCnt, String bdDesp, String bdEndDt, String bdEndTm, String bdNm,
				String bdOverDt, String bdOverTm, String bdStartDt, String bdStartTm, String bdTyp, String bidCustId,
				BigDecimal bidLmtMaxAmt, BigDecimal bidLmtMaxRate, BigDecimal bidLmtMinAmt, BigDecimal bidLmtNextAmt,
				String bidLoginNm, String bxBzf, String crtDt, String crtTm, String ddBzf, String donationYn,
				BigDecimal donationYrt, String fullBdDt, String fullBdTm, String id, String lastChgRealYrtDt,
				Integer limitCnt, BigDecimal lmtBbPerAmt, Integer lmtBbPerDayCnt, BigDecimal lmtBbPerMonAmt,
				Integer lmtInvestTransDay, String loanContId, String loanItemFileId, String lockYn, String oldestProdId,
				Integer orderNum, String prodId, String promDespFileId, String pubCustId, String pubLoginNm,
				String pubUserId, String pubYn, String recvCustId, String recvLoginNm, String sta,String policyNm, Integer version,
				String isTop,String newFlag,String seckillFlag,String policyFlag) {
			this.bdTag = bdTag;
			this.investReq = investReq;
			this.escrowOrgNm = escrowOrgNm;
			this.prjSecSclCd = prjSecSclCd;
			this.accDepCd = accDepCd;
			this.bdCiMod = bdCiMod;
			this.bdCiStartDayCnt = bdCiStartDayCnt;
			this.bdDesp = bdDesp;
			this.bdEndDt = bdEndDt;
			this.bdEndTm = bdEndTm;
			this.bdNm = bdNm;
			this.bdOverDt = bdOverDt;
			this.bdOverTm = bdOverTm;
			this.bdStartDt = bdStartDt;
			this.bdStartTm = bdStartTm;
			this.bdTyp = bdTyp;
			this.bidCustId = bidCustId;
			this.bidLmtMaxAmt = bidLmtMaxAmt;
			this.bidLmtMaxRate = bidLmtMaxRate;
			this.bidLmtMinAmt = bidLmtMinAmt;
			this.bidLmtNextAmt = bidLmtNextAmt;
			this.bidLoginNm = bidLoginNm;
			this.bxBzf = bxBzf;
			this.crtDt = crtDt;
			this.crtTm = crtTm;
			this.ddBzf = ddBzf;
			this.donationYn = donationYn;
			this.donationYrt = donationYrt;
			this.fullBdDt = fullBdDt;
			this.fullBdTm = fullBdTm;
			this.id = id;
			this.lastChgRealYrtDt = lastChgRealYrtDt;
			this.limitCnt = limitCnt;
			this.lmtBbPerAmt = lmtBbPerAmt;
			this.lmtBbPerDayCnt = lmtBbPerDayCnt;
			this.lmtBbPerMonAmt = lmtBbPerMonAmt;
			this.lmtInvestTransDay = lmtInvestTransDay;
			this.loanContId = loanContId;
			this.loanItemFileId = loanItemFileId;
			this.lockYn = lockYn;
			this.oldestProdId = oldestProdId;
			this.orderNum = orderNum;
			this.prodId = prodId;
			this.promDespFileId = promDespFileId;
			this.pubCustId = pubCustId;
			this.pubLoginNm = pubLoginNm;
			this.pubUserId = pubUserId;
			this.pubYn = pubYn;
			this.recvCustId = recvCustId;
			this.recvLoginNm = recvLoginNm;
			this.sta = sta;
			this.policyNm = policyNm;
			this.version = version;
			this.isTop = isTop;
			this.newFlag = newFlag;
			this.seckillFlag = seckillFlag;
			this.policyFlag = policyFlag;
		}

		public String getInvestReq() {
			return investReq;
		}

		public void setInvestReq(String investReq) {
			this.investReq = investReq;
		}

		public String getEscrowOrgNm() {
			return escrowOrgNm;
		}

		public void setEscrowOrgNm(String escrowOrgNm) {
			this.escrowOrgNm = escrowOrgNm;
		}

		public String getPrjSecSclCd() {
			return prjSecSclCd;
		}

		public void setPrjSecSclCd(String prjSecSclCd) {
			this.prjSecSclCd = prjSecSclCd;
		}

		public String getBdTag() {
			return bdTag;
		}

		public void setBdTag(String bdTag) {
			this.bdTag = bdTag;
		}

		public String getAccDepCd() {
			return this.accDepCd;
		}

		public void setAccDepCd(String accDepCd) {
			this.accDepCd = accDepCd;
		}

		public String getBdCiMod() {
			return this.bdCiMod;
		}

		public void setBdCiMod(String bdCiMod) {
			this.bdCiMod = bdCiMod;
		}

		public Integer getBdCiStartDayCnt() {
			return bdCiStartDayCnt;
		}

		public void setBdCiStartDayCnt(Integer bdCiStartDayCnt) {
			this.bdCiStartDayCnt = bdCiStartDayCnt;
		}

		public String getBdDesp() {
			return this.bdDesp;
		}

		public void setBdDesp(String bdDesp) {
			this.bdDesp = bdDesp;
		}

		public String getBdEndDt() {
			return this.bdEndDt;
		}

		public void setBdEndDt(String bdEndDt) {
			this.bdEndDt = bdEndDt;
		}

		public String getBdEndTm() {
			return this.bdEndTm;
		}

		public void setBdEndTm(String bdEndTm) {
			this.bdEndTm = bdEndTm;
		}

		public String getBdNm() {
			return this.bdNm;
		}

		public void setBdNm(String bdNm) {
			this.bdNm = bdNm;
		}

		public String getBdOverDt() {
			return this.bdOverDt;
		}

		public void setBdOverDt(String bdOverDt) {
			this.bdOverDt = bdOverDt;
		}

		public String getBdOverTm() {
			return this.bdOverTm;
		}

		public void setBdOverTm(String bdOverTm) {
			this.bdOverTm = bdOverTm;
		}

		public String getBdStartDt() {
			return this.bdStartDt;
		}

		public void setBdStartDt(String bdStartDt) {
			this.bdStartDt = bdStartDt;
		}

		public String getBdStartTm() {
			return this.bdStartTm;
		}

		public void setBdStartTm(String bdStartTm) {
			this.bdStartTm = bdStartTm;
		}

		public String getBdTyp() {
			return this.bdTyp;
		}

		public void setBdTyp(String bdTyp) {
			this.bdTyp = bdTyp;
		}

		public String getBidCustId() {
			return this.bidCustId;
		}

		public void setBidCustId(String bidCustId) {
			this.bidCustId = bidCustId;
		}

		public BigDecimal getBidLmtMaxAmt() {
			return this.bidLmtMaxAmt;
		}

		public void setBidLmtMaxAmt(BigDecimal bidLmtMaxAmt) {
			this.bidLmtMaxAmt = bidLmtMaxAmt;
		}

		public BigDecimal getBidLmtMaxRate() {
			return this.bidLmtMaxRate;
		}

		public void setBidLmtMaxRate(BigDecimal bidLmtMaxRate) {
			this.bidLmtMaxRate = bidLmtMaxRate;
		}

		public BigDecimal getBidLmtMinAmt() {
			return this.bidLmtMinAmt;
		}

		public void setBidLmtMinAmt(BigDecimal bidLmtMinAmt) {
			this.bidLmtMinAmt = bidLmtMinAmt;
		}

		public BigDecimal getBidLmtNextAmt() {
			return this.bidLmtNextAmt;
		}

		public void setBidLmtNextAmt(BigDecimal bidLmtNextAmt) {
			this.bidLmtNextAmt = bidLmtNextAmt;
		}

		public String getBidLoginNm() {
			return this.bidLoginNm;
		}

		public void setBidLoginNm(String bidLoginNm) {
			this.bidLoginNm = bidLoginNm;
		}

		public String getBxBzf() {
			return this.bxBzf;
		}

		public void setBxBzf(String bxBzf) {
			this.bxBzf = bxBzf;
		}

		public String getCrtDt() {
			return this.crtDt;
		}

		public void setCrtDt(String crtDt) {
			this.crtDt = crtDt;
		}

		public String getCrtTm() {
			return this.crtTm;
		}

		public void setCrtTm(String crtTm) {
			this.crtTm = crtTm;
		}

		public String getDdBzf() {
			return this.ddBzf;
		}

		public void setDdBzf(String ddBzf) {
			this.ddBzf = ddBzf;
		}

		public String getDonationYn() {
			return this.donationYn;
		}

		public void setDonationYn(String donationYn) {
			this.donationYn = donationYn;
		}

		public BigDecimal getDonationYrt() {
			return this.donationYrt;
		}

		public void setDonationYrt(BigDecimal donationYrt) {
			this.donationYrt = donationYrt;
		}

		public String getFullBdDt() {
			return this.fullBdDt;
		}

		public void setFullBdDt(String fullBdDt) {
			this.fullBdDt = fullBdDt;
		}

		public String getFullBdTm() {
			return this.fullBdTm;
		}

		public void setFullBdTm(String fullBdTm) {
			this.fullBdTm = fullBdTm;
		}

		public String getId() {
			return this.id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getLastChgRealYrtDt() {
			return this.lastChgRealYrtDt;
		}

		public void setLastChgRealYrtDt(String lastChgRealYrtDt) {
			this.lastChgRealYrtDt = lastChgRealYrtDt;
		}

		public Integer getLimitCnt() {
			return this.limitCnt;
		}

		public void setLimitCnt(Integer limitCnt) {
			this.limitCnt = limitCnt;
		}

		public BigDecimal getLmtBbPerAmt() {
			return this.lmtBbPerAmt;
		}

		public void setLmtBbPerAmt(BigDecimal lmtBbPerAmt) {
			this.lmtBbPerAmt = lmtBbPerAmt;
		}

		public Integer getLmtBbPerDayCnt() {
			return this.lmtBbPerDayCnt;
		}

		public void setLmtBbPerDayCnt(Integer lmtBbPerDayCnt) {
			this.lmtBbPerDayCnt = lmtBbPerDayCnt;
		}

		public BigDecimal getLmtBbPerMonAmt() {
			return this.lmtBbPerMonAmt;
		}

		public void setLmtBbPerMonAmt(BigDecimal lmtBbPerMonAmt) {
			this.lmtBbPerMonAmt = lmtBbPerMonAmt;
		}

		public Integer getLmtInvestTransDay() {
			return this.lmtInvestTransDay;
		}

		public void setLmtInvestTransDay(Integer lmtInvestTransDay) {
			this.lmtInvestTransDay = lmtInvestTransDay;
		}

		public String getLoanContId() {
			return this.loanContId;
		}

		public void setLoanContId(String loanContId) {
			this.loanContId = loanContId;
		}

		public String getLoanItemFileId() {
			return this.loanItemFileId;
		}

		public void setLoanItemFileId(String loanItemFileId) {
			this.loanItemFileId = loanItemFileId;
		}

		public String getLockYn() {
			return this.lockYn;
		}

		public void setLockYn(String lockYn) {
			this.lockYn = lockYn;
		}

		public String getOldestProdId() {
			return this.oldestProdId;
		}

		public void setOldestProdId(String oldestProdId) {
			this.oldestProdId = oldestProdId;
		}

		public Integer getOrderNum() {
			return this.orderNum;
		}

		public void setOrderNum(Integer orderNum) {
			this.orderNum = orderNum;
		}

		public String getProdId() {
			return this.prodId;
		}

		public void setProdId(String prodId) {
			this.prodId = prodId;
		}

		public String getPromDespFileId() {
			return this.promDespFileId;
		}

		public void setPromDespFileId(String promDespFileId) {
			this.promDespFileId = promDespFileId;
		}

		public String getPubCustId() {
			return this.pubCustId;
		}

		public void setPubCustId(String pubCustId) {
			this.pubCustId = pubCustId;
		}

		public String getPubLoginNm() {
			return this.pubLoginNm;
		}

		public void setPubLoginNm(String pubLoginNm) {
			this.pubLoginNm = pubLoginNm;
		}

		public String getPubUserId() {
			return this.pubUserId;
		}

		public void setPubUserId(String pubUserId) {
			this.pubUserId = pubUserId;
		}

		public String getPubYn() {
			return this.pubYn;
		}

		public void setPubYn(String pubYn) {
			this.pubYn = pubYn;
		}

		public String getRecvCustId() {
			return this.recvCustId;
		}

		public void setRecvCustId(String recvCustId) {
			this.recvCustId = recvCustId;
		}

		public String getRecvLoginNm() {
			return this.recvLoginNm;
		}

		public void setRecvLoginNm(String recvLoginNm) {
			this.recvLoginNm = recvLoginNm;
		}

		public String getSta() {
			return this.sta;
		}

		public void setSta(String sta) {
			this.sta = sta;
		}


		public Integer getVersion() {
			return this.version;
		}

		public void setVersion(Integer version) {
			this.version = version;
		}
		
		public String getIsTop() {
			return isTop;
		}

		public void setIsTop(String isTop) {
			this.isTop = isTop;
		}
		
		public String getNewFlag() {
			return newFlag;
		}

		public void setNewFlag(String newFlag) {
			this.newFlag = newFlag;
		}

		public String getSeckillFlag() {
			return seckillFlag;
		}

		public void setSeckillFlag(String seckillFlag) {
			this.seckillFlag = seckillFlag;
		}

		public String getPolicyFlag() {
			return policyFlag;
		}

		public void setPolicyFlag(String policyFlag) {
			this.policyFlag = policyFlag;
		}
		
		
		
		public String getBdId() {
			return bdId;
		}

		public void setBdId(String bdId) {
			this.bdId = bdId;
		}

		public String getSysPubBdId() {
			return sysPubBdId;
		}

		public void setSysPubBdId(String sysPubBdId) {
			this.sysPubBdId = sysPubBdId;
		}

		public String getOldestInvestDt() {
			return oldestInvestDt;
		}

		public void setOldestInvestDt(String oldestInvestDt) {
			this.oldestInvestDt = oldestInvestDt;
		}

		public BigDecimal getBdAmt() {
			return bdAmt;
		}

		public void setBdAmt(BigDecimal bdAmt) {
			this.bdAmt = bdAmt;
		}

		public BigDecimal getBidAmt() {
			return bidAmt;
		}

		public void setBidAmt(BigDecimal bidAmt) {
			this.bidAmt = bidAmt;
		}

		public String getCiDueDt() {
			return ciDueDt;
		}

		public void setCiDueDt(String ciDueDt) {
			this.ciDueDt = ciDueDt;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String toString() {
			return new ToStringBuilder(this).append("id", this.getId()).toString();
		}
}

