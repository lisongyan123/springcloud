package com.example.java8.spring.beanLife;

/**
 * 1、调用 BeanFactoryPostProcessor 子类的 postProcessBeanFactory() 方法（工厂必须先创建），这里beanFactory 已经创建，beanDefinition已经解析完毕。
 * 2、调用bean 的构造方法。属性没有初始化（使用的都是默认值），依赖没有注入。
 * 3、调用 BeanPostProcessor.postProcessBeforeInitialization() 方法。（所有bean初始化都会调用）
 * 4、调用 InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization() 方法。（所有bean初始化都会调用）
 * 5、调用bean 定义的 init-method 方法（具体到某个bean的初始化）。
 * 6、如果bean 实现了 InitializingBean 接口，调用 InitializingBean.afterPropertiesSet() 方法（具体到某个bean的初始化）。
 * 7、调用 BeanPostProcessor.postProcessAfterInitialization() 方法。（所有bean初始化都会调用）
 * 8、调用 InstantiationAwareBeanPostProcessor.postProcessAfterInitialization() 方法。（所有bean初始化都会调用）
 *
 * 9、bean 销毁，先调用 destory-method 方法，如果bean实现了DisposableBean接口，再调用DisposableBean.destroy() 方法。
 */

/**
 * 实例化：指创建类实例（对象）的过程。比如使用构造方法new对象，为对象在内存中分配空间。（要创建对象，但是并未生成对象）
 * 初始化：指为类中各个类成员(被static修饰的成员变量)赋初始值的过程，是类生命周期中的一个阶段。简单理解为对象中的属性赋值的过程。（对象已经生成，为其属性赋值）
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean {

    private String name;
    private String address;
    private String phone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("【构造器】调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out
                .println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg0;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg0) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = arg0;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out
                .println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}

