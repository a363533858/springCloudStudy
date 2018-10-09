package com.llzguazi.consumerA.feign;

import com.llzguazi.consumerA.feign.hystrix.HelloControllerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by MI on 2018/10/9.
 */
@FeignClient(value = "spring-cloud-providerA",fallback = HelloControllerHystrix.class)
public interface IProviderRpcController {
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
