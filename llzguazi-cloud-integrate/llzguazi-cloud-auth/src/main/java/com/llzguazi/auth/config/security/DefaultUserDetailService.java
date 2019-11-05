package com.llzguazi.auth.config.security;/**
 * Created by MI on 2019/9/17.
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
 * @Date 2019/9/17
 **/
public class DefaultUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(!"llzguazi".equals(userName)){
            throw new UsernameNotFoundException("账号或密码输入不正确！");
        }
        GrantedAuthority grantedAuthorityA = new SimpleGrantedAuthority("web");
        GrantedAuthority grantedAuthorityB = new SimpleGrantedAuthority("mobile");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(grantedAuthorityA);
        grantedAuthorities.add(grantedAuthorityB);
        User user = new User("llzguazi",new BCryptPasswordEncoder().encode("1234567"),grantedAuthorities);
        return user;
    }
}
