package com.tianjs.bps.io.service;

import java.util.List;
import java.util.Map;

import com.tianjs.bps.io.entity.OutProductLogBean;
import com.tianjs.bps.io.model.OutOrderModel;

public interface IOutOrderService {
	public String saveOutOrder(OutOrderModel productInfo);
	public String updateOutOrder(OutProductLogBean productInfo);
	public List<OutProductLogBean>  findOutOrder(OutProductLogBean productInfo);
	public Map<String,Object>  findOutOrderByPage(OutProductLogBean productInfo);
	
}
