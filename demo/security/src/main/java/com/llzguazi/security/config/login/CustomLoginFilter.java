package com.llzguazi.security.config.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MI on 2018/10/12.
 */
public class CustomLoginFilter extends AbstractAuthenticationProcessingFilter {

	private static final String SPRING_SECURITY_RESTFUL_LOGIN_URL = "/login";

	public CustomLoginFilter() {
		super(new AntPathRequestMatcher(SPRING_SECURITY_RESTFUL_LOGIN_URL, "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
		return null;
	}
}
