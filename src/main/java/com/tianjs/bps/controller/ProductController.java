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
import com.tianjs.bps.io.service.IProductService;
import com.tianjs.bps.io.vo.ProductInfoVo;
import com.tianjs.bps.io.vo.Result;

@Controller
@RequestMapping("back/prd")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="initSave",method=RequestMethod.POST)
	public String initSavePage(){
		return "product";
	}
	
	@RequestMapping(value="initQuery",method=RequestMethod.POST)
	public String initQueryPage(){
		return "productList";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public Result savePrd(@ModelAttribute ProductInfoVo product){
		String tempFlag =productService.saveProduct(product);
		Result rslt = new Result();
		rslt.setCode(tempFlag);
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
	public Map<String,Object> queryPrd(@ModelAttribute ProductInfoVo product){
		return  productService.queryProductBypage(product);
	}
	@RequestMapping(value="queryKey",method=RequestMethod.POST)
	@ResponseBody
	public List<ProductInfoVo> queryPrdKey(@RequestBody ProductInfoVo product){
		return productService.queryProduct(product);
	}
	
	
	@RequestMapping(value="updatePrd",method=RequestMethod.POST)
	@ResponseBody
	public Result updatePrd(@ModelAttribute ProductInfoVo product){
		Result rslt = new Result();
		try {
			 productService.updateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			rslt.setCode(Response.FAIL.getCode());
		}
		return rslt ;
	}
	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	
}
