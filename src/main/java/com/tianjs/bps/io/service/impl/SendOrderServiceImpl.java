package com.tianjs.bps.io.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianjs.bps.io.enm.Response;
import com.tianjs.bps.io.entity.SendOrderRl;
import com.tianjs.bps.io.mapper.SendOrderMapper;
import com.tianjs.bps.io.service.ISendOrderRLService;


@Service("sendOrderRLService")
public class SendOrderServiceImpl implements ISendOrderRLService {
	Logger logger  = LoggerFactory.getLogger(SendOrderServiceImpl.class);
	@Autowired
	private SendOrderMapper sendOrderMapper;
	
	public String saveSendOrderRl(SendOrderRl sendOrder) {
		try {
			sendOrderMapper.saveSendOrder(sendOrder);
		} catch (Exception e) {
			logger.error("保存配送信息失败",e);
			throw new RuntimeException("保存配送信息失败");
		}
		return Response.SUCCESS.getCode();
	}

	public List<SendOrderRl> querySendOrder(SendOrderRl sendOrder) {
		return sendOrderMapper.querySendOrder(sendOrder);
	}
	
	public Map<String, Object> findSendListByPage(SendOrderRl sendOrder) {
		Integer totalCnt = sendOrderMapper.findSendListCnt(sendOrder);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("totalRows", totalCnt);
		List<SendOrderRl> resultList = null;
		if(totalCnt.intValue()>=1){
			resultList =  this.querySendOrder(sendOrder);
		}else{
			resultList = new ArrayList<SendOrderRl>();
		}
		resultMap.put("resultList", resultList);
		return resultMap;
	}

	public SendOrderMapper getSendOrderMapper() {
		return sendOrderMapper;
	}

	public void setSendOrderMapper(SendOrderMapper sendOrderMapper) {
		this.sendOrderMapper = sendOrderMapper;
	}
	
}
