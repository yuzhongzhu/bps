package com.tianjs.bps.io.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianjs.bps.io.enm.Operator;
import com.tianjs.bps.io.enm.Response;
import com.tianjs.bps.io.entity.ProductBaseBean;
import com.tianjs.bps.io.mapper.ProductMapper;
import com.tianjs.bps.io.service.IProductService;
import com.tianjs.bps.io.vo.ProductInfoVo;
import com.tianjs.framework.common.consistency.ConsistencyGenerator;
import com.tianjs.tradeframe.util.SystemUtil;
@Service("productService")
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductMapper productMapper;
	
	private static ConsistencyGenerator idGen = ConsistencyGenerator.getconsistencyGenerator();
	
	
	
	public String saveProduct(ProductInfoVo productInfo) {
		ProductInfoVo vo = this.queryProductByCd(Operator.E.getCode(),productInfo.getProductCd());
		if(null == vo){
			ProductBaseBean baseBean = this.genConditionBean(productInfo);
			baseBean.setId(idGen.getId());
			productMapper.saveProduct(baseBean);
			return Response.SUCCESS.getCode();
		}else{
		 return Response.EXIST.getCode();
		}
	}

	public void updateProduct(ProductInfoVo productInfo) {
		ProductBaseBean baseBean = this.genConditionBean(productInfo);
		productMapper.updateProduct(baseBean);
	}

	public List<ProductInfoVo> queryProduct(ProductInfoVo productInfo) {
		List<ProductBaseBean> listBean =productMapper.queryProduct(productInfo);
		if(listBean!=null && listBean.size()>0){
			List<ProductInfoVo> prodList = new ArrayList<ProductInfoVo>();
			for(ProductBaseBean baseBean:listBean){
				ProductInfoVo prdVo = new ProductInfoVo();
				SystemUtil.copyProperties(baseBean, prdVo);
				prodList.add(prdVo);
			}
			return prodList;
		}
		return null;
	}
	
	
	
	public Map<String, Object> queryProductBypage(ProductInfoVo productInfo) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Integer num = productMapper.queryProductCount(productInfo);
		productInfo.setStartRow();
		List<ProductInfoVo>  tempList = this.queryProduct(productInfo);
		resultMap.put("totalRows", num);
		resultMap.put("resultList", tempList);
		return resultMap;
	}

	public ProductInfoVo queryProductByCd(String queryOprt, String cd) {
		ProductBaseBean bean =productMapper.queryProductbyCd(queryOprt,cd);
		if(bean !=null){
			ProductInfoVo prdVo = new ProductInfoVo();
			SystemUtil.copyProperties(bean, prdVo);
			return prdVo;
		}
		return null;
		
	}
	
	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	private ProductBaseBean genConditionBean(ProductInfoVo productInfo){
		ProductBaseBean baseBean = new ProductBaseBean();
		SystemUtil.copyProperties(productInfo, baseBean);
		return  baseBean;
	}
	
}
