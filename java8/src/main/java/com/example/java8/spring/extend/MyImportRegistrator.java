package com.example.java8.spring.extend;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

/**
 * 手动实现registerBeanDefinitions 只让TestUtil注解通过
 */
public class MyImportRegistrator implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 创建一个classpath的scanner
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        // 添加一个扫描的拦截器，只让被TestUtil注解装饰的class过
        scanner.addIncludeFilter(new AnnotationTypeFilter(TestUtil.class));
        for(BeanDefinition beanDefinition : scanner.findCandidateComponents(ClassUtils.getPackageName(annotationMetadata.getClassName()))){
            // 对于扫描出来的BeanDefinition，如果class是TestInferface
            if(beanDefinition.getBeanClassName().equals(TestInferface.class.getCanonicalName())){
                // 就将实现类TestImpl当做bean class 添加到beanDefinitionRegistry
                // 方便后面容器启动创建bean的时候创建出来
                beanDefinition.setBeanClassName(TestImpl.class.getCanonicalName());
                beanDefinitionRegistry.registerBeanDefinition(ClassUtils.getShortName(TestInferface.class), beanDefinition);
            }
        }
        /*
        GenericBeanDefinition beanPostFactoryPostProcessor = new GenericBeanDefinition();
        beanPostFactoryPostProcessor.setBeanClass(MyBeanFactoryPostProcessor.class);
        beanDefinitionRegistry.registerBeanDefinition("myBeanPostFactoryPostProcessor", beanPostFactoryPostProcessor);

        GenericBeanDefinition beanPostProcessor = new GenericBeanDefinition();
        beanPostProcessor.setBeanClass(MyBeanPostProcessor.class);
        beanDefinitionRegistry.registerBeanDefinition("myBeanPostProcessor", beanPostProcessor);
        */
    }


    private ClassPathScanningCandidateComponentProvider getScanner(){
        // 创建一个class path scanner
        return new ClassPathScanningCandidateComponentProvider(false, environment){
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                // 只要候选的class是个interface就让他过
                return beanDefinition.getMetadata().isInterface();
            }
        };
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}


@TestUtil
interface TestInferface {
    String hello();
}

class TestImpl implements TestInferface, InitializingBean {

    private String hello = "hello";

    @Override
    public String hello() {
        System.out.println("invoke hello");
        return hello;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public TestImpl(){
        System.out.println("hello in contructor:" + hello);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init method invoked, hello:" + hello);
    }
}