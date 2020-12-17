package com.example.java8.spring.beanDefinition;

/**
 * spring容器启动的时候会去调用ConfigurationClassPostProcessor这个bean工厂的后置处理器完成扫描
 * 所谓的spring扫描就是把类的信息读取到，但是读取到类的信息存放到哪里呢scope(singleton和prototype)
 * ，lazy，dependsOn等等信息需要存储，所以spring设计了一个BeanDefintion的类用来存储这些信息。故而
 * 当spring读取到类的信息之后会实例化一个BeanDefinition的对象，继而调用这个对象的各种set方法存储信息；
 * 每扫描到一个符合规则的类，spring都会实例化一个BeanDefinition对象，然后把根据类的类名生成一个bean的
 * 名字（比如一个类IndexService，spring会根据类名IndexService生成一个bean的名字`indexService`,
 * spring内部有一套默认的名字生成规则，继而 spring 会把这个beanDefinition对象和生成的beanName放到
 * 一个map当中key=beanName，value=beanDefinition对象
 */

/**
 * depends-on用来指定Bean初始化及销毁时的顺序。
 * <bean id="jedisPool" class="redis.clients.jedis.JedisPool" destroy-method="destroy" depends-on="jedisPoolConfig">
 *     <constructor-arg ref="jedisPoolConfig" />
 *     <constructor-arg value="127.0.0.1" />
 *     <constructor-arg type="int" value="6379" />
 * </bean>
 */
public class SpringStudy {

}
