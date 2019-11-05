package com.llzguazi.auth;/**
 * Created by MI on 2019/9/19.
 */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.Mac;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/19
 **/
public class MainMethod {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode("123456");
        System.out.println(pass);
    }

    public void test(){

    }
}
