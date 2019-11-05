package com.llzguazi.apigateway.config.security;/**
 * Created by MI on 2019/9/23.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.accept.ContentNegotiationStrategy;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/23
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetailsService userDetailsService = new CustomUserDetailsService();
        return userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SimpleUrlAuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/");
        simpleUrlAuthenticationSuccessHandler.setTargetUrlParameter("redirectUrl");
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin().successHandler(simpleUrlAuthenticationSuccessHandler).permitAll()
                .and().authorizeRequests().antMatchers("/sys/index").authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder())
        ;
    }



    /*protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }*/

}
