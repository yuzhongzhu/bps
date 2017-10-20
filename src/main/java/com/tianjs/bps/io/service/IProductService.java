package com.tianjs.bps.io.service;

import java.util.List;
import java.util.Map;

import com.tianjs.bps.io.vo.ProductInfoVo;

public interface IProductService {
	public  String saveProduct(ProductInfoVo productInfo);
	public  void updateProduct(ProductInfoVo productInfo);
	public List<ProductInfoVo> queryProduct(ProductInfoVo productInfo);
	public ProductInfoVo queryProductByCd(String queryOprt,String cd);
	
	public Map<String,Object> queryProductBypage(ProductInfoVo productInfo);
}
