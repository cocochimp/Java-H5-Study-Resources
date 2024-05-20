# SpringBoot学习资源

注：

springboot_03_webproject在[08_SpringBoot_sms](https://gitee.com/cocochimp/springboot_sms)中

springboot_08_swagger在[09_Swagger](https://gitee.com/cocochimp/swagger)中

> Java全栈工程师：

* 后台开发：主打；
* 前端：html、css、js、JQuery；
* 运维：项目发布：服务器如何运行一个项目？Linux；

![image-20220301213821437](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220301213821437.png)

> 心得：

* 如果程序=数据结构+算法，则为程序猿
* 如果程序=面向对象+算法，则为码农

你会成为哪种人，取决于你如何学习！



## 1. SpringBoot简介

### 1.1 回顾什么是Spring 

> 概述

Spring是一个开源框架，2003 年兴起的一个轻量级的Java 开发框架，作者：Rod Johnson  。

**Spring是为了解决企业级应用开发的复杂性而创建的，简化开发。**



### 1.2 Spring是如何简化Java开发的

> 为了降低Java开发的复杂性，Spring采用了以下4种关键策略：

1、基于POJO的轻量级和最小侵入性编程，所有东西都是bean；

2、通过IOC，依赖注入（DI）和面向接口实现松耦合；

3、基于切面（AOP）和惯例进行声明式编程；

4、通过切面和模版减少样式代码，RedisTemplate，xxxTemplate；



### 1.3 什么是SpringBoot

> 概述

学过javaweb的同学就知道，开发一个web应用，从最初开始接触Servlet结合Tomcat, 跑出一个Hello Wolrld程序，是要经历特别多的步骤；后来就用了框架Struts，再后来是SpringMVC，到了现在的SpringBoot，过一两年又会有其他web框架出现；你们有经历过框架不断的演进，然后自己开发项目所有的技术也在不断的变化、改造吗？建议都可以去经历一遍；

言归正传，什么是SpringBoot呢，就是一个javaweb的开发框架，和SpringMVC类似，对比其他javaweb框架的好处，官方说是简化开发，约定大于配置，  you can "just run"，能迅速的开发web应用，几行代码开发一个http接口。

所有的技术框架的发展似乎都遵循了一条主线规律：从一个复杂应用场景 衍生 一种规范框架，人们只需要进行各种配置而不需要自己去实现它，这时候强大的配置功能成了优点；发展到一定程度之后，人们根据实际生产应用情况，选取其中实用功能和设计精华，重构出一些轻量级的框架；之后为了提高开发效率，嫌弃原先的各类配置过于麻烦，于是开始提倡“约定大于配置”，进而衍生出一些一站式的解决方案。

是的这就是Java企业级应用->J2EE->spring->springboot的过程。

随着 Spring 不断的发展，涉及的领域越来越多，项目整合开发需要配合各种各样的文件，慢慢变得不那么易用简单，违背了最初的理念，甚至人称配置地狱。Spring Boot 正是在这样的一个背景下被抽象出来的开发框架，目的为了让大家更容易的使用 Spring 、更容易的集成各种常用的中间件、开源软件；

Spring Boot 基于 Spring 开发，Spirng Boot 本身并不提供 Spring 框架的核心特性以及扩展功能，只是用于快速、敏捷地开发新一代基于 Spring 框架的应用程序。也就是说，它并不是用来替代 Spring 的解决方案，而是和 Spring 框架紧密结合用于提升 Spring 开发者体验的工具。Spring Boot 以**约定大于配置的核心思想**，默认帮我们进行了很多设置，多数 Spring Boot 应用只需要很少的 Spring 配置。同时它集成了大量常用的第三方库配置（例如 Redis、MongoDB、Jpa、RabbitMQ、Quartz 等等），Spring Boot 应用中这些第三方库几乎可以零配置的开箱即用。

简单来说就是SpringBoot其实不是什么新的框架，它默认配置了很多框架的使用方式，就像maven整合了所有的jar包，spring boot整合了所有的框架 。

Spring Boot 出生名门，从一开始就站在一个比较高的起点，又经过这几年的发展，生态足够完善，Spring Boot 已经当之无愧成为 Java 领域最热门的技术。

> **Spring Boot的主要优点：**

- 为所有Spring开发者更快的入门
- **开箱即用**，提供各种默认配置来简化项目配置
- 内嵌式容器简化Web项目
- 没有冗余代码生成和XML配置的要求

真的很爽，我们快速去体验开发个接口的感觉吧！



## 2. 第一个程序

> 准备工作

我们将学习如何快速的创建一个Spring Boot应用，并且实现一个简单的Http请求处理。通过这个例子对Spring Boot有一个初步的了解，并体验其结构简单、开发快速的特性。



### 2.1 项目创建方式(-)

> **1、项目创建方式一**：使用Spring Initializr 的 Web页面创建项目

Spring Initializr：https://start.spring.io/

1、打开  https://start.spring.io/

2、填写项目信息

3、点击”Generate Project“按钮生成项目；下载此项目

4、解压项目包，并用IDEA以Maven项目导入，一路下一步即可，直到项目导入完毕。

5、如果是第一次使用，可能速度会比较慢，包比较多、需要耐心等待一切就绪。

![image-20220302103317481](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220302103317481.png)



> **2、项目创建方式二：**使用 IDEA 直接创建项目

1、创建一个新项目

2、选择spring initalizr ， 可以看到默认就是去官网的快速构建工具那里实现

3、填写项目信息

4、选择初始化的组件（初学勾选 Web 即可）

5、填写项目路径

6、等待项目构建成功



> **3、项目结构分析：**

通过上面步骤完成了基础项目的创建。就会自动生成以下文件。

1、程序的主启动类

2、一个 application.properties 配置文件

3、一个 测试类

4、一个 pom.xml



### 2.2 项目创建详解(*)

> 1、项目创建过程

1. 选择Spring Initializr

![image-20220302153444197](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220302153444197.png)

2. 创建项目详细信息

![image-20220302153808283](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220302153808283.png)

3. 选择web支持

![image-20220302153854102](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220302153854102.png)

* 此处没选web支持

4. 删除多余文件

![image-20220302154052439](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220302154052439.png)

5. 在pom.xml中配置

```xml
<!--web支持-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

* 用来支持web



> 2、更改项目的端口号

* 在application.properties

```properties
# 更改项目的端口号
server.port=8081
```



### 2.3 项目编写

> 1、编写流程

1、在主程序的同级目录下，新建一个controller包，一定要在同级目录下，否则识别不到

2、在包中新建一个HelloController类

```java
package com.koko.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
```

3、编写完毕后，从主程序启动项目，浏览器发起请求，看页面返回；控制台输出了 Tomcat 访问的端口号！

![image-20220302111816495](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220302111816495.png)

简单几步，就完成了一个web接口的开发，SpringBoot就是这么简单。所以我们常用它来建立我们的微服务项目！



> 2、打包发布

* 将项目打成jar包，点击 maven的 package

![图片](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/11_SpringBoot/640)

注：如果遇到以上错误，可以配置打包时 跳过项目运行测试用例

~~~xml
<!--
    在工作中,很多情况下我们打包是不想执行测试用例的
    可能是测试用例不完事,或是测试用例会影响数据库数据
    跳过测试用例执
    -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <configuration>
        <!--跳过项目运行测试用例-->
        <skipTests>true</skipTests>
    </configuration>
</plugin>
~~~

* 如果打包成功，则会在target目录下生成一个 jar 包

![image-20220302125243168](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220302125243168.png)

打成了jar包后，就可以在任何地方运行了！OK

* jar包运行

![image-20220303214852888](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220303214852888.png)

~~~properties
java -jar xxx.jar
~~~



> 3、彩蛋

如何更改启动时显示的字符拼成的字母，SpringBoot呢？也就是 banner 图案；

只需一步：到项目下的 resources 目录下新建一个banner.txt 即可。

图案可以到：https://www.bootschool.net/ascii 这个网站生成，然后拷贝到文件中即可！

![image-20220302125732171](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220302125732171.png)

**SpringBoot这么简单的东西背后一定有故事，我们之后去进行一波源码分析！**



### 2.4 运行原理初探

#### 2.4.1 pom.xml

> 1、父依赖

其中它主要是依赖一个父项目，主要是管理项目的资源过滤及插件！

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.6.4</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

点进去，发现还有一个父依赖

~~~xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.6.4.RELEASE</version>
    <relativePath>../../spring-boot-dependencies</relativePath>
</parent>
~~~

这里才是真正管理SpringBoot应用里面所有依赖版本的地方，SpringBoot的版本控制中心；

**以后我们导入依赖默认是不需要写版本；但是如果导入的包没有在依赖中管理着就需要手动配置版本了；**



> 2、启动器 spring-boot-starter

~~~xml
<dependency>    <groupId>org.springframework.boot</groupId>    <artifactId>spring-boot-starter-web</artifactId></dependency>
~~~

**springboot-boot-starter-xxx**：就是spring-boot的场景启动器

**spring-boot-starter-web**：帮我们导入了web模块正常运行所依赖的组件；

SpringBoot将所有的功能场景都抽取出来，做成一个个的starter （启动器），只需要在项目中引入这些starter即可，所有相关的依赖都会导入进来 ， 我们要用什么功能就导入什么样的场景启动器即可 ；我们未来也可以自己自定义 starter；



#### 2.4.2 主启动类

> 1、默认的主启动类

~~~java
//@SpringBootApplication 来标注一个主程序类
//说明这是一个Spring Boot应用
@SpringBootApplication
public class SpringbootApplication {

   public static void main(String[] args) {
     //以为是启动了一个方法，没想到启动了一个服务
      SpringApplication.run(SpringbootApplication.class, args);
   }

}
~~~

但是**一个简单的启动类并不简单！**我们来分析一下这些注解都干了什么



> **2、注解**

> **1、@SpringBootApplication**

**1、@SpringBootApplication**

作用：标注在某个类上说明这个类是SpringBoot的主配置类 ， SpringBoot就应该运行这个类的main方法来启动SpringBoot应用；

进入这个注解：可以看到上面还有很多其他注解！

~~~java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
    // ......
}
~~~

**2、@ComponentScan**

这个注解在Spring中很重要 ,它对应XML配置中的元素。

作用：自动扫描并加载符合条件的组件或者bean ， 将这个bean定义加载到IOC容器中

**3、@SpringBootConfiguration**

作用：SpringBoot的配置类 ，标注在某个类上 ， 表示这是一个SpringBoot的配置类；

我们继续进去这个注解查看

~~~java
// 点进去得到下面的 @Component
@Configuration
public @interface SpringBootConfiguration {}

@Component
public @interface Configuration {}
~~~

这里的 @Configuration，说明这是一个配置类 ，配置类就是对应Spring的xml 配置文件；

里面的 @Component 这就说明，启动类本身也是Spring中的一个组件而已，负责启动应用！

我们回到 SpringBootApplication 注解中继续看。

> **2、@EnableAutoConfiguration**

**1、@EnableAutoConfiguration ：开启自动配置功能**

以前我们需要自己配置的东西，而现在SpringBoot可以自动帮我们配置 ；@EnableAutoConfiguration告诉SpringBoot开启自动配置功能，这样自动配置才能生效；

点进注解接续查看：

**2、@AutoConfigurationPackage ：自动配置包**

~~~java
@Import({Registrar.class})
public @interface AutoConfigurationPackage {
}
~~~

**3、@import** ：Spring底层注解@import ， 给容器中导入一个组件

Registrar.class 作用：将主启动类的所在包及包下面所有子包里面的所有组件扫描到Spring容器 ；

这个分析完了，退到上一步，继续看

**4、@Import({AutoConfigurationImportSelector.class}) ：给容器导入组件 ；**

AutoConfigurationImportSelector ：自动配置导入选择器，那么它会导入哪些组件的选择器呢？我们点击去这个类看源码：

1、这个类中有一个这样的方法

~~~java
// 获得候选的配置
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
    //这里的getSpringFactoriesLoaderFactoryClass（）方法
    //返回的就是我们最开始看的启动自动导入配置文件的注解类；EnableAutoConfiguration
    List<String> configurations = SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
    Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
    return configurations;
}
~~~

2、这个方法又调用了  SpringFactoriesLoader 类的静态方法！我们进入SpringFactoriesLoader类loadFactoryNames() 方法

~~~java
public static List<String> loadFactoryNames(Class<?> factoryClass, @Nullable ClassLoader classLoader) {
    String factoryClassName = factoryClass.getName();
    //这里它又调用了 loadSpringFactories 方法
    return (List)loadSpringFactories(classLoader).getOrDefault(factoryClassName, Collections.emptyList());
}
~~~

3、我们继续点击查看 loadSpringFactories 方法

~~~java
private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
    //获得classLoader ， 我们返回可以看到这里得到的就是EnableAutoConfiguration标注的类本身
    MultiValueMap<String, String> result = (MultiValueMap)cache.get(classLoader);
    if (result != null) {
        return result;
    } else {
        try {
            //去获取一个资源 "META-INF/spring.factories"
            Enumeration<URL> urls = classLoader != null ? classLoader.getResources("META-INF/spring.factories") : ClassLoader.getSystemResources("META-INF/spring.factories");
            LinkedMultiValueMap result = new LinkedMultiValueMap();

            //将读取到的资源遍历，封装成为一个Properties
            while(urls.hasMoreElements()) {
                URL url = (URL)urls.nextElement();
                UrlResource resource = new UrlResource(url);
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                Iterator var6 = properties.entrySet().iterator();

                while(var6.hasNext()) {
                    Entry<?, ?> entry = (Entry)var6.next();
                    String factoryClassName = ((String)entry.getKey()).trim();
                    String[] var9 = StringUtils.commaDelimitedListToStringArray((String)entry.getValue());
                    int var10 = var9.length;

                    for(int var11 = 0; var11 < var10; ++var11) {
                        String factoryName = var9[var11];
                        result.add(factoryClassName, factoryName.trim());
                    }
                }
            }

            cache.put(classLoader, result);
            return result;
        } catch (IOException var13) {
            throw new IllegalArgumentException("Unable to load factories from location [META-INF/spring.factories]", var13);
        }
    }
}
~~~

4、发现一个多次出现的文件：spring.factories，全局搜索它



> **3、spring.factories**(*)

我们根据源头打开spring.factories ， 看到了很多自动配置的文件；这就是自动配置根源所在！

![image-20220304171510879](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304171510879.png)

**WebMvcAutoConfiguration**

我们在上面的自动配置类随便找一个打开看看，比如 ：WebMvcAutoConfiguration

![image-20220303224038096](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220303224038096.png)

可以看到这些一个个的都是JavaConfig配置类，而且都注入了一些Bean，可以找一些自己认识的类，看着熟悉一下！

所以，自动配置真正实现是从classpath中搜寻所有的META-INF/spring.factories配置文件 ，并将其中对应的 org.springframework.boot.autoconfigure. 包下的配置项，通过反射实例化为对应标注了 @Configuration的JavaConfig形式的IOC容器配置类 ， 然后将这些都汇总成为一个实例并加载到IOC容器中。



> **结论：**

1. SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值
2. 将这些值作为自动配置类导入容器 ， 自动配置类就生效 ， 帮我们进行自动配置工作；
3. 整个J2EE的整体解决方案和自动配置都在springboot-autoconfigure的jar包中；
4. 它会给容器中导入非常多的自动配置类 （xxxAutoConfiguration）, 就是给容器中导入这个场景需要的所有组件 ， 并配置好这些组件 ；
5. 有了自动配置类 ， 免去了我们手动编写配置注入功能组件等的工作；

**现在大家应该大概的了解了下，SpringBoot的运行原理，后面我们还会深化一次！**



#### 2.4.3 SpringApplication

> 1、不简单的方法

我最初以为就是运行了一个main方法，没想到却开启了一个服务；

~~~java
@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
~~~

**SpringApplication.run分析**

分析该方法主要分两部分，一部分是SpringApplication的实例化，二是run方法的执行；



> 2、SpringApplication

**这个类主要做了以下四件事情：**

1、推断应用的类型是普通的项目还是Web项目

2、查找并加载所有可用初始化器 ， 设置到initializers属性中

3、找出所有的应用程序监听器，设置到listeners属性中

4、推断并设置main方法的定义类，找到运行的主类

查看构造器：

~~~java
public SpringApplication(ResourceLoader resourceLoader, Class... primarySources) {
    // ......
    this.webApplicationType = WebApplicationType.deduceFromClasspath();
    this.setInitializers(this.getSpringFactoriesInstances();
    this.setListeners(this.getSpringFactoriesInstances(ApplicationListener.class));
    this.mainApplicationClass = this.deduceMainApplicationClass();
}
~~~



> 3、run方法流程分析

![640](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/640.jpg)



## 3. yaml语法学习

### 3.1 yaml概述

> 1、配置文件

SpringBoot使用一个全局的配置文件 ， 配置文件名称是固定的

- application.properties

- - 语法结构 ：key=value

- application.yml

- - 语法结构 ：key：空格 value

**配置文件的作用 ：**修改SpringBoot自动配置的默认值，因为SpringBoot在底层都给我们自动配置好了；

比如我们可以在配置文件中修改Tomcat 默认启动的端口号！测试一下！

~~~properties
server.port=8081
~~~



> 2、概述

YAML是 "YAML Ain't a Markup Language" （YAML不是一种标记语言）的递归缩写。在开发的这种语言时，YAML 的意思其实是："Yet Another Markup Language"（仍是一种标记语言）

**这种语言以数据****作****为中心，而不是以标记语言为重点！**

以前的配置文件，大多数都是使用xml来配置；比如一个简单的端口配置，我们来对比下yaml和xml

* 传统xml配置：

~~~xml
<server>
    <port>8081<port>
</server>
~~~

* yaml配置：

~~~yaml
server:
  prot: 8080
~~~



> 3、注释：

说明：语法要求严格！

1、空格不能省略

2、以缩进来控制层级关系，只要是左边对齐的一列数据都是同一个层级的。

3、属性和值的大小写都是十分敏感的。



### 3.2 yaml测试(*)

![image-20220304153837888](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304153837888.png)

> 1、Person类

```java
package com.koko.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component //注册bean到容器中
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
```

> 2、application.yaml

```yaml
person:
  name: qinjiang
  age: 3
  happy: false
  birth: 2000/01/01
  maps: {k1: v1,k2: v2}
  lists:
    - code
    - girl
    - music
  dog:
    name: 旺财
    age: 1
```

> 3、springboot配置注解处理器没有找到

![image-20220304154131307](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304154131307.png)

* 导入依赖

~~~xml
<!-- 导入配置文件处理器，配置文件进行绑定就会有提示，需要重启 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
  <optional>true</optional>
</dependency>
~~~

> 4、测试

~~~java
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Person person; //将person自动注入进来

    @Test
    public void contextLoads() {
        System.out.println(person); //打印person信息
    }
}
~~~

* 结果：所有值全部注入成功！

![image-20220304154250202](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304154250202.png)

**yaml配置注入到实体类完全OK！**



> 5、配置文件占位符

* 配置文件还可以编写占位符生成随机数

~~~yaml
person:
    name: qinjiang${random.uuid} # 随机uuid
    age: ${random.int}  # 随机int
    happy: false
    birth: 2000/01/01
    maps: {k1: v1,k2: v2}
    lists:
      - code
      - girl
      - music
    dog:
      name: ${person.hello:other}_旺财
      age: 1
~~~



### 3.3 回顾properties配置

我们上面采用的yaml方法都是最简单的方式，开发中最常用的；也是springboot所推荐的！那我们来唠唠其他的实现方式，道理都是相同的；写还是那样写；配置文件除了yml还有我们之前常用的properties ， 我们没有讲，我们来唠唠！

【注意】properties配置文件在写中文的时候，会有乱码 ， 我们需要去IDEA中设置编码格式为UTF-8；

settings-->FileEncodings 中配置；

![image-20220304154535660](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304154535660.png)



> 1、新建一个实体类User

~~~java
@Component //注册bean
public class User {
    private String name;
    private int age;
    private String sex;
}
~~~

> 2、编辑配置文件 user.properties

~~~properties
user1.name=kuangshen
user1.age=18
user1.sex=男
~~~

> 3、我们在User类上使用@Value来进行注入！

~~~java
@Component //注册bean
@PropertySource(value = "classpath:user.properties")
public class User {
    //直接使用@value
    @Value("${user.name}") //从配置文件中取值
    private String name;
    @Value("#{9*2}")  // #{SPEL} Spring表达式
    private int age;
    @Value("男")  // 字面量
    private String sex;
}
~~~

>4、Springboot测试

~~~java
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    User user;

    @Test
    public void contextLoads() {
        System.out.println(user);
    }

}
~~~

结果正常输出：

![image-20220304154735627](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304154735627.png)



> 5、对比小结

@Value这个使用起来并不友好！我们需要为每个属性单独注解赋值，比较麻烦；我们来看个功能对比图

![image-20220304154748684](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304154748684.png)

1、@ConfigurationProperties只需要写一次即可 ， @Value则需要每个字段都添加

2、松散绑定：这个什么意思呢? 比如我的yml中写的last-name，这个和lastName是一样的， - 后面跟着的字母默认是大写的。这就是松散绑定。可以测试一下

3、JSR303数据校验 ， 这个就是我们可以在字段是增加一层过滤器验证 ， 可以保证数据的合法性

4、复杂类型封装，yml中可以封装对象 ， 使用value就不支持

> **6、结论：**

配置yml和配置properties都可以获取到值 ， 强烈推荐 yml；

如果我们在某个业务中，只需要获取配置文件中的某个值，可以使用一下 @value；

如果说，我们专门编写了一个JavaBean来和配置文件进行一一映射，就直接@configurationProperties，不要犹豫！



## 4. JSR303数据校验及多环境切换

### 4.1 JSR303数据校验

> 1、如何使用

Springboot中可以用@validated来校验数据，如果数据异常则会统一抛出异常，方便异常中心统一处理。我们这里来写个注解让我们的name只能支持Email格式；

~~~java
@Component //注册bean
@ConfigurationProperties(prefix = "person")
@Validated  //数据校验
public class Person {

    @Email(message="邮箱格式错误") //name必须是邮箱格式
    private String name;
}
~~~

运行结果 ：default message [不是一个合法的电子邮件地址];

**使用数据校验，可以保证数据的正确性；** 

> 2、常见参数

~~~java
@NotNull(message="名字不能为空")
private String userName;
@Max(value=120,message="年龄最大不能查过120")
private int age;
@Email(message="邮箱格式错误")
private String email;

空检查
@Null       验证对象是否为null
@NotNull    验证对象是否不为null, 无法查检长度为0的字符串
@NotBlank   检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
@NotEmpty   检查约束元素是否为NULL或者是EMPTY.
    
Booelan检查
@AssertTrue     验证 Boolean 对象是否为 true  
@AssertFalse    验证 Boolean 对象是否为 false  
    
长度检查
@Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内  
@Length(min=, max=) string is between min and max included.

日期检查
@Past       验证 Date 和 Calendar 对象是否在当前时间之前  
@Future     验证 Date 和 Calendar 对象是否在当前时间之后  
@Pattern    验证 String 对象是否符合正则表达式的规则

.......等等
除此以外，我们还可以自定义一些数据校验规则
~~~

* 了解即可！



### 4.2 多环境切换(*)

profile是Spring对不同环境提供不同配置功能的支持，可以通过激活不同的环境版本，实现快速切换环境；

> 1、多配置文件(*)

我们在主配置文件编写的时候，文件名可以是 application-{profile}.properties/yml , 用来指定多个环境版本；

**例如：**

* application-test.properties 代表测试环境配置

* application-dev.properties 代表开发环境配置

但是Springboot并不会直接启动这些配置文件，它**默认使用application.properties主配置文件**；

我们需要通过一个配置来选择需要激活的环境：

~~~properties
#比如在配置文件中指定使用dev环境，我们可以通过设置不同的端口号进行测试；
#我们启动SpringBoot，就可以看到已经切换到dev下的配置了；
spring.profiles.active=dev
~~~



> 2、yaml的多文档块(*)

和properties配置文件中一样，但是使用yml去实现不需要创建多个配置文件，更加方便了 !

~~~yaml
server:
  port: 8081
#选择要激活那个环境块
spring:
  profiles:
    active: prod

---
server:
  port: 8083
spring:
  profiles: dev #配置环境的名称


---

server:
  port: 8084
spring:
  profiles: prod  #配置环境的名称
~~~

![image-20220304163111682](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304163111682.png)

**注意：如果yml和properties同时都配置了端口，并且没有激活其他环境 ， 默认会使用properties配置文件的！**



> 3、配置文件加载位置

**外部加载配置文件的方式十分多，我们选择最常用的即可，在开发的资源文件中进行配置！**

* 四种配置文件位置及运行优先级

![image-20220304162647931](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304162647931.png)

pringboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件：

~~~pro
优先级1：项目路径下的config文件夹配置文件
优先级2：项目路径下配置文件
优先级3：资源路径下的config文件夹配置文件
优先级4：资源路径下配置文件
~~~

优先级由高到底，高优先级的配置会覆盖低优先级的配置；

**SpringBoot会从这四个位置全部加载主配置文件；互补配置；**

我们在最低级的配置文件中设置一个项目访问路径的配置来测试互补问题；

~~~properties
#配置项目的访问路径
server.servlet.context-path=/kuang
~~~



> 4、拓展，运维小技巧

指定位置加载配置文件

我们还可以通过spring.config.location来改变默认的配置文件位置

项目打包好以后，我们可以使用命令行参数的形式，启动项目的时候来指定配置文件的新位置；这种情况，一般是后期运维做的多，相同配置，外部指定的配置文件优先级最高

~~~prop
java -jar spring-boot-config.jar --spring.config.location=F:/application.properties
~~~



## 5. 自动装配原理

### 5.1 自动装配原理详解

> 1、概述

**根据当前不同的条件判断，决定这个配置类是否生效！**

- 一但这个配置类生效；这个配置类就会给容器中添加各种组件；
- 这些组件的属性是从对应的properties类中获取的，这些类里面的每一个属性又是和配置文件绑定的；
- 所有在配置文件中能配置的属性都是在xxxxProperties类中封装着；
- 配置文件能配置什么就可以参照某个功能对应的这个属性类

~~~java
@ConfigurationProperties(
    prefix = "server",
    ignoreUnknownFields = true
)
public class ServerProperties {
    ...
}
~~~

![image-20220304171818749](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304171818749.png)

![image-20220304171922895](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304171922895.png)

* **这就是自动装配的原理！**



> 2、精髓

1、SpringBoot启动会加载大量的自动配置类

2、我们看我们需要的功能有没有在SpringBoot默认写好的自动配置类当中；

3、我们再来看这个自动配置类中到底配置了哪些组件；（只要我们要用的组件存在在其中，我们就不需要再手动配置了）

4、给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们只需要在配置文件中指定这些属性的值即可；

* **xxxxAutoConfigurartion：自动配置类；**给容器中添加组件

* **xxxxProperties:封装配置文件中相关属性；**



### 5.2 @Conditional(-)

了解完自动装配的原理后，我们来关注一个细节问题，**自动配置类必须在一定的条件下才能生效；**

**@Conditional派生注解（Spring注解版原生的@Conditional作用）**

作用：必须是@Conditional指定的条件成立，才给容器中添加组件，配置配里面的所有内容才生效；

![image-20220304172107032](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220304172107032.png)

**那么多的自动配置类，必须在一定的条件下才能生效；也就是说，我们加载了这么多的配置类，但不是所有的都生效了。**

我们怎么知道哪些自动配置类生效？

**我们可以通过启用 debug=true属性；来让控制台打印自动配置报告，这样我们就可以很方便的知道哪些自动配置类生效；**

> 1、application.yaml

```properties
#开启springboot的调试类
debug=true
```

**Positive matches:（自动配置类启用的：正匹配）**

**Negative matches:（没有启动，没有匹配成功的自动配置类：负匹配）**

**Unconditional classes: （没有条件的类）**

【演示：查看输出的日志】

掌握吸收理解原理，即可以不变应万变！



## 6. SpringBoot Web开发

### 6.1 Web开发静态资源处理

> 1、web开发要解决的问题

* 导入静态资源
* 首页
* jsp，模板引擎Thymeleaf
* 装配拓展SpringMVC
* 增删改查
* 拦截器
* 国际化



> 2、静态资源映射规则

**首先，我们搭建一个普通的SpringBoot项目，回顾一下HelloWorld程序！**

写请求非常简单，那我们要引入我们前端资源，我们项目中有许多的静态资源，比如css，js等文件，这个SpringBoot怎么处理呢？

如果我们是一个web应用，我们的main下会有一个webapp，我们以前都是将所有的页面导在这里面的，对吧！但是我们现在的pom呢，打包方式是为jar的方式，那么这种方式SpringBoot能不能来给我们写页面呢？当然是可以的，但是SpringBoot对于静态资源放置的位置，是有规定的！

**我们先来聊聊这个静态资源映射规则：**

SpringBoot中，SpringMVC的web配置都在 WebMvcAutoConfiguration 这个配置类里面；

我们可以去看看 WebMvcAutoConfigurationAdapter 中有很多配置方法；

有一个方法：addResourceHandlers 添加资源处理

~~~java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!this.resourceProperties.isAddMappings()) {
        // 已禁用默认资源处理
        logger.debug("Default resource handling disabled");
        return;
    }
    // 缓存控制
    Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
    CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
    // webjars 配置
    if (!registry.hasMappingForPattern("/webjars/**")) {
        customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
                                             .addResourceLocations("classpath:/META-INF/resources/webjars/")
                                             .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
    }
    // 静态资源配置
    String staticPathPattern = this.mvcProperties.getStaticPathPattern();
    if (!registry.hasMappingForPattern(staticPathPattern)) {
        customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
                                             .addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
                                             .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
    }
}
~~~

读一下源代码：比如所有的 /webjars/** ， 都需要去 classpath:/META-INF/resources/webjars/ 找对应的资源；



> 3、什么是webjars？

Webjars本质就是以jar包的方式引入我们的静态资源 ， 我们以前要导入一个静态资源文件，直接导入即可。

使用SpringBoot需要使用Webjars，我们可以去搜索一下：

网站：https://www.webjars.org 

要使用jQuery，我们只要要引入jQuery对应版本的pom依赖即可！

~~~xml
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>3.4.1</version>
</dependency>
~~~

* 导入完毕，查看webjars目录结构，并访问Jquery.js文件！

![image-20220305092535179](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305092535179.png)

访问：只要是静态资源，SpringBoot就会去对应的路径寻找资源，我们这里访问：http://localhost:8080/webjars/jquery/3.4.1/jquery.js

![image-20220305092650355](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305092650355.png)



>4、第二种静态资源映射规律

1. 在springboot，我们可以使用一下方式处理静态数据
   * webjars  `localhost:8080/webjars/`
   * public,static,/**,resources `localhost:8080/`

2. 优先级：resources>static(默认)>public 



> 5、自定义静态资源路径

我们也可以自己通过配置文件来指定一下，哪些文件夹是需要我们放静态资源文件的，在application.properties中配置；

~~~properties
spring.resources.static-locations=classpath:/coding/,classpath:/koko/
~~~

一旦自己定义了静态文件夹的路径，原来的自动配置就都会失效了！



> 6、拓展：网站图标说明(-)

与其他静态资源一样，Spring Boot在配置的静态内容位置中查找 favicon.ico。如果存在这样的文件，它将自动用作应用程序的favicon。

1、关闭SpringBoot默认图标

~~~properties
#关闭默认图标
spring.mvc.favicon.enabled=false
~~~

2、自己放一个图标在静态资源目录下，我放在 public 目录下

3、清除浏览器缓存！刷新网页，发现图标已经变成自己的了！

注：maven中的spring-boot-starter-parent的版本要低才行，已经被淘汰（了解即可）



### 6.2 Thymeleaf

> 1、模板引擎介绍

前端交给我们的页面，是html页面。如果是我们以前开发，我们需要把他们转成jsp页面，jsp好处就是当我们查出一些数据转发到JSP页面以后，我们可以用jsp轻松实现数据的显示，及交互等。

jsp支持非常强大的功能，包括能写Java代码，但是呢，我们现在的这种情况，SpringBoot这个项目首先是以jar的方式，不是war，像第二，我们用的还是嵌入式的Tomcat，所以呢，**他现在默认是不支持jsp的**。

那不支持jsp，如果我们直接用纯静态页面的方式，那给我们开发会带来非常大的麻烦，那怎么办呢？

**SpringBoot推荐你可以来使用模板引擎：**

模板引擎，我们其实大家听到很多，其实jsp就是一个模板引擎，还有用的比较多的freemarker，包括SpringBoot给我们推荐的Thymeleaf，模板引擎有非常多，但再多的模板引擎，他们的思想都是一样的，什么样一个思想呢我们来看一下这张图：

![image-20220305094354752](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305094354752.png)

模板引擎的作用就是我们来写一个页面模板，比如有些值呢，是动态的，我们写一些表达式。而这些值，从哪来呢，就是我们在后台封装一些数据。然后把这个模板和这个数据交给我们模板引擎，模板引擎按照我们这个数据帮你把这表达式解析、填充到我们指定的位置，然后把这个数据最终生成一个我们想要的内容给我们写出去，这就是我们这个模板引擎，不管是jsp还是其他模板引擎，都是这个思想。只不过呢，就是说不同模板引擎之间，他们可能这个语法有点不一样。其他的我就不介绍了，我主要来介绍一下SpringBoot给我们推荐的Thymeleaf模板引擎，这模板引擎呢，是一个高级语言的模板引擎，他的这个语法更简单。而且呢，功能更强大。

我们呢，就来看一下这个模板引擎，那既然要看这个模板引擎。首先，我们来看SpringBoot里边怎么用。



> 2、引入Thymeleaf

怎么引入呢，对于springboot来说，什么事情不都是一个start的事情嘛，我们去在项目中引入一下。给大家三个网址：

Thymeleaf 官网：https://www.thymeleaf.org/

Thymeleaf 在Github 的主页：https://github.com/thymeleaf/thymeleaf

Spring官方文档：找到我们对应的版本

https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#using-boot-starter 

找到对应的pom依赖：可以适当点进源码看下本来的包！

~~~xml
<!--thymeleaf-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
~~~

Maven会自动下载jar包，我们可以去看下下载的东西；

![image-20220305094518743](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305094518743.png)



> 3、测试

1、编写一个indexController

```java
package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/h1")
    public String test01(Model model){
        //存数据
        model.addAttribute("msg","Hello,Thymeleaf");
        //classpath:/templates/index.html
        return "index";
    }

}
```

2、编写一个测试页面  index.html 放在 templates 目录下

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>koko</title>
</head>
<body>
<h1>测试页面</h1>

<!--th:text就是将div中的内容设置为它指定的值，和之前学习的Vue一样-->
<div th:text="${msg}"></div>

</body>
</html>
```

3、启动项目请求测试

![image-20220305094732925](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305094732925.png)



> **4、Thymeleaf的使用语法**

**1、我们可以使用任意的 th:attr 来替换Html中原生属性的值！**

![image-20220305094921146](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305094921146.png)

**2、我们能写哪些表达式呢？**

~~~properties
Simple expressions:（表达式语法）
Variable Expressions: ${...}：获取变量值；OGNL；
    1）、获取对象的属性、调用方法
    2）、使用内置的基本对象：#18
         #ctx : the context object.
         #vars: the context variables.
         #locale : the context locale.
         #request : (only in Web Contexts) the HttpServletRequest object.
         #response : (only in Web Contexts) the HttpServletResponse object.
         #session : (only in Web Contexts) the HttpSession object.
         #servletContext : (only in Web Contexts) the ServletContext object.

    3）、内置的一些工具对象：
　　　　　　#execInfo : information about the template being processed.
　　　　　　#uris : methods for escaping parts of URLs/URIs
　　　　　　#conversions : methods for executing the configured conversion service (if any).
　　　　　　#dates : methods for java.util.Date objects: formatting, component extraction, etc.
　　　　　　#calendars : analogous to #dates , but for java.util.Calendar objects.
　　　　　　#numbers : methods for formatting numeric objects.
　　　　　　#strings : methods for String objects: contains, startsWith, prepending/appending, etc.
　　　　　　#objects : methods for objects in general.
　　　　　　#bools : methods for boolean evaluation.
　　　　　　#arrays : methods for arrays.
　　　　　　#lists : methods for lists.
　　　　　　#sets : methods for sets.
　　　　　　#maps : methods for maps.
　　　　　　#aggregates : methods for creating aggregates on arrays or collections.
==================================================================================

  Selection Variable Expressions: *{...}：选择表达式：和${}在功能上是一样；
  Message Expressions: #{...}：获取国际化内容
  Link URL Expressions: @{...}：定义URL；
  Fragment Expressions: ~{...}：片段引用表达式

Literals（字面量）
      Text literals: 'one text' , 'Another one!' ,…
      Number literals: 0 , 34 , 3.0 , 12.3 ,…
      Boolean literals: true , false
      Null literal: null
      Literal tokens: one , sometext , main ,…
      
Text operations:（文本操作）
    String concatenation: +
    Literal substitutions: |The name is ${name}|
    
Arithmetic operations:（数学运算）
    Binary operators: + , - , * , / , %
    Minus sign (unary operator): -
    
Boolean operations:（布尔运算）
    Binary operators: and , or
    Boolean negation (unary operator): ! , not
    
Comparisons and equality:（比较运算）
    Comparators: > , < , >= , <= ( gt , lt , ge , le )
    Equality operators: == , != ( eq , ne )
    
Conditional operators:条件运算（三元运算符）
    If-then: (if) ? (then)
    If-then-else: (if) ? (then) : (else)
    Default: (value) ?: (defaultvalue)
    
Special tokens:
    No-Operation: _
~~~



> 5、练习测试：

1、 indexController

```java
@RequestMapping("/t2")
public String test2(Map<String,Object> map){
    //存入数据
    map.put("msg","<h1>Hello</h1>");
    map.put("users", Arrays.asList("koko01","koko02"));
    //classpath:/templates/test.html
    return "index";
}
```

2、index.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>koko</title>
</head>
<body>
<h1>测试页面</h1>

<div th:text="${msg}"></div>
<!--不转义-->
<div th:utext="${msg}"></div>

<!--遍历数据-->
<!--th:each每次遍历都会生成当前这个标签：官网#9-->
<h4 th:each="user :${users}" th:text="${user}"></h4>

<h4>
    <!--行内写法：官网#12-->
    <span th:each="user:${users}">[[${user}]]</span>
</h4>

</body>
</html>
```

3、启动项目测试！

![image-20220305095352725](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305095352725.png)

**我们看完语法，很多样式，我们即使现在学习了，也会忘记，所以我们在学习过程中，需要使用什么，根据官方文档来查询，才是最重要的，要熟练使用官方文档！**



### 6.3 MVC自动配置原理

> 1、学习网站

[狂神说SpringBoot12：MVC自动配置原理 (qq.com)](https://mp.weixin.qq.com/s?__biz=Mzg2NTAzMTExNg%3D%3D&chksm=ce610708f9168e1ee95b9f6135574cbea2d2b90ac3d0f7b6766d5260be0d711bbb73e678c6b5&idx=1&mid=2247483819&scene=21&sn=b9009aaa2a9af9d681a131b3a49d8848#wechat_redirect)

在springboot中，有非常多的xxxx Configuration 帮助我们进行扩展配置，只要看到了这个定性，我们就要注意了！

* 暂时看不懂，到时候回头来看



### 6.4 开发网站心得

> 1、如何写一个网站

1. 前端搞定：页面长什么样：数据
2. 设计数据库（数据库设计难点！）
3. 前端让他能够自动运行，独立化工程
4. 数据接口如何对接：json，对象 all in one！
5. 前后端联调测试！

> 2、小心得

1. 有一套自己熟悉的后台模板：工作必要！——>x-admin
2. 前端界面：至少自己能够通过前端框架，组合出来一个网站页面
   	- index
     		- about
     		- blog
     		- post
     		- user
3. 让这个页面能够独立运行！

> 3、后面的学习内容

* 整合JDBC
* **整合Mybatis**
* **整合Druid**
* **Shiro：安全**
* **Spring Security：安全**
* 异步任务~，邮件发送，定时任务
* Swagger
* Dubbo + Zookeeper



## 7. SpingBoot整合

### 7.1 整合JDBC

> 1、SpringData简介

对于数据访问层，无论是 SQL(关系型数据库) 还是 NOSQL(非关系型数据库)，Spring Boot 底层都是采用 Spring Data 的方式进行统一处理。

Spring Boot 底层都是采用 Spring Data 的方式进行统一处理各种数据库，Spring Data 也是 Spring 中与 Spring Boot、Spring Cloud 等齐名的知名项目。

Sping Data 官网：https://spring.io/projects/spring-data

数据库相关的启动器 ：可以参考官方文档：

https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#using-boot-starter

> 2、测试

1. 创建项目：springboot_04_jdbc

![image-20220307103108945](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307103108945.png)

2. 项目建好之后，发现自动帮我们导入了如下的启动器：

~~~xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
~~~

3. application.yml配置文件连接数据库

![image-20220307105758420](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307105758420.png)

```yml
spring:
  datasource:
    username: root
    password: 123456
    #?serverTimezone=UTC解决时区的报错
    url: jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
```

4. 测试类测试

```java
package com.koko.springboot_04_jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04JdbcApplicationTests {

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);
        //关闭连接
        connection.close();
    }

}
```

![image-20220307103548468](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307103548468.png)

5. 小结

Spring Boot 2.2.5 默认使用HikariDataSource 数据源，而以前版本，如 Spring Boot 1.5 默认使用 org.apache.tomcat.jdbc.pool.DataSource 作为数据源

**HikariDataSource 号称 Java WEB 当前速度最快的数据源，相比于传统的 C3P0 、DBCP、Tomcat jdbc 等连接池更加优秀；**

**可以使用 spring.datasource.type 指定自定义的数据源类型，值为 要使用的连接池实现的完全限定名。**

关于数据源我们并不做介绍，有了数据库连接，显然就可以 CRUD 操作数据库了。但是我们需要先了解一个对象 JdbcTemplate

> 3、JDBCTemplate

1、有了数据源(com.zaxxer.hikari.HikariDataSource)，然后可以拿到数据库连接(java.sql.Connection)，有了连接，就可以使用原生的 JDBC 语句来操作数据库；

2、即使不使用第三方第数据库操作框架，如 MyBatis等，Spring 本身也对原生的JDBC 做了轻量级的封装，即JdbcTemplate。

3、数据库操作的所有 CRUD 方法都在 JdbcTemplate 中。

4、Spring Boot 不仅提供了默认的数据源，同时默认已经配置好了 JdbcTemplate 放在了容器中，程序员只需自己注入即可使用

5、JdbcTemplate 的自动配置是依赖 org.springframework.boot.autoconfigure.jdbc 包下的 JdbcTemplateConfiguration 类

**JdbcTemplate主要提供以下几类方法：**

- execute方法：可以用于执行任何SQL语句，一般用于执行DDL语句；
- update方法及batchUpdate方法：update方法用于执行新增、修改、删除等语句；batchUpdate方法用于执行批处理相关语句；
- query方法及queryForXXX方法：用于执行查询相关语句；
- call方法：用于执行存储过程、函数相关语句。

> 4、测试

1. JdbcController类

![image-20220307110053917](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307110053917.png)

```java
package com.koko.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String, Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //新增一个用户
    @GetMapping("/add")
    public String addUser(){
        //插入语句，注意时间问题
        String sql = "insert into user(id, name,pwd)" +
                " values (4,'赵六','123')";
        jdbcTemplate.update(sql);

        //查询
        return "add_ok";
    }

    //修改用户信息
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        //插入语句，注意时间问题
        String sql = "update user set name=?,pwd=? where id="+id;

        //封装
        Object[] objects = new Object[2];
        objects[0]="小明";
        objects[1]="123456";
        jdbcTemplate.update(sql,objects);

        //查询
        return "update_ok";
    }

    //删除用户
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        //插入语句，注意时间问题
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);

        //查询
        return "delete_ok";
    }

}
```

* 进行测试即可完成CURD的基本操作！



### 7.2 整合Druid

> 1、Druid简介

Java程序很大一部分要操作数据库，为了提高性能操作数据库的时候，又不得不使用数据库连接池。

Druid 是阿里巴巴开源平台上一个数据库连接池实现，结合了 C3P0、DBCP 等 DB 池的优点，同时加入了日志监控。

Druid 可以很好的监控 DB 池连接和 SQL 的执行情况，天生就是针对监控而生的 DB 连接池。

Druid已经在阿里巴巴部署了超过600个应用，经过一年多生产环境大规模部署的严苛考验。

Spring Boot 2.0 以上默认使用 Hikari 数据源，可以说 Hikari 与 Driud 都是当前 Java Web 上最优秀的数据源，我们来重点介绍 Spring Boot 如何集成 Druid 数据源，如何实现数据库监控。

Github地址：https://github.com/alibaba/druid/

**com.alibaba.druid.pool.DruidDataSource 基本配置参数如下：**

![image-20220307114416400](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307114416400.png)

![image-20220307114427303](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307114427303.png)

![image-20220307114437419](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307114437419.png)

> 2、配置数据源

1. 添加上 Druid 数据源依赖

```xml
<!--druid-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.8</version>
</dependency>
```

2. application.yml

~~~yml
spring:
  datasource:
    username: root
    password: 123456
    #?serverTimezone=UTC解决时区的报错
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource # 自定义数据源

	#拓展功能
    #Spring Boot 默认是不注入这些属性值的，需要自己绑定
    #druid 数据源专有配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

	#特定功能
    #配置监控统计拦截的filters，stat:监控统计、log4j：日志记录、wall：防御sql注入
    #如果允许时报错  java.lang.ClassNotFoundException: org.apache.log4j.Priority
    #则导入 log4j 依赖即可，Maven 地址：https://mvnrepository.com/artifact/log4j/log4j
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
~~~

3. 导入Log4j 的依赖

```xml
<!--log4j-->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

