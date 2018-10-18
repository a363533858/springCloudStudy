package com.llzguazi.security.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 获取请求url需要的权限
 * Created by MI on 2018/10/12.
 */
public class CustomMetadataSourceService implements FilterInvocationSecurityMetadataSource {
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		//获取当前访问url
		String url = (String) object;

		ConfigAttribute  configAttribute = new SecurityConfig("ROLE_ADMIN");
		List<ConfigAttribute> result = new ArrayList<>();
		result.add(configAttribute);
		return result;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
