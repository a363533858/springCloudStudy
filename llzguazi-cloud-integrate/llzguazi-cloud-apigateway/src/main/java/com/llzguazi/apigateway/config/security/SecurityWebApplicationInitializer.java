package com.llzguazi.apigateway.config.security;/**
 * Created by MI on 2019/9/23.
 */

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/23
 **/
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer(){
        super(WebSecurityConfig.class,RedisHttpSessionConfig.class);
    }
}
