package com.tianjs.bps.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tianjs.bps.io.enm.Response;
import com.tianjs.bps.io.model.InOrderModel;
import com.tianjs.bps.io.service.IInProductService;
import com.tianjs.bps.io.vo.InOrder;
import com.tianjs.bps.io.vo.InOrderVo;
import com.tianjs.bps.io.vo.Page;
import com.tianjs.bps.io.vo.Result;
import com.tianjs.tradeframe.util.SystemUtil;

@Controller
@RequestMapping("back/inPrd")
public class InProductController {
	@Autowired
	private IInProductService inProductService;
	
	@RequestMapping(value="initSave",method=RequestMethod.POST)
	public String initSavePage(){
		return "inProduct";
	}
	
	@RequestMapping(value="initQuery",method=RequestMethod.POST)
	public String initQueryPage(){
		return "inProductList";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public Result savePrd(@ModelAttribute InOrderVo inOrder){
		Result rslt = new Result();
		try {
			String tempFlag =inProductService.saveInOrder(inOrder);
			rslt.setCode(tempFlag);
		} catch (Exception e) {
			e.printStackTrace();
			rslt.setCode(Response.FAIL.getCode());
		}
		return rslt;
	}
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public void batchPrd(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file){
		try{  
            boolean flag = false;  
            if(file.getSize() > 0){
                System.out.println(file.getOriginalFilename());  
                flag = true;  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
	}
	
	@RequestMapping(value="query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPrd(@ModelAttribute InOrder inOrderVo){
		return  inProductService.queryInOrderBypage(inOrderVo);
	}
	@RequestMapping(value="queryKey",method=RequestMethod.POST)
	@ResponseBody
	public List<InOrderVo> queryPrdKey(@RequestBody InOrder inOrder){
		return inProductService.queryInOrder(inOrder);
	}
	
	@RequestMapping(value="updateOrder",method=RequestMethod.POST)
	@ResponseBody
	public Result updateOrder(@ModelAttribute InOrderVo inOrder){
		Result rslt = new Result();
		try {
			inProductService.updateInOrder(inOrder);
		} catch (Exception e) {
			e.printStackTrace();
			rslt.setCode(Response.FAIL.getCode());
		}
		return rslt ;
	}

	public IInProductService getInProductService() {
		return inProductService;
	}

	public void setInProductService(IInProductService inProductService) {
		this.inProductService = inProductService;
	}
	
	
	
}
