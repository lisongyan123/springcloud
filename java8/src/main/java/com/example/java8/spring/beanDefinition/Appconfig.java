package com.example.java8.spring.beanDefinition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan("com.example")
@Configuration
public class Appconfig {
    /**
     * 下面x注解了 y没注解 beanDefintionMap中会包含x
     * org.springframework.context.support的
     * invokeBeanFactoryPostProcessors方法就在此
     * BeanFactoryPostProcessor，只要实现这个接口便
     * 是一个bean工厂后置处理器了，
     */
    @Component
    class X {
        public X() {
            System.out.println("X Constructor");
        }
    }

    class Y {
    }

    static class Test {
        public static void main(String[] args) {
            AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
            ac.register(Appconfig.class);
            ac.refresh();
        }
    }

    class Z {
    }

    static class Test2 {
        public static void main(String[] args) {
            AnnotationConfigApplicationContext ac =
                    new AnnotationConfigApplicationContext();
            ac.register(Appconfig.class);
            ac.refresh();
            //正常打印
            System.out.println(ac.getBean(Y.class));
            //正常打印
            System.out.println(ac.getBean(Z.class));
            //异常打印
            //虽然X加了注解，但是被偷梁换柱了，故而异常
            System.out.println(ac.getBean(X.class));
        }

    }

    /**
     * 手动添加Y类
     */
    @Component
    class TestBeanFactoryPostPorcessor implements BeanFactoryPostProcessor {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            //转换为子类，因为父类没有添加beanDefintion对象的api
            DefaultListableBeanFactory defaultbf =
                    (DefaultListableBeanFactory) beanFactory;

            //new一个Y的beanDefinition对象，方便测试动态添加
            GenericBeanDefinition y = new GenericBeanDefinition();
            y.setBeanClass(Y.class);
            //添加一个beanDefinition对象，原本这个Y没有被spring扫描到
            defaultbf.registerBeanDefinition("y", y);

            //得到一个已经被扫描出来的beanDefintion对象x
            //因为X本来就被扫描出来了，所以是直接从map中获取
            BeanDefinition x = defaultbf.getBeanDefinition("x");
            //修改这个X的beanDefintion对象的class为Z
            //原本这个x代表的class为X.class；现在为Z.class
            x.setBeanClassName("com.example.java8.spring.beanDefinition.Z");
        }

    }
}





