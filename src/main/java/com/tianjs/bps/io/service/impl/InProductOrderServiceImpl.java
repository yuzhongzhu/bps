package com.tianjs.bps.io.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianjs.bps.io.IdUtil;
import com.tianjs.bps.io.enm.Response;
import com.tianjs.bps.io.entity.IoWareHouseBean;
import com.tianjs.bps.io.mapper.InProductLogMapper;
import com.tianjs.bps.io.service.IInProductService;
import com.tianjs.bps.io.service.IProductService;
import com.tianjs.bps.io.service.IWareHouseService;
import com.tianjs.bps.io.vo.InOrder;
import com.tianjs.bps.io.vo.InOrderVo;
import com.tianjs.bps.io.vo.ProductInfoVo;
import com.tianjs.framework.common.util.DateUtil;
import com.tianjs.tradeframe.util.SystemUtil;
@Service("inProductService")
public class InProductOrderServiceImpl implements IInProductService {
	
	public static Logger logger = LoggerFactory.getLogger(InProductOrderServiceImpl.class);
	@Autowired
	private InProductLogMapper inProductLogMapper;
	@Autowired
	private IProductService productService;
	@Autowired
	private IWareHouseService wareHouseService;
	
	public String saveInOrder(InOrderVo inOrder) {
		try {
			ProductInfoVo vo =productService.queryProductByCd("=", inOrder.getProductCd());
			if(null==vo){
				vo = new ProductInfoVo ();
				vo.setBasePrice(inOrder.getBasePrice());
				vo.setPrice(inOrder.getBasePrice().multiply(new BigDecimal("1.05"), new MathContext(2, RoundingMode.HALF_DOWN)));
				vo.setProductCd(inOrder.getProductCd());
				vo.setProductNm(inOrder.getProductNm());
				productService.saveProduct(vo);
			}
			InOrder inOrderModel = new InOrder();
			inOrderModel.setBatchNo(inOrder.getBatchNo());
			inOrderModel.setInRegisterTm(inOrder.getInRegisterTm());
			inOrderModel.setProductCd(inOrder.getProductCd());
			List<InOrderVo> list = this.queryInOrder(inOrderModel);
			if(list ==null || list.size()==0){
				inOrder.setId(IdUtil.getSeqNo());
				inOrder.setInRegisterTm(DateUtil.getDateyyyyMMdd());
				inProductLogMapper.saveInPrdLog(inOrder);
				IoWareHouseBean bean = new IoWareHouseBean();
				bean.setProductCd(inOrder.getProductCd());
				bean.setRemainAmt(inOrder.getInCount());
				wareHouseService.updateWareHouse(bean);
			}else{
				return Response.EXIST.getCode();
			}
		} catch (Exception e) {
			logger.error("保存入库订单异常",e);
			throw new RuntimeException(e);
		}
		return Response.SUCCESS.getCode();
	}

	public void updateInOrder(InOrderVo inOrder) {
		InOrder inOrderModel = new InOrder();
		inOrderModel.setBatchNo(inOrder.getBatchNo());
		inOrderModel.setInRegisterTm(inOrder.getInRegisterTm());
		inOrderModel.setProductCd(inOrder.getProductCd());
		try {
			List<InOrderVo> list = this.queryInOrder(inOrderModel);
			if(list !=null && list.size()>0){
				InOrderVo dbVo = list.get(0);
				int diff = inOrder.getInCount().intValue()-dbVo.getInCount().intValue();
				IoWareHouseBean bean = new IoWareHouseBean();
				bean.setProductCd(inOrder.getProductCd());
				bean.setRemainAmt(diff);
				wareHouseService.updateWareHouse(bean);
				inProductLogMapper.updateInPrdLog(inOrder);
			}
		} catch (Exception e) {
			logger.error("更新失败",e);
			throw new RuntimeException(e);
		}
	}

	public List<InOrderVo> queryInOrder(InOrder inOrder) {
		return inProductLogMapper.findInPrdLog(inOrder);
	}

	public InOrderVo queryInOrderByCd(String queryOprt, String cd) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> queryInOrderBypage(InOrder inOrder) {
		InOrderVo vo = new InOrderVo();
		SystemUtil.copyProperties(inOrder, vo);
		Integer totalCnt = inProductLogMapper.findInPrdLogCnt(vo);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("totalRows", totalCnt);
		List<InOrderVo> resultList = null;
		if(totalCnt.intValue()>=1){
			resultList =  this.queryInOrder(inOrder);
		}else{
			resultList = new ArrayList<InOrderVo>();
		}
		resultMap.put("resultList", resultList);
		return resultMap;
	}

	public InProductLogMapper getInProductLogMapper() {
		return inProductLogMapper;
	}

	public void setInProductLogMapper(InProductLogMapper inProductLogMapper) {
		this.inProductLogMapper = inProductLogMapper;
	}

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public IWareHouseService getWareHouseService() {
		return wareHouseService;
	}

	public void setWareHouseService(IWareHouseService wareHouseService) {
		this.wareHouseService = wareHouseService;
	}

	
}
