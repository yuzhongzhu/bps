package com.tianjs.bps.io.service;

import java.util.List;
import java.util.Map;

import com.tianjs.bps.io.entity.IoWareHouseBean;
import com.tianjs.bps.io.model.IoWareHouseModel;

public interface IWareHouseService {
	public String saveWareHouse(IoWareHouseBean bean);
	public String updateWareHouse(IoWareHouseBean bean);
	public List<IoWareHouseBean> findWareHouse(IoWareHouseModel bean);
	public Map<String,Object> findWareHouseByPage(IoWareHouseModel bean);
}
