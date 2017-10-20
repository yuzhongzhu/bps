package com.tianjs.bps.io.service.impl;

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
import com.tianjs.bps.io.mapper.IoWareHouseMapper;
import com.tianjs.bps.io.model.IoWareHouseModel;
import com.tianjs.bps.io.service.IWareHouseService;
import com.tianjs.framework.common.util.DateUtil;
@Service("wareHouseService")
public class WareHouseServiceImpl implements IWareHouseService {
	public static Logger logger = LoggerFactory.getLogger(WareHouseServiceImpl.class);
	@Autowired
	private  IoWareHouseMapper wareHouseMapper;
	public String saveWareHouse(IoWareHouseBean bean) {
		try {
			bean.setId(IdUtil.getSeqNo());
			bean.setUpdateTm(DateUtil.getDateyyyyMMddHHmmss());
			bean.setOperId("admin");
			wareHouseMapper.addWareHouse(bean);
		} catch (Exception e) {
			logger.error("库存新增失败",e);
			///return Response.FAIL.getCode();
			throw new RuntimeException("库存新增失败");
		}
		return Response.SUCCESS.getCode();
	}

	public String updateWareHouse(IoWareHouseBean bean) {
		IoWareHouseModel qryBean = new IoWareHouseModel();
		qryBean.setProductCd(bean.getProductCd());
		List<IoWareHouseBean> list= this.findWareHouse(qryBean);
		String result;
		if(null==list || list.size()==0){
			result = this.saveWareHouse(bean);
		}else{
			IoWareHouseBean beanUp = list.get(0);
			try {
				Integer orgAmt = beanUp.getRemainAmt();
				logger.info("更新库存数据，原始库【"+orgAmt+"】，要更新【"+bean.getRemainAmt()+"】");
				beanUp.setRemainAmt((orgAmt.intValue()+(bean.getRemainAmt().intValue())));
				int flag = wareHouseMapper.updateWareHouse(beanUp);
				result = Response.SUCCESS.getCode();
			} catch (Exception e) {
				logger.error("更新库存失败",e);
				throw new RuntimeException("更新库存失败");
			}
		}
		return result;
	}

	public List<IoWareHouseBean> findWareHouse(IoWareHouseModel bean) {
		return wareHouseMapper.findWareHouse(bean);
	}

	public Map<String, Object> findWareHouseByPage(IoWareHouseModel bean) {
		IoWareHouseBean wareHouseBean = new IoWareHouseBean();
		wareHouseBean.setProductCd(bean.getProductCd());
		Integer totalCnt = wareHouseMapper.findWareHouseCnt(wareHouseBean);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("totalRows", totalCnt);
		List<IoWareHouseBean> resultList = null;
		if(totalCnt.intValue()>=1){
			resultList =  this.findWareHouse(bean);
		}else{
			resultList = new ArrayList<IoWareHouseBean>();
		}
		resultMap.put("resultList", resultList);
		return resultMap;
	}

	public IoWareHouseMapper getWareHouseMapper() {
		return wareHouseMapper;
	}

	public void setWareHouseMapper(IoWareHouseMapper wareHouseMapper) {
		this.wareHouseMapper = wareHouseMapper;
	}
	
	
	
}
