### springboot内嵌容器

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