4. DruidConfig配置类

现在需要程序员自己为 DruidDataSource 绑定全局配置文件中的参数，再添加到容器中，而不再使用 Spring Boot 的自动生成了；我们需要 自己添加 DruidDataSource 组件到容器中，并绑定属性；

```java
package com.koko.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    /*
       将自定义的 Druid数据源添加到容器中，不再让 Spring Boot 自动创建
       绑定全局配置文件中的 druid 数据源属性到 com.alibaba.druid.pool.DruidDataSource从而让它们生效
       @ConfigurationProperties(prefix = "spring.datasource")：作用就是将 全局配置文件中
       前缀为 spring.datasource的属性值注入到 com.alibaba.druid.pool.DruidDataSource 的同名参数中
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

}
```

5. 测试类

```java
package com.koko.springboot_04_jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04JdbcApplicationTests {

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());

        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }

}
```

![image-20220307113339964](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307113339964.png)

>3、配置Druid数据源监控

Druid 数据源具有监控的功能，并提供了一个 web 界面方便用户查看，类似安装 路由器 时，人家也提供了一个默认的 web 页面。

所以第一步需要设置 Druid 的后台管理页面，比如 登录账号、密码 等；配置后台管理；

1. Druidconfig

```java
//配置 Druid 监控管理后台的Servlet；
//内置 Servlet 容器时没有web.xml文件，所以使用 Spring Boot 的注册 Servlet 方式
@Bean
public ServletRegistrationBean statViewServlet() {
    ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

    // 这些参数可以在 com.alibaba.druid.support.http.StatViewServlet
    // 的父类 com.alibaba.druid.support.http.ResourceServlet 中找到
    Map<String, String> initParams = new HashMap<>();
    initParams.put("loginUsername", "admin"); //后台管理界面的登录账号
    initParams.put("loginPassword", "123456"); //后台管理界面的登录密码

    //后台允许谁可以访问
    //initParams.put("allow", "localhost")：表示只有本机可以访问
    //initParams.put("allow", "")：为空或者为null时，表示允许所有访问
    initParams.put("allow", "");
    //deny：Druid 后台拒绝谁访问
    //initParams.put("kuangshen", "192.168.1.20");表示禁止此ip访问

    //设置初始化参数
    bean.setInitParameters(initParams);
    return bean;
}
```

