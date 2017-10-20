package com.tianjs.bps.io.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tianjs.bps.io.entity.SendOrderRl;
import com.tianjs.framework.dao.mybatis.SqlMap;
@Repository("sendOrderMapper")
public interface SendOrderMapper extends SqlMap {
	public void saveSendOrder(SendOrderRl vo);
	public List<SendOrderRl> querySendOrder(SendOrderRl vo);
	public Integer findSendListCnt(SendOrderRl vo);
}
