package com.example.java8.spring.componentScan;

import com.example.java8.spring.beanDefinition.Appconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class Scan {

    /**
     * AnnotatedBeanDefinitionReader的作用
     * 1、主要是可以动态、显示的注册一个bean；
     * 2、而且具备解析一个类的功能；和扫描解析一个类
     * 的功能相同；AnnotatedBeanDefinitionReader的应用场景
     * 1、可以显示、动态注册一个程序员提供的bean；
     * 2、在初始化spring容器的过程中他完成了对配置类的注册和解析功能；
     *
     *
     * 假设你的这个类是动态生成，在容器实例化的时候不存在那么肯定不存在，
     * 再或者这个包下面有N多类但是只有一个类加了注解，那么其实你不需要
     * 去扫描，只需要添加这一个加了注解的类即可，再或者一个类是你和第三
     * 方系统交互后得到的。那么这个时候我们可以把这个类通过
     * AnnotatedBeanDefinitionReader的register(Class clazz)方法
     * 把一个带注解的类注册给spring，或者注册我们的配置类
     *
     * 解析Appconfig.java当中的@ComponentScan注解的值（一般是一个包名），
     * 得到这个值之后去扫描这个值所代表的包下面的所有bean；简单的说就是spring
     * 如果想要完成扫描必须先提供Appconfig.java，所以Appconfig.java要在
     * 一开始就手动注册给spring，spring得到Appconfig.class之后把他解析
     * 成BeanDefintion对象，继而去获取@ComponentScan的值然后才开始扫描其他bean
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 第一种写法
         * ①比如我们可以在容器初始化之前动态注册一个自己的bean，
         * 就是上文提到的 AnnotatedBeanDefinitionReader的应用场景，
         * ②再比如可以利用ac对象来关闭或者开启spring的循环依赖，
         * 在笔者的第一篇博客里面也有提到，③还比如程序员可以在容器初始
         * 化之前注册自己实例化的BeanDefinition对象。
         */
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext();

        //动态注册一个配置类，不能扫描出来 因为他无法扫描自己 只能注册进来啊
        ac.register(Scan.class);

        //调用refresh方法
        //这里很多资料都叫做刷新spring容器
        //但是我觉得不合适，这是硬核翻译，比较生硬
        //笔者觉得理解为初始化spring容器更加精准
        //至于为什么以后慢慢更新再说
        ac.refresh();

        /**
         * 第二种写法
         */
        AnnotationConfigApplicationContext ac1 =
                new AnnotationConfigApplicationContext(Appconfig.class);

    }

}

@Component
class XXXP {

}