2. 测试

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307122434447.png" alt="image-20220307122434447" style="zoom:67%;" />

![image-20220307122413869](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307122413869.png)

> 4、配置 Druid web 监控 filter 过滤器

1. Druidconfig

```java
//配置 Druid 监控 之  web 监控的 filter
//WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
@Bean
public FilterRegistrationBean webStatFilter() {
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.setFilter(new WebStatFilter());

    //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
    Map<String, String> initParams = new HashMap<>();
    initParams.put("exclusions", "*.js,*.css,/druid/*,/jdbc/*");
    bean.setInitParameters(initParams);

    //"/*" 表示过滤所有请求
    bean.setUrlPatterns(Arrays.asList("/*"));
    return bean;
}
```

* 平时在工作中，按需求进行配置即可，主要用作监控！



### 7.3 整合Mybatis

> 1、简介

官方文档：http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

Maven仓库地址：https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter/2.1.1

> 2、测试

1. 导入 MyBatis 所需要的依赖

```xml
<!--mybatis整合依赖-->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.2</version>
</dependency>
```

2. application.yml

```yml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
mybatis:
  type-aliases-package: com.koko.pojo
  mapper-locations: classpath:mybatis/mapper/*.xml
```

* 连接上数据库

3. User实体类

```java
package com.koko.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String pwd;

}
```

