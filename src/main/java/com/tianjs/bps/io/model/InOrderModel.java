package com.tianjs.bps.io.model;

import com.tianjs.bps.io.vo.InOrderVo;
import com.tianjs.bps.io.vo.Page;

public class InOrderModel {
	private InOrderVo inOrderVo;
	private Page pageVo = new Page();
	public InOrderVo getInOrderVo() {
		return inOrderVo;
	}
	public void setInOrderVo(InOrderVo inOrderVo) {
		this.inOrderVo = inOrderVo;
	}
	public Page getPageVo() {
		return pageVo;
	}
	public void setPageVo(Page pageVo) {
		this.pageVo = pageVo;
	}
	
	
	
}
