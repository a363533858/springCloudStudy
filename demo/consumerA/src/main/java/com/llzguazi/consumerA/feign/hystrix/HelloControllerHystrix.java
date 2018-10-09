package com.llzguazi.consumerA.feign.hystrix;

import com.llzguazi.consumerA.feign.IProviderRpcController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by MI on 2018/10/9.
 */
@Component
public class HelloControllerHystrix implements IProviderRpcController {

	@Override
	public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
		return 0;
	}
}