4. UserMapper类

```java
package com.koko.mapper;

import com.koko.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper : 表示本类是一个 MyBatis 的 Mapper
@Mapper
@Repository
public interface UserMapper {

    //获取所有员工信息
    List<User> getUser();

    //查询员工
    User getUserById(Integer id);

    //增加员工
    int addUser(User user);

    //修改员工
    int updateUser(User user);

    //删除员工
    int deleteUser(int id);

}
```

5. UserMapper.xml

**对应的Mapper映射文件**

![image-20220307155324539](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220307155324539.png)

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.koko.mapper.UserMapper">

    <select id="getUser" resultType="User">
       select * from user;
    </select>

    <select id="getUserById" resultType="User" parameterType="int">
       select * from user where id = #{id};
    </select>

    <insert id="addUser" parameterType="User">
        insert into user (id,name,pwd) values (#{id},#{name},#{pwd})
    </insert>

    <update id="updateUser" parameterType="User">
        update user set name=#{name},pwd=#{pwd} where id=#{id}
    </update>

    <delete id="deleteUser" parameterType="int">
        delete from user where id = #{id}
    </delete>

</mapper>
```

6. maven配置资源过滤问题

~~~xml
<resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
    </resource>
</resources>
~~~

7. UserController

```java
package com.koko.controller;

import com.koko.mapper.UserMapper;
import com.koko.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/getUser")
    public List<User> getUser(){
        return userMapper.getUser();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id")int id){
        return userMapper.getUserById(id);
    }

    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(5,"小小","123456"));
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5,"大大","123456"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(5);
        return "ok";
    }

}
```

> 8、上线测试！



## 8. SpringSecurity

### 8.1 SpringSecurity简介

> 1、web安全简介

在 Web 开发中，安全一直是非常重要的一个方面。安全虽然属于应用的非功能性需求，但是应该在应用开发的初期就考虑进来。如果在应用开发的后期才考虑安全的问题，就可能陷入一个两难的境地：一方面，应用存在严重的安全漏洞，无法满足用户的要求，并可能造成用户的隐私数据被攻击者窃取；另一方面，应用的基本架构已经确定，要修复安全漏洞，可能需要对系统的架构做出比较重大的调整，因而需要更多的开发时间，影响应用的发布进程。因此，从应用开发的第一天就应该把安全相关的因素考虑进来，并在整个应用的开发过程中。

市面上存在比较有名的：Shiro，Spring Security ！



> 2、测试

1. 导入项目的web模板和thymeleaf模板

```xml
<!--thymeleaf-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

