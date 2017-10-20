package com.tianjs.bps.io.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tianjs.bps.io.entity.ProductBaseBean;
import com.tianjs.bps.io.vo.ProductInfoVo;
import com.tianjs.framework.dao.mybatis.SqlMap;
@Repository("productMapper")
public interface ProductMapper extends SqlMap {
	public  void saveProduct(ProductBaseBean productInfo);
	public  void updateProduct(ProductBaseBean productInfo);
	public List<ProductBaseBean> queryProduct(ProductInfoVo productInfo);
	public ProductBaseBean queryProductbyCd(String operator,String cd);
	public Integer queryProductCount(ProductInfoVo productInfo);
}
