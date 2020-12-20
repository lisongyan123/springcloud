package com.example.java8.spring.extend;
import com.example.java8.date.Date;
import com.example.java8.userful.annotation.test.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * postProcessBeanDefinitionRegistry方法可以修改在BeanDefinitionRegistry
 * 接口实现类中注册的任意BeanDefinition，也可以增加和删除BeanDefinition。原因
 * 是这个方法执行前所有常规的BeanDefinition已经被加载到BeanDefinitionRegistry
 * 接口实现类中，但还没有bean被实例化。
 */
public class DefaultBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 动态像容器放入一个bean
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        logger.info("BeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法,在这里可以增加修改删除bean的定义");
        for (int i=0;i<10;i++) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(User.class);
            builder.addPropertyValue("name", "HZZ"+i);
            builder.addPropertyValue("age", 15+i);
            builder.addPropertyValue("time", new Date());
            registry.registerBeanDefinition("user——def"+i,builder.getBeanDefinition());
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("BeanDefinitionRegistryPostProcessor的postProcessBeanFactory方法,在这里可以对beanFactory做一些操作");
    }
}
