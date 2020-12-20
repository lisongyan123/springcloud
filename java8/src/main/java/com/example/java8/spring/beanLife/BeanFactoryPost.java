package com.example.java8.spring.beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//如果有多个实现了BeanFactoryPostProcessor接口的对象，
// 可以通过加上@Order注解来实现顺序执行，同样是设置的值越小越先执行
public class BeanFactoryPost implements BeanFactoryPostProcessor {

    public BeanFactoryPost() {
        super();
        System.out.println("这是BeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
            throws BeansException {
        System.out
                .println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition bd = arg0.getBeanDefinition("person");
        bd.getPropertyValues().addPropertyValue("phone", "110");

        System.out.println(arg0.containsBean("user"));
        String[] strs = arg0.getSingletonNames();
        for (String string : strs) {
            System.out.println(string);
        }
    }

}