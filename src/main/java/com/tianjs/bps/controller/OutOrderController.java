package com.tianjs.bps.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianjs.bps.io.enm.Response;
import com.tianjs.bps.io.entity.OutProductLogBean;
import com.tianjs.bps.io.entity.SendOrderRl;
import com.tianjs.bps.io.model.OutOrderModel;
import com.tianjs.bps.io.service.IOutOrderService;
import com.tianjs.bps.io.service.ISendOrderRLService;
import com.tianjs.bps.io.vo.OutOrderVo;
import com.tianjs.bps.io.vo.Result;
import com.tianjs.tradeframe.util.SystemUtil;

@Controller
@RequestMapping(value="back/outOrder")
public class OutOrderController {
	@Autowired
	private IOutOrderService outOrderService;
	@Autowired
	private ISendOrderRLService sendOrderRLService;
	
	@RequestMapping(value="initSave",method=RequestMethod.POST)
	public String initSave(){
		return "outProduct";
	}
	
	@RequestMapping(value="initQuery",method=RequestMethod.POST)
	public String initQuery(){
		return "outProductList";
	}
	
	@RequestMapping(value="sendQuery",method=RequestMethod.POST)
	public String sendQuery(){
		return "sendList";
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public Result saveOutOrder(@RequestBody OutOrderModel outOrder){
		Result rslt = new Result();
		String tempFlag = "";
		try {
			tempFlag =outOrderService.saveOutOrder(outOrder);
			rslt.setCode(tempFlag);
			if(Response.FAIL.getCode().equals(tempFlag)){
				rslt.setMessage("保存客户信息失败");
			}
		} catch (Exception e) {
			rslt.setCode(Response.FAIL.getCode());
			rslt.setMessage(e.getMessage());
		}
		return rslt;
	}
	@RequestMapping(value="query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryOutOrder(@ModelAttribute OutOrderVo outOrder){
		OutProductLogBean bean = new OutProductLogBean();
		SystemUtil.copyProperties(outOrder, bean);
		Map<String, Object> resultMap = outOrderService.findOutOrderByPage(bean);
		return resultMap;
	}
	
	@RequestMapping(value="queryList",method=RequestMethod.POST)
	@ResponseBody
	public List<OutProductLogBean> queryOutOrderList(@ModelAttribute OutOrderVo outOrder){
		OutProductLogBean bean = new OutProductLogBean();
		SystemUtil.copyProperties(outOrder, bean);
		List<OutProductLogBean> beanList = outOrderService.findOutOrder(bean);
		return beanList;
	}
	@RequestMapping(value="querySend",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> querySendList(@ModelAttribute SendOrderRl sendOrder){
		Map<String, Object> resultMap = sendOrderRLService.findSendListByPage(sendOrder);
		return resultMap;
	}
	@RequestMapping(value="updateSta",method=RequestMethod.POST)
	@ResponseBody
	public Result updateStaOutOrder(@ModelAttribute OutOrderVo outOrder){
		OutProductLogBean bean = new OutProductLogBean();
		SystemUtil.copyProperties(outOrder, bean);
		String flag = outOrderService.updateOutOrder(bean);
		Result rslt = new Result();
		return rslt;
	}
	public IOutOrderService getOutOrderService() {
		return outOrderService;
	}

	public void setOutOrderService(IOutOrderService outOrderService) {
		this.outOrderService = outOrderService;
	}

	public ISendOrderRLService getSendOrderRLService() {
		return sendOrderRLService;
	}

	public void setSendOrderRLService(ISendOrderRLService sendOrderRLService) {
		this.sendOrderRLService = sendOrderRLService;
	}
	
	
}
