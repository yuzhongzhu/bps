package com.tianjs.bps.io;

import com.tianjs.framework.common.consistency.ConsistencyGenerator;

public class IdUtil {
	public static String getSeqNo(){
		return ConsistencyGenerator.getconsistencyGenerator().getId();
	}
}
