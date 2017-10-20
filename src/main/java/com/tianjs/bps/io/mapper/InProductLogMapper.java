package com.tianjs.bps.io.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tianjs.bps.io.vo.InOrder;
import com.tianjs.bps.io.vo.InOrderVo;
import com.tianjs.framework.dao.mybatis.SqlMap;
@Repository("inProductLogMapper")
public interface InProductLogMapper extends SqlMap {
	public  void saveInPrdLog(InOrderVo productInfo);
	public  void updateInPrdLog(InOrderVo productInfo);
	public  void deleteInPrdLog(InOrderVo productInfo);
	public List<InOrderVo> findInPrdLog(InOrder productInfo);
	public Integer findInPrdLogCnt(InOrderVo productInfo);
}
