package com.tianjs.bps.io.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tianjs.bps.io.entity.OutProductLogBean;
import com.tianjs.framework.dao.mybatis.SqlMap;
@Repository("outProductLogMapper")
public interface OutProductLogMapper extends SqlMap {
	public  void saveOutPrdLog(OutProductLogBean productInfo);
	public  void updateOutPrdLog(OutProductLogBean productOutfo);
	public  void deleteOutPrdLog(OutProductLogBean productOutfo);
	public List<OutProductLogBean> findOutPrdLog(OutProductLogBean productInfo);
	public Integer findOutPrdLogCnt(OutProductLogBean productOutfo);
}
