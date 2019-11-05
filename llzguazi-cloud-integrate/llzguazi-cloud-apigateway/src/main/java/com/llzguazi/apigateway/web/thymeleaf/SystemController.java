package com.llzguazi.apigateway.web.thymeleaf;/**
 * Created by MI on 2019/9/24.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/24
 **/
@Controller
@RequestMapping("/sys")
public class SystemController {

    @GetMapping("/login")
    ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }

    @GetMapping("/index")
    ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }
}
