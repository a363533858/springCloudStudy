package com.llzguazi.consumerA.error;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 消除异常抛出，重复销毁同一个bean报错
 * Created by MI on 2018/10/10.
 */
@Component
public class FeignBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

		ConfigurableListableBeanFactory beanFactory = configurableListableBeanFactory;
		if (containsBeanDefinition(beanFactory, "feignContext", "eurekaAutoServiceRegistration")) {
			BeanDefinition bd = beanFactory.getBeanDefinition("feignContext");
			bd.setDependsOn("eurekaAutoServiceRegistration");
		}
	}
	private boolean containsBeanDefinition(ConfigurableListableBeanFactory beanFactory, String... beans) {
		return Arrays.stream(beans).allMatch(b -> beanFactory.containsBeanDefinition(b));
	}
}