2. 导入静态模板

![image-20220308095552271](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308095552271.png)

3. RouterController控制跳转

```java
package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }

}
```

4. 测试

![image-20220308095703375](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308095703375.png)



> 3、Spring Security概述

Spring Security 是针对Spring项目的安全框架，也是Spring Boot底层安全模块默认的技术选型，他可以实现强大的Web安全控制，对于安全控制，我们仅需要引入 spring-boot-starter-security 模块，进行少量的配置，即可实现强大的安全管理！

记住几个类：

- WebSecurityConfigurerAdapter：自定义Security策略
- AuthenticationManagerBuilder：自定义认证策略
- @EnableWebSecurity：开启WebSecurity模式

Spring Security的两个主要目标是 “认证” 和 “授权”（访问控制）。

**“认证”（Authentication）**

身份验证是关于验证您的凭据，如用户名/用户ID和密码，以验证您的身份。

身份验证通常通过用户名和密码完成，有时与身份验证因素结合使用。

 **“授权” （Authorization）**

授权发生在系统成功验证您的身份后，最终会授予您访问资源（如信息，文件，数据库，资金，位置，几乎任何内容）的完全权限。

这个概念是通用的，而不是只在Spring Security 中存在。



### 8.2 认证和授权

> 1、测试

目前，我们的测试环境，是谁都可以访问的，我们使用 Spring Security 增加上认证和授权的功能

1. 引入 Spring Security 模块

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2. 编写 Spring Security 配置类

```java
package com.koko.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // 开启WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //1、授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制请求的授权规则
        // 首页所有人可以访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 1-1、开启自动配置的登录功能
        // /login 请求来到登录页
        // /login?error 重定向到这里表示登录失败
        http.formLogin();
    }

    //2、认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中定义，也可以在jdbc中去拿....
        //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
        //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
        //2-1、spring security 官方推荐的是使用bcrypt加密方式。

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("koko1").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
                .and()
                .withUser("koko2").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
                .and()
                .withUser("koko3").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3");
    }

}
```

3. 测试，发现，登录成功，并且每个角色只能访问自己认证下的规则！



### 8.3 权限控制和注销

> 1、测试

1. 导入springsecurity5依赖

```xml
<!--springsecurity5-->
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-springsecurity5</artifactId>
    <version>3.0.4.RELEASE</version>
</dependency>
```

2. 修改前端页面index.html

* 导入命名空间

```properties
xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5"
```

* 修改导航栏，增加认证判断

```html
<!--登录注销-->
<div class="right menu">

   <!--如果未登录-->
   <div sec:authorize="!isAuthenticated()">
       <a class="item" th:href="@{/login}">
           <i class="address card icon"></i> 登录
       </a>
   </div>

   <!--如果已登录-->
   <div sec:authorize="isAuthenticated()">
       <a class="item">
           <i class="address card icon"></i>
          用户名：<span sec:authentication="principal.username"></span>
          角色：<span sec:authentication="principal.authorities"></span>
       </a>
   </div>

   <div sec:authorize="isAuthenticated()">
       <a class="item" th:href="@{/logout}">
           <i class="address card icon"></i> 注销
       </a>
   </div>
</div>
```

3. SecurityConfig配置类

```java
//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
http.csrf().disable();
// .logoutSuccessUrl("/"); 注销成功来到首页
http.logout().logoutSuccessUrl("/");
```

4. index.html

* 角色功能块认证

```html
<!-- sec:authorize="hasRole('vip1')" -->
<div class="column" sec:authorize="hasRole('vip1')">
   <div class="ui raised segment">
       <div class="ui">
           <div class="content">
               <h5 class="content">Level 1</h5>
               <hr>
               <div><a th:href="@{/level1/1}"><i class="bullhorn icon"></i> Level-1-1</a></div>
               <div><a th:href="@{/level1/2}"><i class="bullhorn icon"></i> Level-1-2</a></div>
               <div><a th:href="@{/level1/3}"><i class="bullhorn icon"></i> Level-1-3</a></div>
           </div>
       </div>
   </div>
</div>

<div class="column" sec:authorize="hasRole('vip2')">
   <div class="ui raised segment">
       <div class="ui">
           <div class="content">
               <h5 class="content">Level 2</h5>
               <hr>
               <div><a th:href="@{/level2/1}"><i class="bullhorn icon"></i> Level-2-1</a></div>
               <div><a th:href="@{/level2/2}"><i class="bullhorn icon"></i> Level-2-2</a></div>
               <div><a th:href="@{/level2/3}"><i class="bullhorn icon"></i> Level-2-3</a></div>
           </div>
       </div>
   </div>
</div>

<div class="column" sec:authorize="hasRole('vip3')">
   <div class="ui raised segment">
       <div class="ui">
           <div class="content">
               <h5 class="content">Level 3</h5>
               <hr>
               <div><a th:href="@{/level3/1}"><i class="bullhorn icon"></i> Level-3-1</a></div>
               <div><a th:href="@{/level3/2}"><i class="bullhorn icon"></i> Level-3-2</a></div>
               <div><a th:href="@{/level3/3}"><i class="bullhorn icon"></i> Level-3-3</a></div>
           </div>
       </div>
   </div>
</div>
```

5. 测试

* vip1

![image-20220308143706147](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308143706147.png)

* vip2

![image-20220308143735450](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308143735450.png)

* vip3

![image-20220308143758640](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308143758640.png)

* 权限控制和注销搞定！



### 8.4 记住我及首页定制

> 1、“记住我”功能实现

1. SecurityConfig配置类

* 在SecurityConfig配置类中的configure方法中定义方法

```java
//定制请求的授权规则
@Override
protected void configure(HttpSecurity http) throws Exception {
   //记住我
   http.rememberMe();
}
```

2. 运行测试

* 登录时点击记住我功能，之后关闭浏览器，然后重新打开浏览器访问，发现用户依旧存在，因为spring security帮我们将登录信息存储在Cookie中14天！！！
* 点击注销时，spring security 帮我们自动删除了这个 Cookie！



> 2、定制登录页功能实现

1. index.html

* 将登录界面跳转的路径更改

```html
<!--如果未登录-->
<div sec:authorize="!isAuthenticated()">
    <a class="item" th:href="@{/toLogin}">
        <i class="address card icon"></i> 登录
    </a>
</div>
```

2. login.html请求

```html
<a class="item" th:href="@{/toLogin}">
    <i class="address card icon"></i> 登录
</a>
```

* 账号密码部分

