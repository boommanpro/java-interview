## 什么是注解驱动开发 !!

Spring的核心是ApplicationContext,那么AnnotationConfigApplicationContext的创建是与Spring的注解相关的


常见使用注解及不常见的注解有哪些

@Configuration

被@Configuration注解标识的类 类比于原来xml开发的 bean.xml


@Bean 在被@Configuration的类下生效  相当于xml开发是的 <bean></bean>

Bean生命周期相关  

其中
@PostConstruct @PreDestroy 是javax的注解 分别是bean创建 和 bean销毁

```java

    @Bean(initMethod = "init",destroyMethod = "beanDestroyMethod")
    public MySpringBean mySpringBean() {
        return new MySpringBean();
    }
```

```java
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

    public void beanDestroyMethod(){
        log.info("beanDestroyMethod");
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean-method......");
    }
}

```

```log
MySpringBean.<init>(MySpringBean.java:29)  new MySpringBean......
MySpringBean.setBeanName(MySpringBean.java:50)  BeanNameAware-setBeanName......
MySpringBean.setBeanFactory(MySpringBean.java:45)  BeanFactoryAware-setBeanFactory......
MySpringBean.setApplicationContext(MySpringBean.java:34)  ApplicationContextAware-setApplicationContext......
MySpringBean.constructInit(MySpringBean.java:24)   constructInit......
MySpringBean.afterPropertiesSet(MySpringBean.java:40)  InitializingBean-afterPropertiesSet......
MySpringBean.init(MySpringBean.java:54)  init-method......
```

1.执行构造方法
2.BeanNameAware接口
3.BeanFactoryAware接口
4.ApplicationContextAware接口
5.@PostConstruct注解
6.InitializingBean接口
7.@Bean(initMethod="init")

@ComponentScan
扫描Spring注解 与xml中  <context:component-scan base-package=""/> 功能一样

@Scope  singleton  prototype request session 等


@Lazy 是否延迟加载

spring源码中 org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration#methodValidationPostProcessor 有用到

在构造方法前加也会让Bean延迟加载

@Conditional
在org.springframework.boot.autoconfigure.condition有众多在创建Bean要达到某种要求
如@ConditionalOnProperty 必须properties内容满足条件才可以创建bean
如@ConditionalOnMissingBean 如果有这个Bean就不能再创建了等

@Import

@Value
可以搭配@Validation使用

@PropertySource

@Autowired

@Qualifier

@Resource

@Inject

@Profile



