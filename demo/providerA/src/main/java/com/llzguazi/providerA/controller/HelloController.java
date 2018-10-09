package com.llzguazi.providerA.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

	@Resource
	private DiscoveryClient discoveryClient; // of org.springframework

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		Integer result = a + b;
		return result;
	}

	@RequestMapping(value = "/selfInfo", method = RequestMethod.GET)
	public String selfInfo() {
		return "providerA服务";
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