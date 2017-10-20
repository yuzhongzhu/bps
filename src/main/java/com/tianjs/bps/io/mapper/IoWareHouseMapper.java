package com.tianjs.bps.io.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tianjs.bps.io.entity.IoWareHouseBean;
import com.tianjs.bps.io.model.IoWareHouseModel;
import com.tianjs.framework.dao.mybatis.SqlMap;
@Repository("wareHouseMapper")
public interface IoWareHouseMapper extends SqlMap {
	public int addWareHouse(IoWareHouseBean wareHouseB);
	public int updateWareHouse(IoWareHouseBean wareHouseB);
	public List<IoWareHouseBean> findWareHouse(IoWareHouseModel wareHouseB);
	public Integer findWareHouseCnt(IoWareHouseBean wareHouseB);
}
