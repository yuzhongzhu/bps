package com.tianjs.bps.io.service;

import java.util.List;

import com.tianjs.bps.io.entity.IoMenuBean;

public interface IMenuService {
	public List<IoMenuBean> findMenuList(IoMenuBean menuBean);
}
