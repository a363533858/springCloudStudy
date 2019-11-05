package com.llzguazi.apigateway.config.security;/**
 * Created by MI on 2019/9/23.
 */

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/23
 **/
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("supper");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(grantedAuthority);
        User user = new User("llzguazi", new BCryptPasswordEncoder().encode("123456"),grantedAuthorities);
        return user;
    }
}
