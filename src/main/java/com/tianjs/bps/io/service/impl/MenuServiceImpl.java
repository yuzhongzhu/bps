package com.tianjs.bps.io.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianjs.bps.io.entity.IoMenuBean;
import com.tianjs.bps.io.mapper.IoMenuMapper;
import com.tianjs.bps.io.service.IMenuService;
@Service("MenuService")
public class MenuServiceImpl implements IMenuService{
	@Autowired
	private IoMenuMapper menuMapper;
	
	public List<IoMenuBean> findMenuList(IoMenuBean menuBean) {
		List<IoMenuBean> menuList = menuMapper.findMenuList(null);
		return menuList;
	}
	public IoMenuMapper getMenuMapper() {
		return menuMapper;
	}
	public void setMenuMapper(IoMenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

}
