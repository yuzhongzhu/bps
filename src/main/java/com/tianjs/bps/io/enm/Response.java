package com.tianjs.bps.io.enm;

public enum Response {
	SUCCESS,EXIST,FAIL;
	public  String getCode(){
		switch (values()[ordinal()]){
		case SUCCESS :
			return "OK";
		case EXIST :
			return "EXIST";
		case FAIL:
			return "NOT_OK";
		}
		return "";
	}
}
