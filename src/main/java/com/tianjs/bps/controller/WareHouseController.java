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

import com.tianjs.bps.io.entity.IoWareHouseBean;
import com.tianjs.bps.io.model.IoWareHouseModel;
import com.tianjs.bps.io.service.IWareHouseService;

@Controller
@RequestMapping(value="back/wareH")
public class WareHouseController {
	@Autowired
	private IWareHouseService wareHouseService;
	

	
	@RequestMapping(value="initQuery",method=RequestMethod.POST)
	public String initQuery(){
		return "wareHouseList";
	}

	@RequestMapping(value="query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryWareH(@ModelAttribute IoWareHouseModel outOrder){
		Map<String, Object> resultMap = wareHouseService.findWareHouseByPage(outOrder);
		return resultMap;
	}
	
	
	@RequestMapping(value="queryKey",method=RequestMethod.POST)
	@ResponseBody
	public List<IoWareHouseBean> queryWareHByKey(@RequestBody IoWareHouseModel outOrder){
		return wareHouseService.findWareHouse(outOrder);
	}
	
	public IWareHouseService getWareHouseService() {
		return wareHouseService;
	}

	public void setWareHouseService(IWareHouseService wareHouseService) {
		this.wareHouseService = wareHouseService;
	}
	
	
	
	
}
