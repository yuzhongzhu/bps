package com.tianjs.bps.io.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianjs.bps.io.IdUtil;
import com.tianjs.bps.io.enm.Response;
import com.tianjs.bps.io.entity.IoCustB;
import com.tianjs.bps.io.entity.IoWareHouseBean;
import com.tianjs.bps.io.entity.OutProductLogBean;
import com.tianjs.bps.io.entity.SendOrderRl;
import com.tianjs.bps.io.mapper.OutProductLogMapper;
import com.tianjs.bps.io.model.OutOrderModel;
import com.tianjs.bps.io.service.ICustService;
import com.tianjs.bps.io.service.IOutOrderService;
import com.tianjs.bps.io.service.ISendOrderRLService;
import com.tianjs.bps.io.service.IWareHouseService;
import com.tianjs.framework.common.util.DateUtil;
@Service("outOrderService")
public class OutOrderServiceImpl implements IOutOrderService {
	public static Logger logger = LoggerFactory.getLogger(OutOrderServiceImpl.class);
	@Autowired
	private OutProductLogMapper outProductLogMapper;
	
	@Autowired
	private IWareHouseService wareHouseService;
	
	@Autowired
	private ICustService custService;
	@Autowired
	private ISendOrderRLService sendOrderRLService;
	
	public String saveOutOrder(OutOrderModel outOrder) {
		IoCustB custInfo = outOrder.getCustInfo();
		String custId = IdUtil.getSeqNo();
		custInfo.setId(custId);
		String custFlag = custService.txNewSaveCust(custInfo);
		if (Response.SUCCESS.getCode().equals(custFlag)||Response.EXIST.getCode().equals(custFlag)) {
			for (OutProductLogBean productInfo : outOrder.getOrderList()) {
				try {
					productInfo.setId(IdUtil.getSeqNo());
					productInfo.setOutRegisterTm(DateUtil.getDateyyyyMMdd());
					outProductLogMapper.saveOutPrdLog(productInfo);
					IoWareHouseBean bean = new IoWareHouseBean();
					bean.setProductCd(productInfo.getProductCd());
					bean.setRemainAmt(productInfo.getOutCount() * (-1));
					 wareHouseService.updateWareHouse(bean);
					SendOrderRl sendOrder = new SendOrderRl();
					sendOrder.setCustId(custId);
					sendOrder.setOutBatchNo(productInfo.getOutBatchNo());
					sendOrder.setId(IdUtil.getSeqNo());
					sendOrder.setSendFlag("Y");
					sendOrder.setCrtDt(DateUtil.getDateyyyyMMddHHmmss());
					sendOrder.setSendDt(DateUtil.getDateyyyyMMdd());
					sendOrderRLService.saveSendOrderRl(sendOrder);
				} catch (Exception e) {
					logger.error("保存出单失败", e);
					throw new RuntimeException("保存出单失败");
				}
			}
			return Response.SUCCESS.getCode();
		}
		return Response.FAIL.getCode();
	}

	public String updateOutOrder(OutProductLogBean productInfo) {
		try {
			List<OutProductLogBean>  list = outProductLogMapper.findOutPrdLog(productInfo);
			int count = 0;
			if(list!=null&& list.size()>0){
				OutProductLogBean outOrderBean = list.get(0);
				
				if("0".equals(productInfo.getSta())){
					count = outOrderBean.getOutCount();//释放当前出库量，增加库存
				}else{
					count = productInfo.getOutCount().intValue()- outOrderBean.getOutCount().intValue();
					if(count>0){
						count *= -1;//扣减现有库存
					}
				} 
				if("0".equals(productInfo.getSta())||count!=0){
					IoWareHouseBean bean = new IoWareHouseBean();
					bean.setProductCd(productInfo.getProductCd());
					bean.setRemainAmt(count);
					wareHouseService.updateWareHouse(bean);
				}
				outProductLogMapper.updateOutPrdLog(productInfo);
			}
		} catch (Exception e) {
			logger.error("更新出库订单失败",e);
			throw new RuntimeException(e);
		}
		return Response.SUCCESS.getCode();
	}

	public List<OutProductLogBean>  findOutOrder(OutProductLogBean productInfo) {
		return outProductLogMapper.findOutPrdLog(productInfo);
	}
	

	public Map<String, Object> findOutOrderByPage(OutProductLogBean productInfo) {
		Integer totalCnt = outProductLogMapper.findOutPrdLogCnt(productInfo);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("totalRows", totalCnt);
		List<OutProductLogBean> resultList = null;
		if(totalCnt.intValue()>=1){
			resultList =  this.findOutOrder(productInfo);
		}else{
			resultList = new ArrayList<OutProductLogBean>();
		}
		resultMap.put("resultList", resultList);
		return resultMap;
	}

	public OutProductLogMapper getOutProductLogMapper() {
		return outProductLogMapper;
	}

	public void setOutProductLogMapper(OutProductLogMapper outProductLogMapper) {
		this.outProductLogMapper = outProductLogMapper;
	}

	public IWareHouseService getWareHouseService() {
		return wareHouseService;
	}

	public void setWareHouseService(IWareHouseService wareHouseService) {
		this.wareHouseService = wareHouseService;
	}

	public ICustService getCustService() {
		return custService;
	}

	public void setCustService(ICustService custService) {
		this.custService = custService;
	}

	public ISendOrderRLService getSendOrderRLService() {
		return sendOrderRLService;
	}

	public void setSendOrderRLService(ISendOrderRLService sendOrderRLService) {
		this.sendOrderRLService = sendOrderRLService;
	}
	
	
	
}
