package com.llzguazi.auth.thymeleaf;/**
 * Created by MI on 2019/9/19.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/19
 **/
@Controller
@RequestMapping("/html")
public class AuthHandlerController {

    @RequestMapping("/error1")
    public ModelAndView errorPage(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("/errorPage");
        mv.addObject("name","llzguazi");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView loginPage(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("/loginPage");
        mv.addObject("name","llzguazi");
        return mv;
    }
}
