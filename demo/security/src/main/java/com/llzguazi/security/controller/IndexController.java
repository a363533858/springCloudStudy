package com.llzguazi.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MI on 2018/10/15.
 */
@RestController()
public class IndexController {

	@RequestMapping(value = "/index")
	public Object index(){
		return "hello world";
	}

	@RequestMapping(value = "/admin")
	public Object admin(){
		return "I'm the king";
	}

	@RequestMapping(value = "/goback")
	public Object goback(){
		return "this is a wrong";
	}


}
