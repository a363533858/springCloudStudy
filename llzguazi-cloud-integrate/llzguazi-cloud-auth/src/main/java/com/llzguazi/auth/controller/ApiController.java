package com.llzguazi.auth.controller;/**
 * Created by MI on 2019/9/19.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/19
 **/
@RestController("/sys")
public class ApiController {

    @GetMapping("/test")
    public Object test(){
        return "maye";
    }
}
