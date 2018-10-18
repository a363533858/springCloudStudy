package com.llzguazi.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MI on 2018/10/9.
 */
@Component
public class MyFilter extends ZuulFilter {


	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
	 	pre：路由之前
	 	routing：路由之时
	 	post： 路由之后
	 	error：发送错误调用
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * filterOrder：过滤的顺序
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * shouldFilter：这里可以写逻辑判断，是否要过滤，true:过滤。
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(request.getRequestURI());
		return null;
	}
}
