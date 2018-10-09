package com.llzguazi.consumerA.controller;

import com.llzguazi.consumerA.feign.IProviderRpcController;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by MI on 2018/10/8.
 */
@RestController
public class HelloController {

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private DiscoveryClient discoveryClient; // of org.springframework

	@Resource
	private IProviderRpcController providerRpcController;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		String url = "http://spring-cloud-providerA/add?a="+a+"&b="+b;
		return restTemplate.getForObject(url,Integer.class);
	}

	@RequestMapping(value = "/providerAdd", method = RequestMethod.GET)
	public Integer providerAdd(@RequestParam Integer a, @RequestParam Integer b) {
		return providerRpcController.add(a,b);
	}

	@RequestMapping(value = "/selfInfo", method = RequestMethod.GET)
	public String selfInfo() {
		return "consumerA服务";
	}

	@GetMapping("/info")
	public Map<String, Object> info() {
		Map<String, Object> map = new LinkedHashMap<>();
		List<String> serviceNames = discoveryClient.getServices();
		for (String serviceName : serviceNames) {
			List<String> uris = new LinkedList<>();
			for (ServiceInstance instance : discoveryClient.getInstances(serviceName)) {
				uris.add(instance.getUri().toASCIIString());
			}
			map.put(serviceName, uris);
		}
		return map;
	}
}
