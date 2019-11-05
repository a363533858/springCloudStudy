package com.llzguazi.auth.config.security;/**
 * Created by MI on 2019/9/18.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/18
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().loginPage("/html/login").permitAll().successHandler(new DefaultAuthenticationSuccessHandler()).failureHandler(new DefaultAuthenticationFailureHandler())
                .and().authorizeRequests().anyRequest().authenticated();
//        http.addFilterAt()
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new DefaultUserDetailService())
                /*.and().authenticationProvider()*/;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }


    /**
     * 配置授权服务验证是否登陆过滤器
     * @return
     * @throws Exception
     */
    @Bean
    public BasicAuthenticationFilter basicAuthenticationFilter() throws Exception {
        BasicAuthenticationFilter basicAuthenticationFilter = new BasicAuthenticationFilter(authenticationManagerBean(),authenticationEntryPoint());
        return basicAuthenticationFilter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager authenticationManager = super.authenticationManagerBean();
        return authenticationManager;
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        BasicAuthenticationEntryPoint basicAuthenticationEntryPoint = new BasicAuthenticationEntryPoint();
        basicAuthenticationEntryPoint.setRealmName("llzguazi");
        return basicAuthenticationEntryPoint;
    }

}
