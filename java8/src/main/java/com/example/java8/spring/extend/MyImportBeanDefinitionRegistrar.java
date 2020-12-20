package com.example.java8.spring.extend;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 同样也是spring的扩展点之一，实现这个接口主要可以得到BeanDefinitionRegistry，
 * 也就是bean工厂的注册器，可以直接向bean工厂注册bean mybatis的动态注入也是通过这个接口实现的
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

	}
}
