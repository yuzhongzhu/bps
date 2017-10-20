package com.tianjs.bps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianjs.bps.io.entity.IoMenuBean;
import com.tianjs.bps.io.service.IMenuService;

@Controller
public class MenuController {
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping(value="back/menu/query",method=RequestMethod.POST)
	@ResponseBody
	public List<IoMenuBean> queryMenu(){
		return menuService.findMenuList(null);
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}
	
	
}
