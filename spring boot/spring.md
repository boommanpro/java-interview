## Spring

1.BeanPostProcessor

如果我们想在Spring容器中完成bean实例化、配置以及其他初始化方法前后要添加一些自己逻辑处理。
我们需要定义一个或多个BeanPostProcessor接口实现类，然后注册到Spring IoC容器中

2.BeanFactoryPostProcessor
注册一个BeanFactoryPostProcessor实例需要定义一个Java类来实现BeanFactoryPostProcessor接口，并重写该接口的postProcessorBeanFactory方法


3.ApplicationContextInitializer

调用该接口的initialize方法在ConfigurableApplicationContext#refresh之前

4.BeanNameAware

#setBeanName() 配置这个Bean的名称

5.InitializingBean

在properties注入完毕后会 调用#afterPropertiesSet() 

6.DisposableBean

在Bean销毁时会调用#destroy()方法

7.BeanFactoryAware

获取setBeanFactory 在Bean填充后 初始化之前


## Spring Bean 生命周期

copy from:https://www.cnblogs.com/redcool/p/6397398.html

初始化Bean开始
    |
    |
反射调用Bean的初始化方法实例化Bean
    |
    |
通过反射注入bean的属性值
    |
    |
Aware注入 比如BeanNameAware BeanClassLoaderAware
    |
    |
调用每个BeanPostInitializer接口中postProcessorBefore
    |
    |
调用初始化方法
    |
    |
调用每个BeanPostInitializer接口中postProcessorAfter
    |
    |
注册需要执行销毁方法的Bean


```java

    @Bean(initMethod = "init")
    public MySpringBean mySpringBean(){
        return new MySpringBean();
    }
```

```java
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @date 2019/6/11 15:00
 * @created by BoomManPro
 */
@Slf4j
public class MySpringBean implements BeanNameAware, BeanFactoryAware, InitializingBean, ApplicationContextAware , DisposableBean {

    private ApplicationContext applicationContext;


    @PostConstruct
    public void constructInit(){
        log.info(" constructInit......");

    }

    public MySpringBean() {
        log.info("new MySpringBean......");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        log.info("ApplicationContextAware-setApplicationContext......");
        this.applicationContext = context;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean-afterPropertiesSet......");
    }

    @Override
    public void setBeanFactory(BeanFactory bf) throws BeansException {
        log.info("BeanFactoryAware-setBeanFactory......");
    }

    @Override
    public void setBeanName(String name) {
        log.info("BeanNameAware-setBeanName......");
    }

    public void init() {
        log.info("init-method......");
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean-method......");
    }
}
```

## 单词学习
hierarchical  英 /haɪə'rɑːkɪk(ə)l/  adj. 分层的；等级体系的

## 写在末尾

最近在学习Spring Boot的启动流程,但是Spring Boot中用到了很多关于Spring Bean 生命周期相关的东西,遂记录下来备忘

时间:2019年6月10日开始