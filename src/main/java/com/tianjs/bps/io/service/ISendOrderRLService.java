package com.tianjs.bps.io.service;

import java.util.List;
import java.util.Map;

import com.tianjs.bps.io.entity.SendOrderRl;

public interface ISendOrderRLService {
	public String saveSendOrderRl(SendOrderRl sendOrder);
	public List<SendOrderRl> querySendOrder(SendOrderRl sendOrder);
	public Map<String,Object>  findSendListByPage(SendOrderRl sendOrder);
}
