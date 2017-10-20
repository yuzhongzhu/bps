package com.tianjs.bps.io.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tianjs.bps.io.entity.IoMenuBean;
import com.tianjs.framework.dao.mybatis.SqlMap;
@Repository("menuMapper")
public interface IoMenuMapper extends SqlMap {
	
	public List<IoMenuBean> findMenuList(IoMenuBean menuB);
}
