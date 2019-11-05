package com.llzguazi.auth.config.security;/**
 * Created by MI on 2019/9/20.
 */

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.util.Assert;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/20
 **/
public class DefaultSecurityContextHolderStrategy implements SecurityContextHolderStrategy {

    private static SecurityContext contextHolder;

    @Override
    public void clearContext() {
        contextHolder = null;
    }

    @Override
    public SecurityContext getContext() {
        if (contextHolder == null) {
            contextHolder = new SecurityContextImpl();
        }
        return contextHolder;
    }

    @Override
    public void setContext(SecurityContext context) {
        Assert.notNull(context, "Only non-null SecurityContext instances are permitted");
        contextHolder = context;
    }

    @Override
    public SecurityContext createEmptyContext() {
        return new SecurityContextImpl();
    }
}
