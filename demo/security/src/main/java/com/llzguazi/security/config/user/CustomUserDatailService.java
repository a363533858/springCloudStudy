package com.llzguazi.security.config.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MI on 2018/10/12.
 */
@Component
public class CustomUserDatailService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		String userName = "root";
		String passWord = "123456";
		List<GrantedAuthority> authorities = new ArrayList<>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
		authorities.add(grantedAuthority);
		CustomUserInfo userInfo = new CustomUserInfo(userName,passWord,authorities);
		return userInfo;
	}
}
