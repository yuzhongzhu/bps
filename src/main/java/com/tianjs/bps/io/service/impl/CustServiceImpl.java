package com.tianjs.bps.io.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tianjs.bps.io.enm.Response;
import com.tianjs.bps.io.entity.IoCustB;
import com.tianjs.bps.io.mapper.IoCustBMapper;
import com.tianjs.bps.io.service.ICustService;
import com.tianjs.framework.common.consistency.ConsistencyGenerator;
import com.tianjs.framework.common.util.SpringUtil;
@Service("custService")
public class CustServiceImpl implements ICustService {
	Logger logger = LoggerFactory.getLogger(CustServiceImpl.class);
	@Autowired
	private IoCustBMapper custBMapper;
	private static ConsistencyGenerator idGen = ConsistencyGenerator.getconsistencyGenerator();
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String doA(IoCustB custB) {
		try {
			((ICustService) SpringUtil.getBean("custService")).doB(custB);
			custB.setContact("1512100639A");
			IoCustB custBQry = new IoCustB();
			custBQry.setContact(custB.getContact());
			List<IoCustB> custList = this.findCustB(custBQry);
			
			if(custList !=null && custList.size()>0){
				logger.info("客户信息已存在"+custBQry.getContact());
				return Response.EXIST.getCode();
				
				
			}
			custB.setId(idGen.getId());
			custBMapper.addCustB(custB);
			throw new Exception("保存客户信息失败");
			//return Response.SUCCESS.getCode();
		} catch (Exception e) {
			logger.error("保存客户信息失败",e);
			throw new RuntimeException("保存客户信息失败");
		}
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String doB(IoCustB custB) {
		try {
			IoCustB custBQry = new IoCustB();
			custBQry.setContact("1512100639B");
			custB.setContact("1512100639B");
			List<IoCustB> custList = this.findCustB(custBQry);
			
			if(custList !=null && custList.size()>0){
				logger.info("客户信息已存在"+custBQry.getContact());
				return Response.EXIST.getCode();
				
				
			}
			custB.setId(idGen.getId());
			custBMapper.addCustB(custB);
			return Response.SUCCESS.getCode();
		} catch (Exception e) {
			logger.error("保存客户信息失败",e);
			throw new RuntimeException("保存客户信息失败");
		}
	}
	public String saveCust(IoCustB custB) {
		//return  this.doA(custB);
		try {
			IoCustB custBQry = new IoCustB();
			custBQry.setContact(custB.getContact());
			List<IoCustB> custList = this.findCustB(custBQry);
			
			if(custList !=null && custList.size()>0){
				logger.info("客户信息已存在"+custBQry.getContact());
				return Response.EXIST.getCode();
			}
			custB.setId(idGen.getId());
			custBMapper.addCustB(custB);
			return Response.SUCCESS.getCode();
		} catch (Exception e) {
			logger.error("保存客户信息失败",e);
			throw new RuntimeException("保存客户信息失败");
		}
		
	}
	public String txNewSaveCust(IoCustB custB) {
		try {
			IoCustB custBQry = new IoCustB();
			custBQry.setContact(custB.getContact());
			//custBQry.setContact("15121009999");
			List<IoCustB> custList = this.findCustB(custBQry);
			if(custList !=null && custList.size()>0){
				logger.info("客户信息已存在"+custBQry.getContact());
				return Response.EXIST.getCode();
			}
			/*custB.setId(idGen.getId());
			custB.setContact("15121009999");*/
			custBMapper.addCustB(custB);
			return Response.SUCCESS.getCode();
		} catch (Exception e) {
			logger.error("保存客户信息失败",e);
			
		}
		return Response.FAIL.getCode();
	}
	public List<IoCustB> findCustB(IoCustB custB) {	
		return custBMapper.findCustB(custB);
	}

	public String updateCust(IoCustB custB) {
		try {
			custBMapper.updateCustB(custB);
			return Response.SUCCESS.getCode();
		} catch (Exception e) {
			logger.error("更新失败updateCust",e);
		}
		return Response.FAIL.getCode();
	}
	
	
	
	public Map<String, Object> findCustByPage(IoCustB custB) {
		Integer cnt = custBMapper.getCustBCount(custB);
		List<IoCustB>  resultList= this.findCustB(custB);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("resultList", resultList);
		resultMap.put("totalRows", cnt);
		
		return resultMap;
	}

	public IoCustBMapper getCustBMapper() {
		return custBMapper;
	}

	public void setCustBMapper(IoCustBMapper custBMapper) {
		this.custBMapper = custBMapper;
	}

	
	
	

}
