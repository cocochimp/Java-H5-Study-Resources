# Swagger学习资源

## 1. Swagger简介

![图片](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/13_Swagger/640)

> 1、前后端分离：

* Vue + Springboot 开发模式

* 后端时代：前端只用管理静态页面；html—>后端。模板引擎 JSP—>后端是主力

> 2、前后端分离时代：

- 前端 ：前端控制层、视图层【前端团队】
- 后端：后端控制层、服务层、数据访问层【后端团队】
- 前后端通过API进行交互【交互方式】
- 前后端相对独立且松耦合；
- 前后端甚至可以部署在不同的服务器上

> 3、产生的问题：

- 前后端集成，前端或者后端无法做到“及时协商，尽早解决”，最终导致问题集中爆发

> 4、解决方案

* 首先定义schema [ 计划的提纲 ]，并实时跟踪最新的API，降低集成风险
* 早些年：指定word计划文档
* 前后端分离：
  * 前端测试后端接口：postman
  * 后端提供接口，需要实施更新最新的消息及改动！

> 5、Swagger诞生

- 号称世界上最流行的API框架
- Restful Api 文档在线自动生成器 => **API 文档 与API 定义同步更新**
- 直接运行，在线测试API
- 支持多种语言 （如：Java，PHP等）
- 官网：https://swagger.io/



## 2. 第一个Swagger程序

> 1、前期准备

**SpringBoot集成Swagger** => **springfox**，两个jar包

- **Springfox-swagger2**
- swagger-springmvc

~~~xml
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger2</artifactId>
   <version>2.9.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>2.9.2</version>
</dependency>
~~~



> 2、项目测试

1. 创建一个普通的SpringBoot项目，支持web应用

2. 添加Maven依赖
3. 编写HelloController，测试确保运行成功！

```java
package com.koko.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String toHello(){
        return "hello";
    }

}
```

4. SwaggerConfig配置类

```java
package com.koko.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //配置类
@EnableSwagger2// 开启Swagger2的自动配置
public class SwaggerConfig {


}
```

5. 测试：http://localhost:8080/swagger-ui.html

![image-20220309215719023](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309215719023.png)

* 测试成功！

* 注意：报错的话更改 spring-boot-starter-parent 版本

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.5.6</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```



## 3. Swagger的配置

### 3.1 配置基本页面

1. SwaggerConfig配置类中

* Swagger实例Bean是Docket，所以通过配置Docket实例来配置Swaggger
* Docket 实例关联上 apiInfo()

```java
@Bean
public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
}
```

* 可以通过apiInfo()属性配置文档信息

```java
//配置文档信息
private ApiInfo apiInfo() {
    Contact contact = new Contact("koko", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
    return new ApiInfo(
            "Swagger学习", // 标题
            "学习演示如何配置Swagger", // 描述
            "v1.0", // 版本
            "http://terms.service.url/组织链接", // 组织链接
            contact, // 联系人信息
            "Apach 2.0 许可", // 许可
            "许可链接", // 许可连接
            new ArrayList<>()// 扩展
    );
}
```

2. 测试，访问http://localhost:8080/swagger-ui.html

![image-20220310092630514](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310092630514.png)



### 3.2 配置扫描接口

> 1、基本方法

1. SwaggerConfig配置类

```java
@Bean
public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            //enable设置是否启动Swagger
            .enable(false)
            //通过.select()方法，去配置扫描接口
            .select()
            //RequestHandlerSelectors配置如何扫描接口
            .apis(RequestHandlerSelectors.basePackage("com.koko.controller"))
            // 配置如何通过path过滤,即这里只扫描请求以/koko开头的接口
            .paths(PathSelectors.ant("/koko/**"))
            .build();
}
```

* RequestHandlerSelectors配置的一些方法

```java
any() // 扫描所有，项目中的所有接口都会被扫描到
none() // 不扫描接口
// 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
withMethodAnnotation(final Class<? extends Annotation> annotation)
// 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
withClassAnnotation(final Class<? extends Annotation> annotation)
basePackage(final String basePackage) // 根据包路径扫描接口
```

* PathSelectors配置的一些方法

```java
any() // 任何请求都扫描
none() // 任何请求都不扫描
regex(final String pathRegex) // 通过正则表达式控制
ant(final String antPattern) // 通过ant()控制
```



### 3.3 配置Swagger开关

> 1、测试

1. SwaggerConfig配置类中

```java
@Bean
public Docket docket(Environment environment) {
    // 设置要显示swagger的环境
    Profiles of = Profiles.of("dev", "test");
    // 判断当前是否处于该环境
    // 通过 enable() 接收此参数判断是否要显示
    boolean b = environment.acceptsProfiles(of);

    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            //enable设置是否启动Swagger
            .enable(b)
            //通过.select()方法，去配置扫描接口
            .select()
            //RequestHandlerSelectors配置如何扫描接口
            .apis(RequestHandlerSelectors.basePackage("com.koko.controller"))
            // 配置如何通过path过滤,即这里只扫描请求以/koko开头的接口
            .paths(PathSelectors.ant("/koko/**"))
            .build();
}
```

* 通过enable()方法配置是否启用swagger，如果是false，swagger将不能在浏览器中访问了
* 如何动态配置当项目处于test、dev环境时显示swagger，处于prod时不显示？

2. 设置配置文件

* application.properties

```properties
spring.profiles.active=dev
```

* application-dev.properties（开发环境）

```properties
server.port=8081
```

* application-pro.properties（发布环境）

```properties
server.port=8082
```

3. 测试

* 访问http://localhost:8081/swagger-ui.html时:（开发环境）

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310124059300.png" alt="image-20220310124059300" style="zoom:50%;" />

页面正常显示

* 访问http://localhost:8082/swagger-ui.html时：

无法访问！！！实现环境改变的功能！！！



### 3.4 配置API分组

> 1、实现步骤

1. 在SwaggerConfig配置类的docket方法中

* 如果没有配置分组，默认是default。通过groupName()方法即可配置分组

```java
@Bean
public Docket docket(Environment environment) {
   return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
      .groupName("hello") // 配置分组
       // 省略配置....
}
```

2. 配置多个分组方法：

* 配置多个docket

```java
@Bean
public Docket docket1(){
    return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
}
@Bean
public Docket docket2(){
    return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
}
@Bean
public Docket docket3(){
    return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
}
```

3. 测试：http://localhost:8081/swagger-ui.html

![image-20220310142057770](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310142057770.png)



### 3.5 常见注解

> 1、注解的简单说明

* Swagger的所有注解定义在io.swagger.annotations包下（下面是常见的）

| Swagger注解                                            | 简单说明                                             |
| ------------------------------------------------------ | ---------------------------------------------------- |
| @Api(tags = "xxx模块说明")                             | 作用在模块类上                                       |
| @ApiOperation("xxx接口说明")                           | 作用在接口方法上                                     |
| @ApiModel("xxxPOJO说明")                               | 作用在模型类上：如VO、BO                             |
| @ApiModelProperty(value = "xxx属性说明",hidden = true) | 作用在类方法和属性上，hidden设置为true可以隐藏该属性 |
| @ApiParam("xxx参数说明")                               | 作用在参数、方法和字段上，类似@ApiModelProperty      |



> 2、举例讲解上述五个注解

* 以注释了序号，可以和上述表对应！

1. HelloController页面控制跳转类

```java
package com.koko.controller;

