package com.llzguazi.security.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * 验证url需要权限
 * Created by MI on 2018/10/12.
 */
public class CustomAccessDecisionManager implements AccessDecisionManager {
	/**
	 * // 检查用户是否够权限访问资源
	 * @param authentication 从spring的全局缓存SecurityContextHolder中拿到的，里面是用户的权限信息
	 * @param o 是url
	 * @param collection 所需的权限
	 * @throws AccessDeniedException
	 * @throws InsufficientAuthenticationException
	 */
	@Override
	public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
		if (collection == null) {
			return;
		}
		Iterator<ConfigAttribute> ite = collection.iterator();
		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			String needRole = ((SecurityConfig) ca).getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needRole.equals(ga.getAuthority())) {
					return;
				}
			}
		}
		//注意：执行这里，后台是会抛异常的，但是界面会跳转到所配的access-denied-page页面
		throw new AccessDeniedException("no right");
	}

	/**
	 * 支持ConfigAttribute入参的验证
	 * @param configAttribute
	 * @return
	 */
	@Override
	public boolean supports(ConfigAttribute configAttribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
