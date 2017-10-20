package com.tianjs.bps.io.vo;

import com.tianjs.bps.io.enm.Response;

public class Result {
	private String code = Response.SUCCESS.getCode();
	private String message;
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
