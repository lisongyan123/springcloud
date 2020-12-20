package com.example.java8.spring.applicationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * bean中通过autowired注入
 */
@Component
public class X {
    @Autowired
    Y y;

    @Component
    class Y {
    }

    @Autowired
    ApplicationContext applicationContext;

    public X() {
        System.out.println("x 的构造方法");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(X.class);
        int i = 0;
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //打印spring容器当中所有bean的bd
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(i++ + beanDefinitionName);
        }
    }
}

/**
 * 实现ApplicationContextAware接口获取ApplicationContext对象
 */
@Component
class Util implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public void setApplicationContext(ApplicationContext applicationContext) {
        Util.applicationContext = applicationContext;
    }

    //可以对getBean封装
    public static Object getBean(String name) {
        System.out.println("可能你需要干一点其他事吧");
        return applicationContext.getBean(name);
    }
}

/**
 * 普通对象的注入如果注入的属性是单例，那么spring首先从单例池获取，
 * 如果获取不到直接实例化这个bean，放到单例池在返回，完成注入；如
 * 果是原型的每次注入就直接实例化这个原型bean返回完成注入；
 * <p>
 * ApplicationContext对象的注入不同，如果注入的属性是
 * ApplicationContext类型，那么spring会先从resolvableDependencies
 * 这个map当中去找，如果找到直接返回一个ApplicationContext对象完成属性注入；
 * map作用是把一些通用的对象、可能会被别的bean注入，那么你可以调用这个方法把
 * 这写对象放到一个map当中——resolvableDependencies
 */
@Component
class A1 {

    //注意B是原型的  scope=prototype
    @Autowired
    A2.B b;

    public A2.B m() {

        //直接返回注入进来的b；肯定有问题
        //返回的永远是A实例化的时候注入的那个bean
        //违背的B设计成原型的初衷
        return b;
     }
}

@Component
class A2 {

    @Autowired
    ApplicationContext applicationContext;

    public B m() {
        //每次调用m都是通过spring容器去获取b
        //如果b是原型，每次拿到的都是原型b
        B b = applicationContext.getBean(B.class);
        return b;
    }

    @Component
    class B {
    }
}
