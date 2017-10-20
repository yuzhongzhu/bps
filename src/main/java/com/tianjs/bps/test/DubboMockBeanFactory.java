package com.tianjs.bps.test;

import static org.mockito.Matchers.any;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.tianjs.framework.consistency.model.Header;
import com.tianjs.framework.consistency.model.ResponseVo;
import com.tianjs.tradeframe.consistency.api.DobboTradessService;

@Component
public class DubboMockBeanFactory {
	@Bean(name="dobboTradessService")
	public DobboTradessService getDubboTradessService(){
		DobboTradessService dobboTradessService = Mockito.mock(DobboTradessService.class);
		 ResponseVo responseVo = new ResponseVo ();
		 Header header = new Header();
		 header.setStauts("0");
		 responseVo.setHeader(header);
		 final String str = JSONObject.toJSONString(responseVo);
		Mockito.when(dobboTradessService.beneficiate(any(String.class))).then(new Answer<String>() {

			public String answer(InvocationOnMock invocation) throws Throwable {
				return str; 
			}
			
		});
		Mockito.when(dobboTradessService.affirm(any(String.class))).then(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				return str;
			}
			
		});
		return dobboTradessService;
	}
}