```html
<form th:action="@{/login}" method="post">
    <div class="field">
        <label>Username</label>
        <div class="ui left icon input">
            <input type="text" placeholder="Username" name="username">
            <i class="user icon"></i>
        </div>
    </div>
    <div class="field">
        <label>Password</label>
        <div class="ui left icon input">
            <input type="password" name="password">
            <i class="lock icon"></i>
        </div>
    </div>
    <input type="submit" class="ui blue submit button"/>
    <div class="field">
        <input type="checkbox" name="remember"> 记住我
    </div>
</form>
```

3. SecurityConfig配置类

```java
//1、开启自动配置的登录功能：如果没有权限，就会跳转到登录页面！
// /login 请求来到登录页
// /login?error 重定向到这里表示登录失败
http.formLogin()
  .usernameParameter("username")
  .passwordParameter("password")
  .loginPage("/toLogin")
  .loginProcessingUrl("/login"); // 登陆表单提交请求

//4、定制记住我的参数！
http.rememberMe().rememberMeParameter("remember");
```

4. 测试

* 登录界面

![image-20220308152709796](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308152709796.png)

* 进入首页

![image-20220308152728718](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308152728718.png)



## 9. Shiro

### 9.1 Shiro简介

> 1、什么是Shiro?

* Apache Shiro是一个Java 的安全(权限)框架。
* Shiro可以非常容易的开发出足够好的应用，其不仅可以用在JavaSE环境，也可以用在JavaEE环境。
* Shiro可以完成，认证，授权，加密，会话管理，Web集成，缓存等.
* 下载地址: http://shiro.apache.org/

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201103221329444.png)



> 2、shiro的功能

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201103223432234.png)

* Authentication: 身份认证、登录，验证用户是不是拥有相应的身份;
* Authorization:授权,即权限验证，验证某个已认证的用户是否拥有某个权限，即判断用户能否进行什么操作，如:验证某个用户是否拥有某个角色，或者细粒度的验证某个用户对某个资源是否具有某个权限!
* Session Manager: 会话管理，即用户登录后就是第1次会话，在没有退出之前，它的所有信息都在会话中;会话可以是普通的JavaSE环境，也可以是Web环境;
* Cryptography: 加密,保护数据的安全性，如密码加密存储到数据库中，而不是明文存储;
* Web Support: Web支持，可以非常容易的集成到Web环境;
* Caching: 缓存，比如用户登录后，其用户信息，拥有的角色、权限不必每次去查,这样可以提高效率
* Concurrency: Shiro支持多线程应用的并发验证，即，如在一个线程中开启另-一个线程,能把权限自动的传
  播过去
* Testing:提供测试支持;
* RunAs:允许一个用户假装为另-一个用户(如果他们允许)的身份进行访问;
* Remember Me:记住我，这个是非常常见的功能，即一次登录后， 下次再来的话不用登录了



> 3、Shiro架构

1. 外部结构

从外部来看`Shiro`,即从应用程序角度来观察如何使用`shiro`完成工作：

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201103223750298.png)

* subject: 应用代码直接交互的对象是Subject, 也就是说Shiro的对外API核心就是Subject, Subject代表了当前的用户，这个用户不-定是一个具体的人，与当前应用交互的任何东西都是Subject,如网络爬虫，机器人等，与Subject的所有交互都会委托给SecurityManager; Subject其实是一一个门面， SecurityManageer 才是
  实际的执行者
* SecurityManager: 安全管理器，即所有与安全有关的操作都会与SercurityManager交互, 并且它管理着所有的Subject,可以看出它是Shiro的核心，它负责与Shiro的其他组件进行交互，它相当于SpringMVC的DispatcherServlet的角色
* Realm: Shiro从Realm获取安全数据 (如用户,角色，权限)，就是说SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户进行比较，来确定用户的身份是否合法;也需要从Realm得到用户相应的角色、权限，进行验证用户的操作是否能够进行，可以把Realm看DataSource;

2. 内部结构

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201103224134417.png)

* Subject: 任何可以与应用交互的用户;
* Security Manager:相当于SpringMVC中的DispatcherSerlet; 是Shiro的心脏， 所有具体的交互都通过Security Manager进行控制，它管理者所有的Subject, 且负责进行认证,授权，会话，及缓存的管理。
* Authenticator:负责Subject认证， 是-一个扩展点，可以自定义实现;可以使用认证策略(Authentication Strategy)，即什么情况下算用户认证通过了;
* Authorizer:授权器，即访问控制器，用来决定主体是否有权限进行相应的操作;即控制着用户能访问应用中
  的那些功能;
* Realm: 可以有-一个或者多个的realm, 可以认为是安全实体数据源，即用于获取安全实体的，可以用JDBC实现，也可以是内存实现等等，由用户提供;所以- -般在应用中都需要实现自己的realm
* SessionManager:管理Session生 命周期的组件,而Shiro并不仅仅可以用在Web环境，也可以用在普通的JavaSE环境中
* CacheManager: 缓存控制器，来管理如用户，角色，权限等缓存的;因为这些数据基本上很少改变,放到缓存中后可以提高访问的性能;
* Cryptography:密码模块，Shiro 提高了一些常见的加密组件用于密码加密， 解密等



### 9.2 Shiro快速开始

> 1、准备工作

官方项目路径：[mirrors / apache / shiro · GitCode](https://gitcode.net/mirrors/apache/shiro?utm_source=csdn_github_accelerator)

1. 创建一个普通的maven项目，然后删除`src`目录，创建一个新model——>hello-shiro

![image-20220308160221697](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308160221697.png)

2. pom.xml

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201103233846303.png)

~~~xml
<dependencies>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-core</artifactId>
            <version>1.4.1</version>
        </dependency>

        <!-- configure logging -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>jcl-over-slf4j</artifactId>
            <version>1.7.21</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.21</version>
        </dependency>

        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
</dependencies>
~~~

3. log4j.properties 和 shiro.ini

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201103234457922.png)

* log4j.properties

```properties
log4j.rootLogger=INFO, stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d %p [%c] - %m %n

# General Apache libraries
log4j.logger.org.apache=WARN

# Spring
log4j.logger.org.springframework=WARN

# Default Shiro logging
log4j.logger.org.apache.shiro=INFO

# Disable verbose logging
log4j.logger.org.apache.shiro.util.ThreadContext=WARN
log4j.logger.org.apache.shiro.cache.ehcache.EhCache=WARN
```

* shiro.ini

```ini
[users]
# user 'root' with password 'secret' and the 'admin' role
root = secret, admin
# user 'guest' with the password 'guest' and the 'guest' role
guest = guest, guest
# user 'presidentskroob' with password '12345' ("That's the same combination on
# my luggage!!!" ;)), and role 'president'
presidentskroob = 12345, president
# user 'darkhelmet' with password 'ludicrousspeed' and roles 'darklord' and 'schwartz'
darkhelmet = ludicrousspeed, darklord, schwartz
# user 'lonestarr' with password 'vespa' and roles 'goodguy' and 'schwartz'
lonestarr = vespa, goodguy, schwartz

# -----------------------------------------------------------------------------
# Roles with assigned permissions
#
# Each line conforms to the format defined in the
# org.apache.shiro.realm.text.TextConfigurationRealm#setRoleDefinitions JavaDoc
# -----------------------------------------------------------------------------
[roles]
# 'admin' role has all permissions, indicated by the wildcard '*'
admin = *
# The 'schwartz' role can do anything (*) with any lightsaber:
schwartz = lightsaber:*
# The 'goodguy' role is allowed to 'drive' (action) the winnebago (type) with
# license plate 'eagle5' (instance specific id)
goodguy = winnebago:drive:eagle5
```

4. java包下的Quickstart运行类

```java
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);


    public static void main(String[] args) {

        //可以删除
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // get the currently executing user:
        //获取当前用户的对象 Subject
        Subject currentUser = SecurityUtils.getSubject();

        // 通过当前用户拿到Session
        Session session = currentUser.getSession();

        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("Retrieved the correct value! [" + value + "]");
        }

        // 判断当前的用户是否被认证
        if (!currentUser.isAuthenticated()) {

            //Token : 令牌，没有获取，随机
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true); //设置记住我

            try {
                currentUser.login(token); //执行了登录操作~
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //粗粒度
        //test a typed permission (not instance-level)
        if (currentUser.isPermitted("lightsaber:wield")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //细粒度
        //a (very powerful) Instance Level permission:
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //注销
        //all done - log out!
        currentUser.logout();

        //结束启动
        System.exit(0);
    }
}
```

5. 运行结果

![image-20220308160652254](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308160652254.png)



> 2、Quickstart类简述原理

* 将在SpringBoot中集成~

~~~java
//1、获取当前用户的对象 Subject
Subject currentUser = SecurityUtils.getSubject();
//2、通过当前用户拿到Session
Session session = currentUser.getSession();
//3、判断当前的用户是否被认证
currentUser.isAuthenticated()
//4、获得当前用户的认证
currentUser.getPrincipal()
//5、当前用户是否有某个角色
currentUser.hasRole("schwartz")
//6、根据不同的角色获取不同的权限
currentUser.isPermitted("lightsaber:wield")
//7、注销
currentUser.logout();
~~~



### 9.3 SpringBoot整合Shiro环境搭建

> 1、基础配置

1. 新建SpringBoot项目,勾选`web`和`thymeleaf`

![image-20220308174850795](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308174850795.png)

2. `templates`下新建`index.html`

~~~html
<!DOCTYPE html>
<html lang="en"
      xmlns:th="https://www.thymeleaf.org"
      xmlns:shiro="https://www.thymeleaf.org/thymeleaf-extras-shiro">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>首页</h1>

<p th:text="${msg}"></p>

</body>
</html>
~~~

3. `controller`包下新建`MyController`

~~~java
package com.koko.controller;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,shiro");
        return "index";
    }
}
~~~

4. 测试

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201104093253194.png)

> 2、测试

1. shiro-spring的maven包

```xml
<!--shiro-->
<dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring</artifactId>
    <version>1.4.1</version>
</dependency>
```

2. 配置类

![image-20220308175303217](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308175303217.png)

* UserRealm

```java
package com.koko.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

//自定义的 UserRealm
public class UserRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");
        return null;
    }
}
```

* ShiroConfig

```java
package com.koko.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        return bean;
    }


    //DefaultWebSecurityManager:2
    @Bean(name="securityManager")
    public DefaultWebSecurityManager DefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    //创建 realm 对象:需要自定义类:1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
```

3. 导入静态资源

![image-20220308175417861](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308175417861.png)

* add 和 update页面只有一个普通的h1标签

* index.html

```html
<!DOCTYPE html>
<html lang="en"
      xmlns:th="https://www.thymeleaf.org"
      xmlns:shiro="https://www.thymeleaf.org/thymeleaf-extras-shiro">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>首页</h1>

<p th:text="${msg}"></p>

<a th:href="@{/user/add}">add</a>
<a th:href="@{/user/update}">update</a>

</body>
</html>
```

4. MyController控制类

```java
package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,Shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String toAdd(Model model){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String toUpdate(Model model){
        return "user/update";
    }

}
```

5. 测试

![image-20220308175623118](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220308175623118.png)

* 可以正常地进行页面跳转！为后面做准备



### 9.4 登录拦截

> 1、具体实现

1. ShiroConfig类

* 在 ShiroFilterFactoryBean:3 方法中加入下面代码

~~~java
/*
        * anon:无需认证就可以访问
        * authc:必须认证了才能访问
        * user:必须拥有 记住我 功能才能用
        * perms:拥有对某个资源的权限才能访问
        * role:拥有某个角色权限才能访问
        * */

//拦截
Map<String,String> filterMap = new LinkedHashMap<>();
filterMap.put("/user/*","authc");
bean.setFilterChainDefinitionMap(filterMap);

//设置登录的请求
bean.setLoginUrl("/toLogin");
~~~

2. MyController类中添加跳转事务

```java
@RequestMapping("/toLogin")
public String toLogin(){
    return "login";
}
```

3. 在templates包下添加login页面

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>登录</h1>

