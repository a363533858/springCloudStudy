package com.llzguazi.security.config;

import com.llzguazi.security.config.user.CustomUserDatailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

/**
 * Created by MI on 2018/10/11.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	/**
	 * 全局请求忽略规则配置（比如说静态文件，比如说注册页面）、全局HttpFirewall配置、是否debug配置、全局SecurityFilterChain配置、privilegeEvaluator、expressionHandler、securityInterceptor、
	 * @param web
	 * @throws Exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	/**
	 * 具体的权限控制规则配置。
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		http.authorizeRequests()
				.antMatchers("/index").hasAnyRole("USER","ADMIN")
				.antMatchers("/admin").hasAnyRole("ADMIN")
				.antMatchers(HttpMethod.GET,"/login").permitAll()
				.anyRequest().authenticated()
				.and()
				.addFilterAt(getCustomSecurityInterceptor(), FilterSecurityInterceptor.class)
				.addFilterBefore(getSecurityContextPersistenceFilter(),SecurityContextPersistenceFilter.class)
//				.addFilterAfter(getExceptionTranslationFilter(), ExceptionTranslationFilter.class)
				.securityContext().securityContextRepository(new CustomSecurityContextRepository())
				.and()
//				.exceptionHandling().accessDeniedHandler(getAccessDeniedHandlerImpl())
				.exceptionHandling().accessDeniedPage("/goback")
		;

	}

	/**
	 * AuthenticationManagerBuilder用来配置全局的认证相关的信息，其实就是AuthenticationProvider和UserDetailsService，前者是认证服务提供商，后者是用户详情查询服务。
	 * @param auth
	 * @throws Exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoAuthenticationProvider());
	}

	/**
	 * 通过jdbc获取用户角色列表信息具体实现类
	 * @return
	 */
	@Bean
	public CustomUserDatailService getCustomUserDatailService(){
		return new CustomUserDatailService();
	}

	/**
	 * 通过jdbc获取用户角色列表信息
	 * @return
	 */
	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(getCustomUserDatailService());
		provider.setHideUserNotFoundExceptions(false);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	//*********************************配置url拦截权限验证*******************************************

	/**
	 * 处理获取请求url需要的权限
	 * @return
	 */
	@Bean
	public CustomMetadataSourceService getCustomMetadataSourceService(){
		return new CustomMetadataSourceService();
	}

	/**
	 * 验证url需要权限
	 * @return
	 */
	@Bean
	public CustomAccessDecisionManager getCustomAccessDecisionManager(){
		return new CustomAccessDecisionManager();
	}


	@Bean
	public CustomSecurityInterceptor getCustomSecurityInterceptor(){
		CustomSecurityInterceptor interceptor = new CustomSecurityInterceptor();
		interceptor.setAccessDecisionManager(this.getCustomAccessDecisionManager());
		interceptor.setSecurityMetadataSource(this.getCustomMetadataSourceService());
		try {
			interceptor.setAuthenticationManager(this.authenticationManager());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return interceptor;
	}

//**********************************SecurityContextPersistenceFilter************************************************
	//配置securityContext数据来源
	@Bean
	public SecurityContextPersistenceFilter getSecurityContextPersistenceFilter(){
		return new SecurityContextPersistenceFilter(new CustomSecurityContextRepository());
	}
//************************************ExceptionTransactionFilter*****************************
//异常拦截
	/*@Bean
	public ExceptionTranslationFilter getExceptionTranslationFilter(){
		ExceptionTranslationFilter exceptionTransactionFilter = new ExceptionTranslationFilter(new HttpStatusEntryPoint(HttpStatus.FORBIDDEN));
		AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
		accessDeniedHandler.setErrorPage("/goback");
		exceptionTransactionFilter.setAccessDeniedHandler(accessDeniedHandler);
		return exceptionTransactionFilter;
	}*/

	@Bean
	public AccessDeniedHandlerImpl getAccessDeniedHandlerImpl(){
		AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
		accessDeniedHandler.setErrorPage("/goback");
		return accessDeniedHandler;
	}
}