import com.koko.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "1、模块类")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @ApiOperation("2、接口方法")
    @GetMapping("/hello02")
    public String toHello02(@ApiParam("5、接口中的参数、方法和字段") String username){
        return "hello" + username;
    }

}
```

2. User实体类

```java
package com.koko.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("3、模型类(实体类)")
public class User {

    @ApiModelProperty("4、属性-用户名")
    public String username;

    @ApiModelProperty("4、属性-密码")
    public String password;

}
```

3. 测试

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310143344086.png" alt="image-20220310143344086" style="zoom:50%;" />

* 在模块类中

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310143422890.png" alt="image-20220310143422890" style="zoom:50%;" />

* 在实体类模型中

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310143503455.png" alt="image-20220310143503455" style="zoom:50%;" />



> 拓展：皮肤

1. 默认的  **访问 http://localhost:8080/swagger-ui.html**

```xml
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>2.9.2</version>
</dependency>
```

![image-20220310143850263](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310143850263.png)

2. bootstrap-ui  **访问 http://localhost:8080/doc.html**

```xml
<!-- 引入swagger-bootstrap-ui包 /doc.html-->
<dependency>
   <groupId>com.github.xiaoymin</groupId>
   <artifactId>swagger-bootstrap-ui</artifactId>
   <version>1.9.1</version>
</dependency>
```

![image-20220310143917288](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310143917288.png)

3. Layui-ui  **访问 http://localhost:8080/docs.html**

```xml
<!-- 引入swagger-ui-layer包 /docs.html-->
<dependency>
   <groupId>com.github.caspar-chen</groupId>
   <artifactId>swagger-ui-layer</artifactId>
   <version>1.1.3</version>
</dependency>
```

![image-20220310143943192](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310143943192.png)

4. mg-ui  **访问 http://localhost:8080/document.html**

```xml
<!-- 引入swagger-ui-layer包 /document.html-->
<dependency>
   <groupId>com.zyplayer</groupId>
   <artifactId>swagger-mg-ui</artifactId>
   <version>1.0.6</version>
</dependency>
```

![image-20220310144005581](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220310144005581.png)



> 总结

1. 我们可以通过Swagger给一些比较难理解的属性或者接口，增加注释信息

2. 接口文档要实时更新
3. 可以在线测试

Swagger是一个优秀的工具，几乎所有大公司都有使用它！

【注意点】在正式发布的时候，关闭Swagger！！！处于安全考虑，也同时节省运行内存！！！
