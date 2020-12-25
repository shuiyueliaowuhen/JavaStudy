### springboot内嵌容器

### springboot启动流程


```flow
s1=>operation: springboot入口程序:SpringApplication.run
s2=>operation: org.springframework.boot.SpringApplication#run
s3=>operation: org.springframework.boot.SpringApplication#SpringApplication
s4=>operation: 获取类型为SERVLET（另一种为REACTIVE）：this.webApplicationType = WebApplicationType.deduceFromClasspath(),
本方法下会加载启动类和监听器

s1->s2->s3->s4
```

