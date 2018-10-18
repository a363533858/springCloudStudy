package com.llzguazi.security.config;

import com.llzguazi.security.config.user.CustomUserInfo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MI on 2018/10/15.
 */
public class CustomSecurityContextRepository implements SecurityContextRepository {
	private SecurityContext securityContext;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;

	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder httpRequestResponseHolder) {
		SecurityContextImpl securityContext = new SecurityContextImpl();
		String userName = "root";
		String passWord = "123456";
		List<GrantedAuthority> authorities = new ArrayList<>();
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role_USER");
		authorities.add(simpleGrantedAuthority);
		CustomUserInfo userInfo = new CustomUserInfo(userName,passWord,authorities);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userInfo,null,authorities);
		securityContext.setAuthentication(authenticationToken);
		return securityContext;
	}

	@Override
	public void saveContext(SecurityContext securityContext, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		this.securityContext = securityContext;
		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
	}

	@Override
	public boolean containsContext(HttpServletRequest httpServletRequest) {
		return false;
	}

	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public SecurityContext getSecurityContext() {
		return securityContext;
	}

	public void setSecurityContext(SecurityContext securityContext) {
		this.securityContext = securityContext;
	}
}
