# Spring 工具

# DevTools

## 什么是热部署

① 应用正在运行的时候，不需要重新启动应用。
② 对于Java应用程序来说，热部署就是在运行时更新java类文件

注意：热部署可以线上使用，但是最好不要，易于黑客攻击

## 作用

在开发环境中，由于每次修改完项目中的类都需要重启服务才能看到运行的结果，对于开发调试很不友好，浪费时间，引入devtools工具可以快速启动项目，这是它的核心功能之一。

### spring-boot-devtools 实现热部署/快速重启

- 自动重启

  spring-boot-devtools[热部署](https://so.csdn.net/so/search?q=热部署&spm=1001.2101.3001.7020)是对修改的类和配置文件进行重新加载，所以在重新加载的过程中会看到项目启动的过程，其本质上只是对修改类和配置文件的重新加载，所以速度极快。

  原理：

  使用了两个ClassLoader，一个Classloader加载那些不会改变的类（第三方Jar包），另一个ClassLoader加载会更改的类，称为restart ClassLoader,这样在有代码更改的时候，原来的restart ClassLoader 被丢弃，重新创建一个restart ClassLoader，由于需要加载的类相比较少，所以实现了较快的重启时间。

- 缓存禁用

  spring-boot-devtools 对于前端使用模板引擎的项目，能够自动禁用缓存，在页面修改后，只需要刷新浏览器器页面即可。

  原理：

  缓存可以提高性能，但在有模板引擎的开发中，模板引擎会缓存编译过的模板，防止重复解析模板，这会导致修改页面内容时，模板引擎不去重新解析模板，看不到修改过的内容，但devtools在开发环境中默认关闭模板引擎的缓存功能。devtools不会被打包进jar包或war包中，在生产环境中，模板引擎的缓存功能就可以正常使用了。

## 配置

- 依赖

  Maven:

  ```xml
  <dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-devtools</artifactId>
  </dependency>
  ```

  Gradle.

  ```groovy
  dependencies {
      compile("org.springframework.boot:spring-boot-devtools")
  }
  ```

  *spring-boot-devtools* 模块在生产环境中是默认禁用的，archives 的 repackage 在这个模块中默认也被排除。因此，它不会给我们的生产环境带来任何开销。
  
  > 运行打包的应用程序时，开发人员工具会自动禁用。如果你通过 `java -jar`或者其他特殊的类加载器进行启动时，都会被认为是“生产环境的应用”。将依赖标记为`optional`可选是一种最佳做法，可以防止将devtools依赖传递到其他模块中。Gradle 不支持开箱即用的`optional`依赖项，你可以参考[`propdeps-plugin`](https://github.com/spring-projects/gradle-plugins/tree/master/propdeps-plugin)。
  >
  > IDEA 中使用时，需要配置自动编译和运行时自动编译，参考下面地址配置即可：
  >https://qiancheng.me/post/coding/spring-boot-devtools-hotswap

## 参考

https://blog.csdn.net/isea533/article/details/70495714

https://baijiahao.baidu.com/s?id=1711760117237217574&wfr=spider&for=pc

https://www.cnblogs.com/liu2-/p/9118393.html





# Actuator

## SpringBoot四大核心

- Actuator：springboot程序监控器
- 自动装配：简单配置甚至零配置即可运行项目
- starter：jar包的引入，解决jar版本冲突问题
- CLI：命令行

## 作用

这是springboot程序的监控系统，可以实现健康检查，info信息等。在使用之前需要引入spring-boot-starter-actuator，并做简单的配置即可。

或者在项目部署后不用编写controller，测试网页访问是否正常

## 配置

依赖：

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

配置：

```yaml
# actuator 监控配置
management:
  #actuator端口 如果不配置做默认使用上面8080端口
  server:
    port: 8080
  endpoints:
    web:
      exposure:
        #默认值访问health,info端点  用*可以包含全部端点
        include: "*"
      #修改访问路径 2.0之前默认是/; 2.0默认是/actuator可以通过这个属性值修改
      base-path: /actuator
  endpoint:
    shutdown:
      enabled: true #打开shutdown端点
    health:
      show-details: always #获得健康检查中所有指标的详细信息

```

## 实战

引入依赖并编写好配置之后，启动项目，访问http://localhost:8080/actuator，这里多说一嘴，谷歌浏览器访问显示JSON格式，是装了一个插件——JSON Formatter。

这里可以看出，很多可以访问的路径，这些都是可被健康检查的指标。
例如我们访问一个http://localhost:8080/actuator/health路径，可以进行健康检查。

## 参考

https://www.jianshu.com/p/ac8cac722af0

https://www.cnblogs.com/caoweixiong/p/15325382.html