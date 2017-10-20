package com.tianjs.bps.io.service;

import java.util.List;
import java.util.Map;

import com.tianjs.bps.io.entity.IoCustB;

public interface ICustService {
	public String saveCust(IoCustB custB);
	public String doA(IoCustB custB);
	public String doB(IoCustB custB);
	public List<IoCustB> findCustB(IoCustB custB);
	public String updateCust(IoCustB custB);
	public String txNewSaveCust(IoCustB custB);
	public Map<String,Object> findCustByPage(IoCustB custB);
}
