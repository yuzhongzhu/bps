package com.tianjs.bps.io.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tianjs.bps.io.entity.IoCustB;
import com.tianjs.framework.dao.mybatis.SqlMap;
@Repository("custBMapper")
public interface IoCustBMapper extends SqlMap {
	public void addCustB(IoCustB custB);
	public void updateCustB(IoCustB custB);
	public List<IoCustB> findCustB(IoCustB custB);
	public Integer getCustBCount(IoCustB custB);
}