<hr>
<form action="">
    <p>用户名: <input type="text" name="username"></p>
    <p>密码: <input type="text" name="password"></p>
    <p><input type="submit"></p>
</form>

</body>
</html>
```

4. 测试

* 点击update时

![image-20220309095604186](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309095604186.png)

* 页面被拦截，回到登录页面

![image-20220309095635639](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309095635639.png)



### 9.5 用户认证

> 1、实现流程

1. UserRealm

* 认证方法

```java
//认证
@Override
protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    System.out.println("执行了=>认证doGetAuthenticationInfo");

    //取数据
    String name="root";
    String password="123456";

    UsernamePasswordToken userToken = (UsernamePasswordToken) token;

    if(!userToken.getUsername().equals(name)){
        return null; //抛出异常 UnknownAccountException
    }

    //密码认证，shiro做~
    return new SimpleAuthenticationInfo("",password,"");
}
```

2. MyController页面跳转类

```java
@RequestMapping("/login")
public String login(String username,String password,Model model){
    //获取当前的用户
    Subject subject = SecurityUtils.getSubject();
    //封装用户的登录信息
    UsernamePasswordToken token = new UsernamePasswordToken(username, password);

    try{
        subject.login(token);   //执行登录方法，如果没有异常就说明ok了
        return "index";
    }catch (UnknownAccountException e){
        model.addAttribute("msg","用户名错误");
        return "login";
    }catch (IncorrectCredentialsException e){
        model.addAttribute("msg","密码错误");
        return "login";
    }
}
```

3. 更改login.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>登录</h1>

<hr>

<p th:text="${msg}" style="color:red"></p>

<form th:action="@{/login}">
    <p>用户名: <input type="text" name="username"></p>
    <p>密码: <input type="text" name="password"></p>
    <p><input type="submit"></p>
</form>

</body>
</html>
```

* 测试，当用户成功登录后才有权限使用`add`和`update`功能

* 原理：调用shiro中的认证功能！

![image-20220309102740828](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309102740828.png)



### 9.6 Shiro整合mybatis

> 1、项目框架

* 项目结构

![image-20220309110758128](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309110758128.png)

* 数据库的user表

![image-20220309111532330](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309111532330.png)



> 2、项目实现流程

1. maven导入包

```xml
<!--shiro整合mybatis-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
</dependency>

<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.8</version>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.2</version>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
    <scope>provided</scope>
</dependency>
```

2. application.yml

```yml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    #Spring Boot 默认是不注入这些属性值的，需要自己绑定
    #druid 数据源专有配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，stat:监控统计、log4j：日志记录、wall：防御sql注入
    #如果允许时报错  java.lang.ClassNotFoundException: org.apache.log4j.Priority
    #则导入 log4j 依赖即可，Maven 地址：https://mvnrepository.com/artifact/log4j/log4j
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

mybatis:
  type-aliases-package: com.koko.pojo
  mapper-locations: classpath:mapper/*.xml
```

3. 实体类User

```java
package com.koko.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    private int id;
    private String name;
    private String pwd;
    private String perms;
    
}
```

4. mapper层

* UserMapper接口类

```java
package com.koko.mapper;

import com.koko.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper//这个注解表示了这是一个mybatis的mapper类
@Repository
public interface UserMapper {

    public User queryUserByName(String name);

}
```

* UserMapper接口实现类`UserMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.koko.mapper.UserMapper">

    <select id="queryUserByName" resultType="User" parameterType="String">
        select * from user where name=#{name}
    </select>

</mapper>
```

5. service层

* UserService业务接口类

```java
package com.koko.service;

import com.koko.pojo.User;

public interface UserService {

    User queryUserByName(String name);

}
```

* UserService业务接口实现类`UserServiceImpl`	

```java
package com.koko.service;

import com.koko.mapper.UserMapper;
import com.koko.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
```

6. UserRealm类

```java
@Autowired
UserService userService;

//认证
@Override
protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    System.out.println("执行了=>认证doGetAuthenticationInfo");

    UsernamePasswordToken userToken = (UsernamePasswordToken) token;
    //连接真实的数据库
    User user = userService.queryUserByName(userToken.getUsername());

    if(user==null){
        return null; //抛出异常 UnknownAccountException
    }

    //密码认证，shiro做~,加密了
    //MD5 及 MD5盐值加密
    return new SimpleAuthenticationInfo("",user.getPwd(),"");
}
```

7. 测试

![image-20220309111652894](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309111652894.png)

* 成功连接上数据库



### 9.7 Shiro请求授权实现

> 1、实现流程

1. 数据库层面

* 添加多一个字段，用来存储用户的授权

![image-20220309114233530](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309114233530.png)

![image-20220309114330161](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309114330161.png)

* 项目所要用的数据库

![image-20220309115429273](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309115429273.png)

* 记得实体类添加上新字段

2. ShiroConfig配置类

* ShiroFilterFactoryBean:3 方法

```java
@Bean
public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
    ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
    //设置安全管理器
    bean.setSecurityManager(defaultWebSecurityManager);

    /*
    * anon:无需认证就可以访问
    * authc:必须认证了才能访问
    * user:必须拥有 记住我 功能才能用
    * perms:拥有对某个资源的权限才能访问
    * role:拥有某个角色权限才能访问
    * */

    //拦截
    Map<String,String> filterMap = new LinkedHashMap<>();

    //授权，正常情况下，没有授权会跳转到未授权页面401
    filterMap.put("/user/add","perms[user:add]");
    filterMap.put("/user/update","perms[user:update]");

    filterMap.put("/user/*","authc");
    bean.setFilterChainDefinitionMap(filterMap);

    //设置登录的请求
    bean.setLoginUrl("/toLogin");
    //未授权页面
    bean.setUnauthorizedUrl("/noauth");

    return bean;
}
```

* 只要添加授权代码

```java
//授权，正常情况下，没有授权会跳转到未授权页面401
filterMap.put("/user/add","perms[user:add]");
filterMap.put("/user/update","perms[user:update]");

//未授权页面
bean.setUnauthorizedUrl("/noauth");
```

3. UserRealm配置类

~~~java
//授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();

        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }
~~~

* 认证类中返回值修改

```java
//密码认证，shiro做~,加密了
//MD5 及 MD5盐值加密
return new SimpleAuthenticationInfo(user,user.getPwd(),"");
```

4. MyController

```java
@RequestMapping("/noauth")
@ResponseBody
public String unauthorized(){
    return "需要授权才能访问该页面";
}
```

5. 测试

* 以小明为例

* 进入add页面成功！

![image-20220309124903409](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309124903409.png)

* 进入update页面失败，没有权限！

![image-20220309124918941](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309124918941.png)



### 9.8 Shiro整合Thymeleaf

> 1、实现流程

1. 导入shiro-thymeleaf整合包

```xml
<!--shiro-thymeleaf整合-->
<dependency>
    <groupId>com.github.theborakompanioni</groupId>
    <artifactId>thymeleaf-extras-shiro</artifactId>
    <version>2.1.0</version>
</dependency>
```

2. ShiroConfig类

```java
//整合shiroDialect:用来整合shiro thymeleaf
@Bean
public ShiroDialect getShiroDialect(){
    return new ShiroDialect();
}
```

3. 修改登陆页面index.html

```html
<!DOCTYPE html>
<html lang="en"
      xmlns:th="https://www.thymeleaf.org"
      xmlns:shiro="https://www.thymeleaf.org/thymeleaf-extras-shiro">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>首页</h1>

<div shiro:notAuthenticated>
    <a th:href="@{/toLogin}">登录</a>
</div>

<!--<div shiro:Authenticated="*:*">-->
<!--    <a href="#" th:href="@{/logout}">注销</a>-->
<!--</div>-->

<p th:text="${msg}"></p>

<div shiro:hasPermission="user:add">
    <a th:href="@{/user/add}">add</a>
</div>

<div shiro:hasPermission="user:update">
    <a th:href="@{/user/update}">update</a>
</div>

</body>
</html>
```

4. 测试

* 只有添加权限的小明同学

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309155649622.png" alt="image-20220309155649622" style="zoom:50%;" />

* 只有修改权限的李四同学

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309155727468.png" alt="image-20220309155727468" style="zoom:50%;" />

* 没有权限的王五同学

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220309155803021.png" alt="image-20220309155803021" style="zoom:50%;" />

* 测试成功！！！



## 10. 异步、邮件任务、定时

### 10.1 异步

> 1、为什么要使用异步处理任务？

异步处理任务，比如我们在网站上发送邮件，后台会去发送邮件，此时前台会造成响应不动，直到邮件发送完毕，响应才会成功，所以我们一般会采用多线程的方式去处理这些任务。

> 2、测试

1. 在业务层service中定义AsyncService类

```java
package com.koko.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    //告诉Spring这是一个异步方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务进行中....");
    }

}
```

2. AsyncController控制类

```java
package com.koko.controller;

import com.koko.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    //简单跳转
    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "success";
    }

}
```

3. Springboor09TestApplication

* 在SpringBoot测试类中添加注释

```java
package com.koko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync //开启异步注解功能
@SpringBootApplication
public class Springboor09TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboor09TestApplication.class, args);
    }

}
```

4. 测试：http://localhost:8080/hello

* 网页瞬间响应，后台代码依旧执行



### 10.2 邮件任务

> 1、概述

邮件发送，在我们的日常开发中，也非常的多，Springboot也帮我们做了支持

- 邮件发送需要引入spring-boot-start-mail
- SpringBoot 自动配置MailSenderAutoConfiguration
- 定义MailProperties内容，配置在application.yml中
- 自动装配JavaMailSender
- 测试邮件发送

> 2、测试

1. 导入spring-boot-starter-mail依赖

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

* 如果导入失败，则降spring-boot-starter-parent版本！！！

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.5.6</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

2. 配置文件application.properties

```properties
spring.mail.username=2427886409@qq.com
spring.mail.password=tacbzldrjdavebea	# 授权码
spring.mail.host=smtp.qq.com
# qq需要配置ssl
spring.mail.properties.mail.smtp.ssl.enable=true
```

* 获取授权码：在QQ邮箱中的设置->账户->开启pop3和smtp服务

3. 测试类中进行测试

```java
@Autowired
JavaMailSenderImpl mailSender;

@Test
public void contextLoads() {
    //邮件设置1：一个简单的邮件
    SimpleMailMessage message = new SimpleMailMessage();
    message.setSubject("1、简单的邮件");
    message.setText("helloworld");

    message.setTo("2427886409@qq.com");
    message.setFrom("2427886409@qq.com");
    mailSender.send(message);
}

@Test
public void contextLoads2() throws MessagingException {
    //邮件设置2：一个复杂的邮件
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

    helper.setSubject("2、复杂的邮件");
    helper.setText("<b style='color:red'>helloworld</b>",true);

    //发送附件
    helper.addAttachment("1.jpg",new File("C:\\Users\\koko\\Desktop\\蜡笔小新.ico"));
    helper.addAttachment("2.jpg",new File("C:\\Users\\koko\\Desktop\\蜡笔小新.ico"));

    helper.setTo("2427886409@qq.com");
    helper.setFrom("2427886409@qq.com");

    mailSender.send(mimeMessage);
}
```

4. 测试：

* 简单的邮件发送

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311122757343.png" alt="image-20220311122757343"  />

* 复杂的邮件发送

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311123154653.png" alt="image-20220311123154653" style="zoom:50%;" />

查看邮箱，邮件接收成功！

我们只需要使用Thymeleaf进行前后端结合即可开发自己网站邮件收发功能了！



### 10.3 定时任务

> 1、概述

项目开发中经常需要执行一些定时任务，比如需要在每天凌晨的时候，分析一次前一天的日志信息，Spring为我们提供了异步执行任务调度的方式，提供了两个接口。

- TaskExecutor接口
- TaskScheduler接口

两个注解：

- @EnableScheduling  //SpringBoot启动类
- @Scheduled  //执行方法



