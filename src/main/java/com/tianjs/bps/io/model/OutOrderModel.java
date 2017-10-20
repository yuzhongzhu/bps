package com.tianjs.bps.io.model;

import java.util.List;

import com.tianjs.bps.io.entity.IoCustB;
import com.tianjs.bps.io.entity.OutProductLogBean;

public class OutOrderModel {
	private List<OutProductLogBean> orderList;
	private IoCustB custInfo;
	
	public List<OutProductLogBean> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OutProductLogBean> orderList) {
		this.orderList = orderList;
	}
	public IoCustB getCustInfo() {
		return custInfo;
	}
	public void setCustInfo(IoCustB custInfo) {
		this.custInfo = custInfo;
	}
}
