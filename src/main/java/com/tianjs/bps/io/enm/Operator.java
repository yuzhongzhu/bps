package com.tianjs.bps.io.enm;

public enum Operator {
	E,LIKE;
	public String getCode(){
		switch(values()[this.ordinal()]){
		case E:
			return "=";
		case LIKE:
			return "LIKE";
		}
		return "=";
	}
}