> 2、测试

1. ScheduledService业务类

```java
package com.koko.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //秒   分   时     日   月   周几
    //0 * * * * MON-FRI
    //注意cron表达式的用法；
    @Scheduled(cron = "0 * * * * 0-7")
    public void hello(){
        System.out.println("hello.....");
    }

}
```

2. 在SpringBoot测试类中添加注释

```java
@EnableScheduling //开启基于注解的定时任务
```

3. 我们来详细了解下cron表达式

http://www.bejson.com/othertools/cron/

4. 常用的表达式

```properties
（1）0/2 * * * * ?   表示每2秒 执行任务
（1）0 0/2 * * * ?   表示每2分钟 执行任务
（1）0 0 2 1 * ?   表示在每月的1日的凌晨2点调整任务
（2）0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业
（3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作
（4）0 0 10,14,16 * * ?   每天上午10点，下午2点，4点
（5）0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
（6）0 0 12 ? * WED   表示每个星期三中午12点
（7）0 0 12 * * ?   每天中午12点触发
（8）0 15 10 ? * *   每天上午10:15触发
（9）0 15 10 * * ?     每天上午10:15触发
（10）0 15 10 * * ?   每天上午10:15触发
（11）0 15 10 * * ? 2005   2005年的每天上午10:15触发
（12）0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发
（13）0 0/5 14 * * ?   在每天下午2点到下午2:55期间的每5分钟触发
（14）0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
（15）0 0-5 14 * * ?   在每天下午2点到下午2:05期间的每1分钟触发
（16）0 10,44 14 ? 3 WED   每年三月的星期三的下午2:10和2:44触发
（17）0 15 10 ? * MON-FRI   周一至周五的上午10:15触发
（18）0 15 10 15 * ?   每月15日上午10:15触发
（19）0 15 10 L * ?   每月最后一日的上午10:15触发
（20）0 15 10 ? * 6L   每月的最后一个星期五上午10:15触发
（21）0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发
（22）0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发
```





## 11. Dubbo和Zookeeper集成

### 11.1 分布式理论

> **1、什么是分布式系统？**

在《分布式系统原理与范型》一书中有如下定义：“分布式系统是若干独立计算机的集合，这些计算机对于用户来说就像单个相关系统”；

分布式系统是由一组通过网络进行通信、为了完成共同的任务而协调工作的计算机节点组成的系统。分布式系统的出现是为了用廉价的、普通的机器完成单个计算机无法完成的计算、存储任务。其目的是**利用更多的机器，处理更多的数据**。

分布式系统（distributed system）是建立在网络之上的软件系统。

首先需要明确的是，只有当单个节点的处理能力无法满足日益增长的计算、存储任务的时候，且硬件的提升（加内存、加磁盘、使用更好的CPU）高昂到得不偿失的时候，应用程序也不能进一步优化的时候，我们才需要考虑分布式系统。因为，分布式系统要解决的问题本身就是和单机系统一样的，而由于分布式系统多节点、通过网络通信的拓扑结构，会引入很多单机系统没有的问题，为了解决这些问题又会引入更多的机制、协议，带来更多的问题。。。

> 2、Dubbo文档

随着互联网的发展，网站应用的规模不断扩大，常规的垂直应用架构已无法应对，分布式服务架构以及流动计算架构势在必行，急需**一个治理系统**确保架构有条不紊的演进。

在Dubbo的官网文档有这样一张图

![image-20220311214745570](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311214745570.png)



> 1、单一应用架构

当网站流量很小时，只需一个应用，将所有功能都部署在一起，以减少部署节点和成本。此时，用于简化增删改查工作量的数据访问框架(ORM)是关键。

![image-20220311214819155](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311214819155.png)

适用于小型网站，小型管理系统，将所有功能都部署到一个功能里，简单易用。

1、性能扩展比较难

2、协同开发问题

3、不利于升级维护

> 2、垂直应用架构

当访问量逐渐增大，单一应用增加机器带来的加速度越来越小，将应用拆成互不相干的几个应用，以提升效率。此时，用于加速前端页面开发的Web框架(MVC)是关键。

![image-20220311214936464](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311214936464.png)

通过切分业务来实现各个模块独立部署，降低了维护和部署的难度，团队各司其职更易管理，性能扩展也更方便，更有针对性。

缺点：公用模块无法重复利用，开发性的浪费

> 3、分布式服务架构

当垂直应用越来越多，应用之间交互不可避免，将核心业务抽取出来，作为独立的服务，逐渐形成稳定的服务中心，使前端应用能更快速的响应多变的市场需求。此时，用于提高业务复用及整合的**分布式服务框架(RPC)**是关键。

![image-20220311215008041](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311215008041.png)

> 4、流动计算架构

当服务越来越多，容量的评估，小服务资源的浪费等问题逐渐显现，此时需增加一个调度中心基于访问压力实时管理集群容量，提高集群利用率。此时，用于**提高机器利用率的资源调度和治理中心**(SOA)[ Service Oriented Architecture]是关键。

![image-20220311215040262](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311215040262.png)



### 11.2 什么是RPC

> 1、概述

RPC【Remote Procedure Call】是指远程过程调用，是一种进程间通信方式，他是一种技术的思想，而不是规范。它允许程序调用另一个地址空间（通常是共享网络的另一台机器上）的过程或函数，而不用程序员显式编码这个远程调用的细节。即程序员无论是调用本地的还是远程的函数，本质上编写的调用代码基本相同。

也就是说两台服务器A，B，一个应用部署在A服务器上，想要调用B服务器上应用提供的函数/方法，由于不在一个内存空间，不能直接调用，需要通过网络来表达调用的语义和传达调用的数据。为什么要用RPC呢？就是无法在一个进程内，甚至一个计算机内通过本地调用的方式完成的需求，比如不同的系统间的通讯，甚至不同的组织间的通讯，由于计算能力需要横向扩展，需要在多台机器组成的集群上部署应用。RPC就是要像调用本地的函数一样去调远程函数；

推荐阅读文章：https://www.jianshu.com/p/2accc2840a1b

**RPC基本原理**

![image-20220311215125107](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311215125107.png)

**步骤解析：**

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311215143733.png" alt="image-20220311215143733" style="zoom: 50%;" />

RPC两个核心模块：通讯，序列化。



### 11.3 测试环境搭建

> 1、Dubbo

Apache Dubbo |ˈdʌbəʊ| 是一款高性能、轻量级的开源Java RPC框架，它提供了三大核心能力：面向接口的远程方法调用，智能容错和负载均衡，以及服务自动注册和发现。

dubbo官网 http://dubbo.apache.org/zh-cn/index.html

1.了解Dubbo的特性

2.查看官方文档

**dubbo基本概念**

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311215250368.png" alt="image-20220311215250368" style="zoom:80%;" />

**服务提供者**（Provider）：暴露服务的服务提供方，服务提供者在启动时，向注册中心注册自己提供的服务。

**服务消费者**（Consumer）：调用远程服务的服务消费方，服务消费者在启动时，向注册中心订阅自己所需的服务，服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。

**注册中心**（Registry）：注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者

**监控中心**（Monitor）：服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心

**调用关系说明**

l 服务容器负责启动，加载，运行服务提供者。

l 服务提供者在启动时，向注册中心注册自己提供的服务。

l 服务消费者在启动时，向注册中心订阅自己所需的服务。

l 注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。

l 服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。

l 服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心。



> 2、Dubbo环境搭建（Window下安装zookeeper）

点进dubbo官方文档，推荐我们使用Zookeeper 注册中心

下载链接：[Apache ZooKeeper](https://zookeeper.apache.org/releases.html#download)

下载版本：3.8.0

![image-20220311215554775](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311215554775.png)

* 注意：3.5版本后要下载bin文件

1. 解压后打开conf，将zoo_sample.cfg复制一份改名为zoo.cfg

* 将dataDir=./删掉，加入下列命令

~~~properties
dataDir=D:\Java_Tools\zookeeper\apache-zookeeper-3.8.0-bin\data
audit.enable=true
~~~

2. 打开bin文件夹的zkServer.cmd（注意要用管理员模式）

![image-20220311220017093](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220311220017093.png)

* 完毕！

> 总结

1. 小结

zookeeper：注册中心

dubbo-admin：一个监控管理后台~查看我们注册了哪些服务，哪些服务被消费了~

Dubbo：jar包

2. 步骤

前提：zookeeper服务已经开启！

1. 提供者提供服务
   1. 导入依赖
   2. 配置注册中心的地址，以及服务发现名，和要扫描的包~
   3. 在想要被注册的服务上面~ 增加一个注解 @Service
2. 消费者如何消费
   1. 导入依赖
   2. 配置注册中心的地址，配置自己的服务名
   3. 从远程注入服务~ @Reference



## 12. 回顾和展望

回顾以前，架构！

~~~properties
三层架构 + MVC
	架构 -->解耦

开发框架
    Spring
		IOC		AOP
			IOC : 控制反转
			 	泡温泉,泡茶泡友
				附近的人,打招呼。加微信,聊天,天天聊>约泡
				浴场(容器):温泉,茶庄泡友
				直接进温泉,就有人和你一起了!
原来我们都是自己一步步操作,现在交给容器了!我们需要什么就去拿就可以了
                
             AOP:切面(本质,动态代理）
为了解什么?不影响业本来的情况下,实现动态增加功能,大量应用在日志,事务等等
                    
	Spring是一个轻量级的Java开源框架，容器
        目的：解决企业开发的复杂性问题
        Spring是春天，但配置文件繁琐

    SpringBoot
      	SpringBoot ,新代javaEE的开发标准,开箱即用!>拿过来就可以用,
        它自动帮我们配置了非常多的东西,我们拿来即用,
        特性:约定大于配置!
                    
随着公司体系越来越大,用户越来越多
                    
微服务架构—>新架构
	模块化,功能化!
	用户,支付,签到,娱乐…;
	如果一台服务器解决不了就再增加一台服务器! --横向扩展
	假设A服务器占用98%资源B服务器只占用了10%.–负载均衡;

	将原来的整体项,分成模块化,用户就是一个单独的项目,签到也是一个单独的项目,项目和项目之前需要通信,如何通信
	用户非常多而到十分少给用户多一点服务器,给签到少一点服务器
微服务架构问题?
                    
分布式架构会遇到的四个核心题?
   	1.这么多服务,客户端该如何去访?
    2.这么多服务,服务之间如何进行通信?
    3.这么多服务,如何治理呢?
    4.服务挂了,怎么办?
        
解决方案:                    
	Springcloud是一套生态，就是来解决以上分布式架构的4个问题
    想使用Spring Clould ,必须要掌握 springBoot , 因为Springcloud是基于springBoot ;

	1. spring Cloud NetFlix ,出来了一套解决方案！一站式解决方案。可以直接使用
	Api网关 , zuul组件
	Feign --> Httpclient —> http通信方式,同步并阻塞
	服务注册与发现 , Eureka
	熔断机制 , Hystrix
                    
2018年年底,NetFlix 宣布无限期停止维护。生态不再维护,就会脱节。

	2. Apache Dubbo zookeeper ,第二套解决方案
	API:没有!要么找第三方组件,要么自己实现
	Dubbo 是一个高性能的基于ava实现的RPC通信框架!2.6.x
	服务注册与发现 , zookeeper :动物管理者 ( Hadoop , Hive )
	没有:借助了Hystrix
                    
不完善，Dubbo

	3. SpringCloud Alibaba 一站式解决方案

目前又提出了新的思路:
	服务网格：也许是下一代维服务标准，Service mesh
	代表解决方案：istio（未来可能需要掌握）

万变不离其宗,一通百通！
	1.API网关 ， 服务路由
	2.HTTP，RPC框架，异步调用
	3.服务注册与发现，高可用
	4.熔断机制，服务降级
         
为什么要解决这个问题？因为网络是不可靠的!!!
~~~

