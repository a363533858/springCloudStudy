package com.llzguazi.apigateway.config.security;/**
 * Created by MI on 2019/10/8.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/10/8
 **/
@Configuration
@EnableRedisHttpSession
public class RedisHttpSessionConfig {

    /*@Bean
    public LettuceConnectionFactory connectionFactory() {

        return new LettuceConnectionFactory();
    }*/
}
