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

import com.tianjs.bps.io.entity.IoCustB;
import com.tianjs.bps.io.service.ICustService;
import com.tianjs.bps.io.vo.Result;

@Controller
@RequestMapping("/back/cus")
public class CustomController {
	@Autowired
	private ICustService custService;
	
	@RequestMapping(value="initSave",method=RequestMethod.POST)
	public String initSave(){
		return "custInfo";
	}
	
	@RequestMapping(value="initQuery",method=RequestMethod.POST)
	public String initQuery(){
		return "custList";
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public Result saveCust(@ModelAttribute IoCustB custB){
		String result = custService.saveCust(custB);
		Result rslt = new Result();
		rslt.setCode(result);
		return rslt;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result updateCust(@ModelAttribute IoCustB custB){
		String result = custService.updateCust(custB);
		Result rslt = new Result();
		rslt.setCode(result);
		return rslt;
	}
	
	@RequestMapping(value="query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryCust(@ModelAttribute IoCustB custB){
		Map<String,Object> resultMap = custService.findCustByPage(custB);
		return resultMap;
	}
	@RequestMapping(value="queryKey",method=RequestMethod.POST)
	@ResponseBody
	public List<IoCustB> queryCustByKey(@RequestBody IoCustB custB){
		return custService.findCustB(custB);
	}
	public ICustService getCustService() {
		return custService;
	}
	public void setCustService(ICustService custService) {
		this.custService = custService;
	}
	
	
}
