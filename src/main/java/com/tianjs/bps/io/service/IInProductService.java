package com.tianjs.bps.io.service;

import java.util.List;
import java.util.Map;

import com.tianjs.bps.io.vo.InOrder;
import com.tianjs.bps.io.vo.InOrderVo;

public interface IInProductService {
	public  String saveInOrder(InOrderVo inOrder);
	public  void updateInOrder(InOrderVo inOrder);
	public List<InOrderVo> queryInOrder(InOrder inOrder);
	public InOrderVo queryInOrderByCd(String queryOprt,String cd);
	
	public Map<String,Object> queryInOrderBypage(InOrder inOrder);
}
