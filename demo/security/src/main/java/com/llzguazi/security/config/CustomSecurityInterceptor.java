package com.llzguazi.security.config;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**过滤器，验证所有需要权限认证的url
 * Created by MI on 2018/10/12.
 */
public class CustomSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	/**
	 * ********************************************filter****************************************************
	 * @param filterConfig
	 * @throws ServletException
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String url = ((HttpServletRequest) req).getRequestURI();
		this.getAccessDecisionManager().decide(authentication,authentication,this.getSecurityMetadataSource().getAttributes(url));

		filterChain.doFilter(req,resp);
	}

	@Override
	public void destroy() {

	}

	/**
	 *
	 * *********************************************AbstractSecurityInterceptor***********************************************
	 * @return
	 */
	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.getSecurityMetadataSource();
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}
}
