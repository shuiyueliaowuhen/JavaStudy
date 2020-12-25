### springboot简介

#### 介绍

Spring Boot使开发独立的，产品级别的基于Spring的应用变得非常简单，你只需"just run"。 我们为Spring平台及第三方库提供开箱即用的设置，这样你就可以有条不紊地开始。多数Spring Boot应用需要很少的Spring配置。

你可以使用Spring Boot创建Java应用，并使用java -jar启动它或采用传统的war部署方式。

#### 解决的问题

* 依赖太多了, 且存在版本问题 

* 配置太多了且每次都一样, 大部分工程, 配置每次都是一样的, 从一个地方拷贝到另外一个地方. 且Spring发展10多年, 各种配置版本太多, 对于很多程序员来说, 分不清哪个是有效, 哪个无效. 

* 部署太麻烦. 需要tomcat部署, 项目结构也需要照着[Java EE](http://lib.csdn.net/base/17)的目录结构来写.

#### springboot特点

* 创建独立的Spring应用程序

* 嵌入的Tomcat，无需部署WAR文件

* 简化Maven配置

* 自动配置Spring

* 提供生产就绪型功能，如指标，健康检查和外部配置

* 绝对没有代码生成和对XML没有要求配置

#### SpringBoot功能

* 自动配置(auto-configuration)

一项简化配置的功能，比如在classpath中发现有spring security的jar包，则自动创建相关的bean等 

* starters(简化依赖)

这个比较关键，方便spring去集成各类组件，比如redis、mongodb等等。

#### 快速入门

仅列功能点和关键点，具体使用百度谷歌

* 创建项目，查看官网

* 继承第三方组件，导入对应的stater

* 全局异常，百度

* 404页面，使用WebServerFactoryCustomizer，百度

* jsp集成，百度

* 模版引擎，百度

* 日志集成，百度

* 继承swagger构建api，非常实用，百度配置

* Actuator监控，集成后可以通过url查看系统状态

* 静态资源访问,classpath下指定一目录名字：

  * /static

  * /public

  * /resources

  * /META-INF/resources

### 自定义starter

手动创建redis-starter

新建一个项目，不需要web功能:

Pom.xml

````xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>enjoy</groupId>
    <artifactId>redis-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.2.RELEASE</version>
    </parent>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>3.0.1</version>
        </dependency>
    </dependencies>
</project>
````

创建一个RedisProperties用于加载Redis需要的配置，这里为简单起见，并没有设置密码

```java
package cn.enjoy.redis;
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String host;
    private int port;

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
}
```

创建一个配置类，这个配置类用于加载配置，并实例化Jedis客户端

```java
package cn.enjoy.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration //开启配置
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisProperties.class) //开启使用映射实体对象
@ConditionalOnProperty//存在对应配置信息时初始化该配置类
 (
 prefix = "redis",//存在配置前缀redis
 value = "enabled",//开启
 matchIfMissing = true//缺失检查
 )
public class RedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(RedisProperties redisProperties){
        return new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }
}
```

自动化配置代码中有很多我们之前没有用到的注解配置，我们从上开始讲解

@Configuration：这个配置就不用多做解释了，我们一直在使用

@EnableConfigurationProperties：这是一个开启使用配置参数的注解，value值就是我们配置实体参数映射的ClassType，将配置实体作为配置来源。

SpringBoot内置条件注解

有关@ConditionalOnXxx相关的注解这里要系统的说下，因为这个是我们配置的关键，根据名称我们可以理解为具有Xxx条件，当然它实际的意义也是如此，条件注解是一个系列，下面我们详细做出解释

@ConditionalOnBean：当SpringIoc容器内存在指定Bean的条件

@ConditionalOnClass：当SpringIoc容器内存在指定Class的条件

@ConditionalOnExpression：基于SpEL表达式作为判断条件

@ConditionalOnJava：基于JVM版本作为判断条件

@ConditionalOnMissingBean：当SpringIoc容器内不存在指定Bean的条件

@ConditionalOnMissingClass：当SpringIoc容器内不存在指定Class的条件

@ConditionalOnNotWebApplication：当前项目不是Web项目的条件

@ConditionalOnProperty：指定的属性是否有指定的值

@ConditionalOnResource：类路径是否有指定的值

@ConditionalOnSingleCandidate：当指定Bean在SpringIoc容器内只有一个，或者虽然有多个但是指定首选的Bean

@ConditionalOnWebApplication：当前项目是Web项目的条件

以上注解都是元注解@Conditional演变而来的，根据不用的条件对应创建以上的具体条件注解。



到目前为止我们还没有完成自动化配置starter，我们需要了解SpringBoot运作原理后才可以完成后续编码。

Starter自动化运作原理

在注解@SpringBootApplication上存在一个开启自动化配置的注解@EnableAutoConfiguration来完成自动化配置，注解源码如下所示：

```java
@AutoConfigurationPackage
@Import({EnableAutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
    String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";
    Class<?>[] exclude() default {};
    String[] excludeName() default {};
}
```

在@EnableAutoConfiguration注解内使用到了@import注解来完成导入配置的功能，而EnableAutoConfigurationImportSelector内部则是使用了SpringFactoriesLoader.loadFactoryNames方法进行扫描具有META-INF/spring.factories文件的jar包。我们可以先来看下spring-boot-autoconfigure包内的spring.factories文件内容。

可以看到配置的结构形式是Key=>Value形式，多个Value时使用,隔开，那我们在自定义starter内也可以使用这种形式来完成，我们的目的是为了完成自动化配置，所以我们这里Key则是需要使用org.springframework.boot.autoconfigure.EnableAutoConfiguration

**自定义spring.factories**

我们在src/main/resource目录下创建META-INF目录，并在目录内添加文件spring.factories，具体内容如下所示：

配置自定义Starter的自动化配置

org.springframework.boot.autoconfigure.EnableAutoConfiguration=cn.enjoy.redis.RedisAutoConfiguration 

目前为止自定义的starter已经开发完毕

创建新项目，导入pom文件，写好配置文件即可使用

### 性能优化

#### 扫描优化（没啥用）

在默认情况下，我们会使用@SpringBootApplication注解来自动获取应用的配置信息，但这样也会带来一些副作用。使用这个注解后，会触发自动配置（auto-configuration）和组件扫描（component scanning），这跟使用@Configuration、@EnableAutoConfiguration和@ComponentScan三个注解的作用是一样的。这样做给开发带来方便的同时，会有以下的一些影响：

* 会导致项目启动时间变长（原因：加载了我们不需要使用的组件,浪费了cpu资源和内存资源）。当启动一个大的应用程序，或将做大量的集成测试启动应用程序时，影响会特别明显。

* 会加载一些不需要的多余的实例（beans）。

* 会增加CPU消耗和内存的占用。 

  

#### jvm优化（简单写，具体看jvm相关）

设置堆大小，减少FULL GC（fullgc会引起stw问题）

#### Undertow容器

默认情况下，Spring Boot 使用 Tomcat 来作为内嵌的 Servlet 容器

 可以将 Web 服务器切换到 Undertow 来提高应用性能。 

Undertow 是一个采用 Java 开发的灵活的高性能 Web 服务器，提供包括阻塞和基于 NIO 的非堵塞机制。Undertow 是红帽公司的开源产品

### 多数据源与jta+atomikos分布式事务

SpringBoot默认是集成事务的，只要在方法上加上@Transactional既可

但某些项目用到了多个数据库，也就代表有多个数据源。

#### 多数据源

配置文件加入两个数据库配置

创建两个datasource

#### 分布式事务

多数据源事物，jta+atomikos，百度，日常基本用不上

### springboot内嵌容器

#### tomcat加载流程

ServletWebServerFactoryAutoConfiguration 这类里面有个TomcatServletWebServerFactoryCustomizer这个类实现了WebServerFactoryCustomizer

EmbeddedTomcat->TomcatServletWebServerFactory->TomcatServletWebServerFactory.getWebServer()->getTomcatWebServer->TomcatWebServer->启动tomcat

### springboot启动流程


```flow
s1=>operation: springboot入口程序:SpringApplication.run
s2=>operation: 重载调用:new SpringApplication(primarySources).run(args)
s3=>operation: SpringApplication(primarySources)初始化加载各种配置类*
s4=>operation: .run(args)启动程序*

s1->s2(right)->s3(right)->s4(right)
```

#### new SpringApplication(primarySources)

```java
public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
		this.resourceLoader = resourceLoader;
		Assert.notNull(primarySources, "PrimarySources must not be null");
		//保存主类
		this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
		//判断当前是什么类型项目
		this.webApplicationType = WebApplicationType.deduceFromClasspath();
	//从类路径下找到META-INF/spring.factories配置的所有ApplicationContextInitializer
		setInitializers((Collection) getSpringFactoriesInstances(
				ApplicationContextInitializer.class));
	//从类路径下找到META-INF/spring.factories配置的所有ApplicationListener
		setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
		this.mainApplicationClass = deduceMainApplicationClass();
}
```

加载相关的类

#### new SpringApplication(primarySources).run

```java
public ConfigurableApplicationContext run(String... args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		ConfigurableApplicationContext context = null;
		Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
		configureHeadlessProperty();
		//从类路径下META‐INF/spring.factories，取得SpringApplicationRunListeners；
		SpringApplicationRunListeners listeners = getRunListeners(args);
	  //回调所有的获取SpringApplicationRunListener.starting()方法
		listeners.starting();
		try {
		  //封装命令行参数
			ApplicationArguments applicationArguments = new DefaultApplicationArguments(
					args);
		  //准备环境
			ConfigurableEnvironment environment = prepareEnvironment(listeners,
					applicationArguments);
			configureIgnoreBeanInfo(environment);
      //创建回调SpringApplicationRunListener.environmentPrepared()；
      //表示环境准备完成
			//打印Banner 
			Banner printedBanner = printBanner(environment);
      //根据环境创建context
			context = createApplicationContext();
		  //错误的异常报表
			exceptionReporters = getSpringFactoriesInstances(
					SpringBootExceptionReporter.class,
					new Class[] { ConfigurableApplicationContext.class }, context);
     //准备上下文环境;
     //将environment保存到ioc中；
     //applyInitializers()调用所有的ApplicationContextInitializer的initialize方法
     //调用所有的SpringApplicationRunListener的contextPrepared()；
			prepareContext(context, environment, listeners, applicationArguments,
					printedBanner);
     //SpringApplicationRunListener的contextLoaded
     //刷新容器
     //扫描，创建，加载所有组件；
			refreshContext(context);
			afterRefresh(context, applicationArguments);
			stopWatch.stop();
			if (this.logStartupInfo) {
				new StartupInfoLogger(this.mainApplicationClass)
						.logStarted(getApplicationLog(), stopWatch);
			}
			//所有的SpringApplicationRunListener回调started方法
			listeners.started(context);
			//获取所有的ApplicationRunner和CommandLineRunner进行调用
			callRunners(context, applicationArguments);
		}
		catch (Throwable ex) {
			handleRunFailure(context, ex, exceptionReporters, listeners);
			throw new IllegalStateException(ex);
		}

		try {
			//所有的SpringApplicationRunListener的running()；
			listeners.running(context);
		}
		catch (Throwable ex) {
			handleRunFailure(context, ex, exceptionReporters, null);
			throw new IllegalStateException(ex);
		}
		return context;
	}
```



