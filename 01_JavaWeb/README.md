# JavaWeb学习资源

>声明：

本文章是基于狂神的课程所编写，请结合下述文章和上述项目一同学习！

## 1. web基本概念

### 1.1 静态web

> 1、静态web原理

![image-20211126151300494](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126151300494.png)

* **静态web的缺点**
  * web无法动态更新
    * 轮播图,点击特效:伪动态
    * JavaScript[实际开发使用最多]
    * VBScript
  * 它无法与数据库进行交互(数据无法持久化)



### 1.2 动态web

> 1、动态web原理

![image-20211126152252891](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126152252891.png)

* **动态web的缺点**
  * 加入服务器的动态web资源出现错误,我们需要重新编写我们的后台程序,出现颁布(停机维护);

* **动态web的优点**
  * web可以动态更新
  * 它可以与数据库进行交互(数据可以持久化)



## 2. web服务器

### 2.1 web技术讲解

> 1、ASP

* 微软:国内最早流行的动态服务器页面
* 在HTML中嵌入VB的脚本,ASP+COM
* 在ASP开发中,基本一个页面都有几千行的业务代码,页面极其混乱
* 维护成本高!
* 基于C#开发,IIS

> 2、PHP

* PHP开发速度很快,功能很强大,跨平台,代码简单(WP)
* 无法承载大访问量的情况(局限性)
* 大部分中小型网站都是由PHP制作的

> 3、JSP/Servlet

B/S:浏览和服务器

C/S:客户端和服务器

* sun公司主推的B/S架构
* 基于Java语言的(所有的大公司,或者一些开源的组件,都是用于Java写的)
* 可以承载高并发 高可用 高性能



### 2.2 web服务器

* 服务器是一种被动操作,用于处理用户的一些请求和给用户一些相应信息

> 1、Tomcat

![image-20211126153710673](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126153710673.png)

Tomcat是Apache 软件基金会（Apache Software Foundation）的Jakarta 项目中的一个核心项目，Tomcat 5支持最新的Servlet 2.4 和JSP 2.0 规范。因为Tomcat **技术先进**、**性能稳定**，而且**免费**，因而深受Java 爱好者的喜爱并得到了部分软件开发商的认可，成为比较流行的Web 应用服务器。

Tomcat 服务器是一个免费的开放源代码的Web 应用服务器，属于轻量级应用[服务器](https://baike.baidu.com/item/服务器)，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP 程序的首选。

Tomcat 实际上运行JSP 页面和Servlet。



## 3. Tomcat

> 1、上述web服务器介绍了tomcat的基本概念

### 3.1 Tomcat的启动与关闭

![image-20211126155417510](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126155417510.png)

访问测试:http://localhost:8080/

可能遇到的问题:

* java环境变量没有配置
* 闪退问题:需要配置兼容性
* 乱码问题:配置文件中设置



### 3.2 Tomcat的配置

![image-20211126161252581](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126161252581.png)

> 1、可以配置启动的端口号

* tomcat默认端口号:8080
* mysql:3306
* http:80
* https:443

~~~xml
<Connector port="8080" redirectPort="8443" connectionTimeout="20000" protocol="HTTP/1.1"/>
~~~

> 2、可以配置主机的名称

* 默认的主机名localhost:127.0.0.1
* 默认网站应用存放的位置为:webapps

~~~xml
-<Host name="localhost" autoDeploy="true" unpackWARs="true" appBase="webapps">
~~~

> 3、拓展

网站是如何访问的?

* 输入一个域名,回车

* 检查本机的C:\Windows\System32\drivers\etc\hosts配置文件下有没有这个域名映射

  * 有:直接返回对应的ip地址,在这个地址中,有我们需要访问的web程序,可以直接访问

  ![image-20211126162804558](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126162804558.png)

  * 没有:去DNS服务器找,找到的话就返回,找不到就返回找不到

![image-20211126162904539](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126162904539.png)

* hosts配置原理图



### 3.3 发布一个web网站

> 1、概述

将自己写的网站，放到服务器（Tomcat）中指定的web应用的文件夹（webapps）下，就可以访问了！！！

**网站应该有的结构**

~~~properties
--webapps:Tomcat服务器的web目录
	--ROOT
	--happy：网站的目录名
		--WEB-INF
			--classes：java程序
			--lib：web应用所依赖的jar包
			--web.xml：网站配置文件
		--index.html 默认的首页
		--static
			--css
				--style.css
			--js
			--img
		--......
~~~

> 2、步骤

1. webapps:

![image-20211126164956390](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126164956390.png)

2. happy:

![image-20211126165014190](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126165014190.png)

3. 启动web.xml:

![image-20211126165111306](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211126165111306.png)

> **3、重点：**

* HTTP协议

* Maven：构建工具

* Servlet： Web 服务器\应用服务器上的程序



## 4. HTTP

### 4.1 什么是http

> 1、概述

HTTP（超文本传输协议，Hyper Text Transfer Protocol）是一个简单的请求-响应协议，它通常运行在[TCP](https://baike.baidu.com/item/TCP/33012)之上。（80端口）

* 文本：html，字符串...
* 超文本：图片，音乐，视频，定位，地图......

https：安全的（443端口）



### 4.2 http请求

> 1、运行原理

* 客户端—— 发请求（Request）——服务器

举例：百度

~~~properties
Request URL: https://www.baidu.com/		//请求地址
Request Method: GET		//get方法、post方法
Status Code: 200 OK		//状态码：200
Remote Address: 14.215.177.39:443		//远程服务器地址
~~~

~~~properties
Accept: text/html
Accept-Encoding: gzip,deflate, br
Accept-Language: zh-CN,zh;q=0.9		//语言
Cache-Control: max-age=0
Connection: keep-alive
~~~

> 2、请求行

* 请求方式：**GET，POST**，HEAD，DELETE，PUT，TRACT...
  * get：请求能够携带的参数比较少，大小有限制，会在浏览器的URL地址栏显示数据内容，不安全，但高效
  * post：请求能够携带的参数没有限制，大小没有限制，不会在浏览器的URL地址栏显示数据内容，安全，但不高效

>3、消息头

~~~properties
Accept: 告诉浏览器，它所支持的数据类型
Accept-Encoding: 支持哪种编码格式	GBK UTF-8 GB2312 ISO8859-1
Accept-Language:  告诉浏览器，它的语言环境
Cache-Control: 缓存控制
Connection:  告诉浏览器，请求完成是断开还是保持连接
Host:  主机
~~~



### 4.3 http相应

> 1、运行原理

* 服务器——响应（response）——客户端

举例：百度：

~~~properties
Cache-Control: private	//缓存控制
Connection: keep-alive	//连接
Content-Encoding: gzip	//编码
Content-Type: text/html;charset=utf-8	//类型
~~~

> 2、响应体

~~~properties
Accept: 告诉浏览器，它所支持的数据类型
Accept-Encoding: 支持哪种编码格式	GBK UTF-8 GB2312 ISO8859-1
Accept-Language:  告诉浏览器，它的语言环境
Cache-Control: 缓存控制
Connection:  告诉浏览器，请求完成是断开还是保持连接
Host:  主机
Refresh: 告诉客户端，多久刷新一次
Location: 让网页重新定位    
~~~

>3、响应状态码(*)

200：请求响应成功

3xx：请求重定向

* 重定向：你重新到我给你新位置去

4xx：找不到资源 404

* 资源不存在

5xx：服务器代码错误 502：网关错误

​	

## 5. Maven

### 5.1 什么是Maven

> 1、项目架构管理工具

我们目前用来就是方便导入jar包

Maven的核心思想：约定大于配置

* 有约束，不要去违反

Maven会规范好你该如何去编写我们的java代码，必须去按照这个规范来！



### 5.2 配置环境

> 1、系统变量

![image-20211127102422414](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127102422414.png)

> 2、Path变量

![image-20211127172154504](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127172154504.png)

> 3、测试是否配置成功

~~~properties
//cmd
C:\Users\koko>mvn -version

Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: D:\Java_Tools\maven\apache-maven-3.8.4
Java version: 16.0.2, vendor: Oracle Corporation, runtime: D:\jdk-16.0.2
Default locale: zh_CN, platform encoding: GBK
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
~~~



### 5.3 阿里云镜像

> 1、概述

* 镜像：mirrors
  * 作用：加速我们的下载
* 国内建议使用阿里云

maven包下的conf中的setting.xml

~~~xml
//网上查
<mirror>
    <id>aliyunmaven</id>
    <mirrorOf>*</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
</mirror>
~~~

> 2、本地仓库

* **建立一个本地仓库**：localRepository

~~~xml
//在settings配置地址下
<localRepository>D:\Java_Tools\maven\apache-maven-3.8.4\maven-repo</localRepository>
~~~



### 5.4 IDEA中使用Maven

> 1、步骤

1. 创建一个Maven项目

![image-20211127103535872](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127103535872.png)

2. 配置信息

![image-20211127103535872](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127103535872-16380049499711.png)

3. 环境变量

![image-20211127103535872](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127103535872-16380049535582.png)

> 2、IDEA中的Maven设置

1. 干净的Maven文项目

![image-20211127172401840](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127172401840.png)

2. Maven的初始文件（web应用才有）

![image-20211127172433703](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127172433703.png)

3. 标记文件夹的功能（*）

![image-20211127172817443](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127172817443.png)



### 5.5 IDEA中使用Tomcat

> 1、步骤

1. 配置Tomcat

![image-20211127173231061](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127173231061.png)

![image-20211127174024841](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127174024841.png)

2. 运行项目

![image-20211127174559169](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127174559169.png)



### 5.6 pom.xml

> 1、概述

* pom.xml是Maven的核心配置文件

![image-20211127225403652](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127225403652.png)

~~~xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.koko</groupId>
  <artifactId>first_maven</artifactId>
  <version>1.0-SNAPSHOT</version>

  <dependencies>
    <!--具体依赖的jar包配置文件-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>

    <!--Maven的高级在于，他会自动帮你导入jar包所依赖的其他jar-->
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.13</version>
    </dependency>

  </dependencies>
</project>
~~~

![image-20211127232120780_LI](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127232120780_LI.jpg)

1. Maven由于他的约定大于配置，我们之后可能会遇到我们写的配置文件无法被导出或者生效的问题，解决方案：
   * 上网查Maven配置导出失败问题

~~~xml
<!--在build中配置resources，来防止我们的资源导出失败问题-->
  <build>
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
      </resource>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
      </resource>
    </resources>
  </build>
~~~

> 2、IDEA小操作

* Maven中jar包的联系关联图

![image-20211127233448728](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211127233448728.png)



### 5.7 常见问题

> 1、自动配置好文件存储路径

![image-20211129164924573](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211129164924573.png)

> 2、导入tomcat问题

![image-20211129165643779](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211129165643779.png)

* ！！！处：端口号，localhost8080:/second_hello 访问网页

![image-20211129165718490](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211129165718490.png)

> 3、maven默认web项目中的web.xml版本问题

![image-20211129170246345](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211129170246345.png)

* idea中的版本太老

解决方案：

* 将tomcat中的默认web.xml配置文件导入idea中

![image-20211129170413009](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211129170413009.png) 

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">
</web-app>
~~~



### 5.8 maven仓库

maven仓库：https://mvnrepository.com/

> 1、找到你要使用的jar包

![image-20211129222737963](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211129222737963.png)

> 2、将配置文件复制粘贴到项目的porm文件中

![image-20211129222817322](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211129222817322.png)

> 3、复制到pom.xml中

![image-20211129222928364](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211129222928364.png)



## 6. Servlet

### 6.1 Servlet简介

> 1、Servlet就是sun公司开发动态web的一门技术

* Sun在这些API提供一个接口叫做：Servlet。如果你想开发一个Servlet程序，只需要完成两个小步骤：
  * 编写一个类，实现Servlet接口
  * 把开发好的Java类部署到web服务器中

**把实现了Servlet接口的Java程序叫做Servlet**



### 6.2 HelloServlet

> 1、概述

1. Servlet接口Sun公司有两个默认的实现类：HttpServlet，GenericServlet

> 2、步骤

1. 构建一个普通的Maven项目，删除里面的src目录，以后在本项目中创建Module，这个空项目就是Maven的主项目

   * 关于Maven父子工程的理解：

   * 父项目会有：

     ```xml
     <modules>
         <module>servlet-01</module>
     </modules>
     ```

   * 子项目会有：

     ```xml
     <parent>
         <artifactId>first-Servlet</artifactId>
         <groupId>org.koko</groupId>
         <version>1.0-SNAPSHOT</version>
     </parent>
     ```

**父项目的java子项目可以直接使用，相当于继承**

![image-20211130092110069](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130092110069-16382353371191.png)

2. Maven环境优化
   * 修改web.xml为最新
   * 将maven的结构搭建完整

3. 编写一个Servlet程序
   * 编写一个普通类
   * 实现Servlet接口，继承HttpServlet

~~~java
public class HelloServlet extends HttpServlet {
    //由于get或者post只是请求实现不同方式，可以相互调用，业务逻辑一样
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter(); //响应流
        writer.print("hello,Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
~~~

4. 编写Servlet的映射

为什么需要映射：我们写的是Java程序，但是要通过浏览器访问，而浏览器需要连接web服务器，所以我们需要再web服务中注册我们写的Servlet，还需要给他一个浏览器能够访问的路径；

~~~xml
<!--注册Servlet-->
    <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.koko.servlet.HelloServlet</servlet-class>
    </servlet>
    
<!--Servlet的请求路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/koko</url-pattern>
    </servlet-mapping>
~~~

5. 配置Tomcat（略）

* 注意项目发布的路径即可

![image-20211130144639010](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130144639010.png)

> 3、运行

![image-20211130144914268](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130144914268.png)

![image-20211130144937117](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130144937117.png)



### 6.3 Servlet原理

> 1、概述

* Servlet是由Web服务器调用，Web服务器在收到浏览器请求后：

![image-20211130145137715](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130145137715.png)



### 6.4 Mapping问题

> 1、Mapping性质

1. 一个Servlet可以指定一个映射路径

~~~xml
<!--注册Servlet-->
    <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.koko.servlet.HelloServlet</servlet-class>
    </servlet>

    <!--Servlet的请求路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/koko</url-pattern>
    </servlet-mapping>
~~~

2. 一个Servlet可以指定多个映射路径

~~~xml
<!--注册Servlet-->
    <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.koko.servlet.HelloServlet</servlet-class>
    </servlet>

    <!--Servlet的请求路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/k1</url-pattern>
    </servlet-mapping>

    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/k2</url-pattern>
    </servlet-mapping>

    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/k3</url-pattern>
    </servlet-mapping>

    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/k4</url-pattern>
    </servlet-mapping>
~~~

3. 一个Servlet可以指定通用映射路径

~~~xml
<!--Servlet的请求路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/k1/*</url-pattern>
    </servlet-mapping>
~~~

4. 默认请求路径

~~~xml
<!--Servlet的请求路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>
~~~

5. 指定一些后缀或者前缀等...

~~~xml
<!--注意：*前面不能加项目映射的路径
例：hello/*.happy
-->
<!--Servlet的请求路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>*.happy</url-pattern>
    </servlet-mapping>
~~~

6. 优先级问题

* 指定了固有的映射路径优先级最高，如果找不到就会走默认的处理请求

~~~java
//ErrorServlet类
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer=resp.getWriter(); //响应流
        writer.print("<h1>404</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

//web.xml中的配置信息
<servlet>
        <servlet-name>error</servlet-name>
        <servlet-class>com.koko.servlet.ErrorServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>error</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>
~~~



### 6.5 ServletContext

> 1、概述

* web容器在启动的时候，它会为每一个web程序都创建一个对应的ServletContext对象，它代表了当前的web应用

> 2、基本原理（类似网络编程）

![image-20211130154807742](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130154807742.png)

> 3、共享数据

1. 这个Servlet中保存的数据，可以在另一个Servlet中拿到

~~~java
//相当于客户端
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=this.getServletContext();  //Servlet上下文
        String username="小明";
        context.setAttribute("username",username);  //将数据保存在ServletContext中
    }
}

//相当于服务器端
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=this.getServletContext();  //Servlet上下文
        String username= (String) context.getAttribute("username");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("姓名："+username);
    }
}
~~~

2. web.xml配置文件

~~~xml
<servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.koko.servlet.HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>get</servlet-name>
        <servlet-class>com.koko.servlet.GetServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>get</servlet-name>
        <url-pattern>/get</url-pattern>
    </servlet-mapping>
~~~

3. 测试

* 当先进入GetServlet时：没能获取数据

![image-20211130154357572](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130154357572.png)

* 当先进入HelloServlet拿到数据后，再在进入GetServlet时：

![image-20211130154602409](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130154602409.png)

> 4、获取初始化参数

~~~xml
<!--配置一些web应用初始化参数-->
    <context-param>
        <param-name>url</param-name>
        <param-value>jdbc:mysql://localhost:3306/mybatis</param-value>
    </context-param>

<servlet>
        <servlet-name>gp</servlet-name>
        <servlet-class>com.koko.servlet.ServletDemo01</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>gp</servlet-name>
        <url-pattern>/gp</url-pattern>
    </servlet-mapping>
~~~

~~~java
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        String url= context.getInitParameter("url");
        resp.getWriter().print(url);
    }
~~~

![image-20211130211858786](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130211858786.png)

> 5、请求转发

~~~xml
//注册与请求路径
<servlet>
        <servlet-name>sd2</servlet-name>
        <servlet-class>com.koko.servlet.ServletDemo02</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>sd2</servlet-name>
        <url-pattern>/sd2</url-pattern>
    </servlet-mapping>
~~~

~~~java
public class ServletDemo02 extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        System.out.println("进入了ServletDemo01");
        context.getRequestDispatcher("/gp").forward(req,resp);  //调用请求转发的路径
    }
}
~~~

![image-20211130212313942](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130212313942.png)

* 转发操作（相应状态码仍为200）

![image-20211130212154684](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130212154684.png)

* 注：上面为转发，下面为重定向

> 6、读取资源文件

Properties

* 在java目录下新建properties
* 在resources目录下新建properties

发现：都被打包到了同一个路径下：classes（俗称：classpath）

思路：需要一个文件流；

~~~xml
//web.xml 
<servlet>
        <servlet-name>sd3</servlet-name>
        <servlet-class>com.koko.servlet.ServletDemo03</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>sd3</servlet-name>
        <url-pattern>/sd3</url-pattern>
</servlet-mapping>

//还需要在pom.xml中配置resources
 <!--在build中配置resources，来防止我们的资源导出失败问题-->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
~~~

~~~properties
//resources中配置db.properties文件
username=root
password=123456
~~~

~~~java
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties prop = new Properties();
        prop.load(is);
        String user = prop.getProperty("username");
        String pwd = prop.getProperty("password");

        resp.getWriter().print(user+":"+pwd);
    }
}
~~~

![image-20211130215452091](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130215452091.png)

* 跳转到工具类找信息

![image-20211130215508116](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130215508116.png)



### 6.6 HttpServletResponse

> 1、概述

* web服务器接收到客户端的http请求，针对这个请求，分别创建一个代表请求的HttpServletRequest对象，代表响应的一个HttpServletResponse；
  * 如果要获取客户端请求过来的参数：找HttpServletRequest
  * 如果要给客户端响应一些信息：找HttpServletResponse



#### 6.6.1 简单分类

> 概述

1. 负责想浏览器发送数据的方法

~~~java
ServletOutputStream getOutputStream() throws IOException;

PrintWriter getWriter() throws IOException;
~~~

2. 负责想浏览器发送数据的方法

~~~java
void setCharacterEncoding(String var1);

void setContentLength(int var1);

void setContentLengthLong(long var1);

void setContentType(String var1);
~~~



#### 6.6.2 下载文件

> 1、步骤

1. web.xml

~~~xml
//web.xml
    <servlet>
        <servlet-name>down</servlet-name>
        <servlet-class>com.koko.servlet.FileServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>down</servlet-name>
        <url-pattern>/down</url-pattern>
    </servlet-mapping>
~~~

2. FileServlet

```java
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、要获取下载文件的路径
        String realPath="E:\\专业资料\\project_Java\\second-maven\\first-Servlet\\response\\src\\main\\resources\\1.png";
        System.out.println("下载文件的路径："+realPath);

        //2、下载的文件名是啥？
        String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);

        //3、让浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        //4、获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5、创建缓冲区
        int len=0;
        byte[] buffer = new byte[1024];

        //6、获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();

        //7、将FileOutputStream流写入到buffer缓冲区
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

>2、测试

1. 载入down文件地址，输出下载提示

![image-20211130223559777](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130223559777.png)

![image-20211130223619425](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211130223619425.png)



#### 6.6.3 验证码功能

> 1、实现方法

* 前端实现（JS）
* 后端实现，需要用到Java的图片类，生成一个图片

> 2、步骤

1. web.xml

~~~xml
//web.xml
    <servlet>
        <servlet-name>ImageServlet</servlet-name>
        <servlet-class>com.koko.servlet.ImageServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ImageServlet</servlet-name>
        <url-pattern>/image</url-pattern>
    </servlet-mapping>
~~~

2. ImageServlet

```java
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //浏览器3秒刷新一次
        resp.setHeader("refresh","3");

        //在内存中创建一个照片，并得到图片
        BufferedImage image=new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        //设置背景及写数据
        g.setColor(Color.WHITE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        //告诉浏览器图片的打开方式
        resp.setContentType("image/jpeg");
        //不让浏览器存在缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    //生成随机数
    private String makeNum(){
        Random r=new Random();
        String num = r.nextInt(9999999)+"";
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<7-num.length();i++){
            sb.append("0");
        }
        num=sb.toString()+num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

> 3、测试

1. 网站输出：

![image-20211201091908480](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201091908480.png)

![image-20211201091838055](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201091838055.png)



#### 6.6.4 实现重定向（*）

> 1、原理图

![image-20211201092404259](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201092404259.png)

* 重定向：一个web资源（B）收到客户端（A）的请求后，（B）会通知客户端（A）去访问另一个web资源（C）

> 2、简单跳转实现重定向的方法

~~~java
void sendRedirect(String var1) throws IOException;
~~~

> 3、步骤

1. web.xml

~~~xml
//web.xml
<servlet>
        <servlet-name>RedirectServlet</servlet-name>
        <servlet-class>com.koko.servlet.RedirectServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>RedirectServlet</servlet-name>
        <url-pattern>/red</url-pattern>
    </servlet-mapping>
~~~

2. RedirectServlet

```java
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //302
        resp.sendRedirect("/response/image");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

//就会跳转到验证码功能的页面去
输入/red就会跳转到/image中
```

> 4、拓展

面试题：重定向与转发的区别？

相同点：

* 页面都会跳转

不同点：

* 请求转发的时候，url地址不会发生改变（307）
* 请求重定向的时候，url地址会发生改变（302）

> 5、登录跳转实现重定向

1. web.xml

~~~xml
//web.xml
<servlet>
    <servlet-name>RequestTest</servlet-name>
    <servlet-class>com.koko.servlet.RequestTest</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>RequestTest</servlet-name>
    <url-pattern>/login</url-pattern>
</servlet-mapping>
~~~

2. RequestTest

```java
public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username+":"+password);

        //重定向,注意地址问题，否则404
        resp.sendRedirect("success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

3. index.jsp

~~~jsp
//index.jsp
<html>
<body>
<h2>Hello World!</h2>

<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
</form>

</body>
</html>
~~~

> 6、测试

* 乱码问题先不管！

![image-20211201101636557](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201101636557.png)

* 跳转到另一个jsp页面

![image-20211201101644490](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201101644490.png)



### 6.7 HttpServletRequest

> 1、概述

* HttpServletRequest代表客户端的请求，用户通过Http协议访问服务器，Http请求中的所有信息都会被封装到HttpServletRequest，通过这个HttpServletRequest的方法，获取客户端的信息

> 2、获取参数，请求转发

![image-20211201111853258](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201111853258.png)

> 3、步骤

* 实现客户端获取数据，并跳转页面

1. web.xml

~~~xml
//web.xml
<servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>com.koko.servlet.LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
~~~

2. index.html

```html
//index.html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<%--<div style="text-align: center">居中,html知识--%>
<div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type="checkbox" name="hobbies" value="girl">女孩
        <input type="checkbox" name="hobbies" value="code">代码
        <input type="checkbox" name="hobbies" value="sing">唱歌
        <input type="checkbox" name="hobbies" value="movie">电影
        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
```

3. LoginServlet

~~~java
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设定默认编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("============");
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobbies));
        System.out.println("============");

        req.getRequestDispatcher("success.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
~~~

> 4、测试

1. 填写数据

![image-20211201112441512](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201112441512.png)

2. 重定向跳转页面，url地址发生改变（302）

![image-20211201112451031](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201112451031.png)

3. 控制台输出客户端（request）数据

![image-20211201112504330](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211201112504330.png)



## 7. Cookie与Session

### 7.1 会话

> 1、概述

用户打开一个浏览器，点击了很多超链接，访问多个web资源，关闭浏览器，这个过程可以叫做会话；

**有状态会话**：你来过网站，下次再来，网站就会记得你曾经来过；

**一个网站，怎么证明你来过？**

客户端			服务端

1. 服务端给客户端一个信件，客户端下次访问服务端带上信件即可；（Cookie）

2. 服务器登记你来过了，下次你来的时候就匹配你；（Session）



### 7.2 保存会话的两种技术

> **1、cookie**

* 客户端技术（响应，请求）

> **2、session**

* 服务端技术，利用这个技术，可以保存用户的会话信息，我们可以把信息或者数据放在Session中

常见示例：网站登录后，下次不用再登录，第二次访问直接成功！



### 7.3 Cookie

> 1、原理图

![image-20211202151838459](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211202151838459.png)

1. 从请求中拿到Cookie信息

2. 服务器响应给客户端Cookie

~~~java
Cookie[] cookies = req.getCookies(); //获得Cookie
Cookie cookie=cookies[i]; //遍历Cookie
cookie.getName();	//获得Cookie的key
cookie.getValue();	//获得Cookie的value
new Cookie("lastLoginTime",System.currentTimeMillis()+"");	//新建一个Cookie
cookie.setMaxAge(24*60*60);	//设置Cookie的有效期
resp.addCookie(cookie);	//响应给客户端一个Cookie
~~~

**Cookie：一般会保存在本地的用户目录下 appdata；**

> 2、一个网站Cookie是否存在上限！

* 一个Cookie只能保存一个信息
* 一个web站点可以给浏览器发送多个Cookie，做多存放20个Cookie
* Cookie大小有限制：4kb
* 浏览器的上限：300个Cookie

> 3、删除Cookie

* 不设置有效期，关闭浏览器，自动失效
* 设置有效期时间为0；

~~~java
cookie.setMaxAge(0);	//设置Cookie的有效期为0
~~~

> 4、编码与解码（拓展）

* 可以解决大部分乱码问题

~~~java
URLEncoder.encode("小明","UTF-8");	//编码
URLDecoder.decode(cookie.getValue(),"UTF-8");	//解码
~~~



### 7.4 Session（*）

> 1、原理图

![image-20211202152151268](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211202152151268.png)

> 2、概述

1. 什么是Session：

* 服务器给每个用户（浏览器）创建一个Session对象
* 一个Session独占一个浏览器，只要浏览器没有关闭，这个Session就存在
* 用户登录之后，整个网站它都可以访问！——>保存用户的信息：bilibili登录后可以点击收藏页面等等，不用再进行登录存在！

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211202150718341.png" alt="image-20211202150718341" style="zoom: 67%;" />

2. Session与Cookie的区别：

* Cookie是把用户的数据写给浏览器，浏览器保存（可以保存多个）
* Session是把用户的数据写到用户独占的Session中，服务器端保存（保存重要的信息，减少服务器资源的浪费）
* Session对象由服务端创建

> 3、使用场景

* 保存一个登录用户的信息
* 购物车的信息
* 在整个网站中经常会使用的数据，保存到Session中

> 4、步骤：会话自动过期

1. web.xml场景

~~~xml
<!--设置Session默认的失效时间-->
<session-config>
    <!--15分钟后Session自动失效-->
    <session-timeout>15</session-timeout>
</session-config>
~~~

2. SessionDemo01

~~~java
//使用Session：
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   
        //解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        
        //得到Session
        HttpSession session = req.getSession();
        //给Session中存东西
        session.setAttribute("name",new Person("秦疆",1));
        //获取Session的ID
        String sessionId = session.getId();

        //判断Session是不是新创建
        if (session.isNew()){
            resp.getWriter().write("session创建成功,ID:"+sessionId);
        }else {
            resp.getWriter().write("session以及在服务器中存在了,ID:"+sessionId);
        }

        //Session创建的时候做了什么事情；
//        Cookie cookie = new Cookie("JSESSIONID",sessionId);
//        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

//SessionDemo02
//得到Session
HttpSession session = req.getSession();
Person person = (Person) session.getAttribute("name");
System.out.println(person.toString());

//SessionDemo03
HttpSession session = req.getSession();
session.removeAttribute("name");
//手动注销Session
session.invalidate();
~~~

> 5、测试

1. 显示初session的id

![image-20211203154349607](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211203154349607.png)

* SessionDemo03销毁后，SessionDemo01重新出现一个Session



## 8. JSP

> 1、概述

Java Server Pages：Java服务器端页面，也和Servlet一样，用于动态Web技术！

> 2、特点：

* 写JSP就像在写HTML
* 区别：
  * HTML只给用户提供静态数据
  * JSP页面可以嵌入Java代码，为用户提供动态数据



### 8.1 JSP原理

> 1、探讨JSP的运行流程

* 服务器内部工作
  * tomcat中有一个work目录
  * IDEA中使用Tomcat会在IDEA的Tomcat中产生一个work目录

~~~properties
C:\Users\koko\AppData\Local\JetBrains\IntelliJIdea2020.2\tomcat\Unnamed_first-Servlet\work\Catalina\localhost\request\org\apache\jsp
~~~

* 发现页面转变成了Java程序！

![image-20211202153205668](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211202153205668.png)

* **浏览器向服务器发送请求，不管访问什么资源，其实都是在访问Servlet**

* JSP最终也会被转换成一个Java类！

~~~java
//初始化
public void _jspInit() {
  }
//销毁
public void _jspDestroy() {
  }
//JSPService
public void _jspService(HttpServletRequest request, HttpServletResponse response)
~~~

> 2、内置一些对象

~~~java
final javax.servlet.jsp.PageContext pageContext;//页面上下文
javax.servlet.http.HttpSession session = null;//session
final javax.servlet.ServletContext application;//applicationContext
final javax.servlet.ServletConfig config;//config
javax.servlet.jsp.JspWriter out = null;//out
final java.lang.Object page = this;//page：当前
HttpServletRequest request//请求
HttpServletResponse response//响应
~~~

> 3、输出页面前添加的代码

~~~java
response.setContentType("text/html;charset=UTF-8"); //设置响应页面的类型
pageContext = _jspxFactory.getPageContext(this, request, response,
null, true, 8192, true);
_jspx_page_context = pageContext;
application = pageContext.getServletContext();
config = pageContext.getServletConfig();
session = pageContext.getSession();
out = pageContext.getOut();
_jspx_out = out;
~~~

> 4、原理图

![image-20211202155304851](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211202155304851.png)

注：在JSP页面中

* 主要是Java代码就会原封不动地输出
* HTML代码，就会被转换为：

~~~java
out.write("<html>\r\n");
~~~

这样的格式，输出到前端！



### 8.2 JSP基础语法

* 任何语言都有自己的语法，JAVA中有。 JSP 作为java技术的一种应用，它拥有一些自己扩充的语法（了解，知道即可！），Java所有语法都支持！

> 1、风格

~~~jsp
<%%>	//片段
<%=%>	//表达式输出值
<%!%>	//全局变量
<%----%>	//注释
~~~

> 2、JSP表达式

~~~java
  <%--JSP表达式
  作用：用来将程序的输出，输出到客户端
  <%= 变量或者表达式%>
  --%>
  <%= new java.util.Date()%>
~~~

> 3、脚本片段

~~~java
<%--jsp脚本片段--%>
  <%
    int sum = 0;
    for (int i = 1; i <=100 ; i++) {
      sum+=i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
  %>
~~~

> 4、在代码嵌入HTML元素

~~~java
  <%
    for (int i = 0; i < 5; i++) {
  %>
    <h1>Hello,World  <%=i%> </h1>
  <%
    }
  %>
~~~

> 5、JSP声明

~~~jsp
  <%!
    static {
      System.out.println("Loading Servlet!");
    }

    private int globalVar = 0;

    public void kuang(){
      System.out.println("进入了方法Kuang！");
    }
  %>
~~~

* JSP声明：会被编译到JSP生成Java的类中！其他的，就会被生成到_jspService方法中！

注：JSP的注释，不会在客户端显示，HTML就会！（安全）



### 8.3 JSP指令

> 1、概述

~~~jsp
<%@page args.... %>
<%@include file=""%>


<%--@include
    会将两个页面合二为一
    --%>
<%@include file="common/header.jsp"%>
<h1>网页主体</h1>
<%@include file="common/footer.jsp"%>

<hr>

<%--jSP标签
    jsp:include：拼接页面，本质还是三个
    --%>(建议使用)
<jsp:include page="/common/header.jsp"/>
<h1>网页主体</h1>
<jsp:include page="/common/footer.jsp"/>
~~~



### 8.4 9大内置对象

> 1、概述

- **PageContext  存东西**
- **Request  存东西**
- **Session  存东西**
- **Application 【SerlvetContext】  存东西**
- Response
- out
- exception
- config 【SerlvetConfig】（几乎不用）
- page （不用了解）

注：只关注重点的！

> 2、四大作用域

~~~java
pageContext.setAttribute("name1","秦疆1号"); //保存的数据只在一个页面中有效
request.setAttribute("name2","秦疆2号"); //保存的数据只在一次请求中有效，请求转发会携带这个数据
session.setAttribute("name3","秦疆3号"); //保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
application.setAttribute("name4","秦疆4号");  //保存的数据只在服务器中有效，从打开服务器到关闭服务器

//从底层到高层
pageContext.findAttribute("namex");
~~~

> 3、原理图

![image-20211203161135026](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211203161135026.png)

![image-20211204214013256](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211204214013256.png)

* request：客户端向服务器发送请求，产生的数据，用户看完就没用了，比如：新闻，用户看完没用的！
* session：客户端向服务器发送请求，产生的数据，用户用完一会还有用，比如：购物车；
* application：客户端向服务器发送请求，产生的数据，一个用户用完了，其他用户还可能使用，比如：聊天数据；



### 8.5 EL表达式、JSP标签、JSTL标签

> 1、概述

~~~xml
<!-- JSTL表达式的依赖 -->
<dependency>
    <groupId>javax.servlet.jsp.jstl</groupId>
    <artifactId>jstl-api</artifactId>
    <version>1.2</version>
</dependency>
<!-- standard标签库 -->
<dependency>
    <groupId>taglibs</groupId>
    <artifactId>standard</artifactId>
    <version>1.1.2</version>
</dependency>
~~~

> 2、EL表达式： ${ }

- **获取数据**
- **执行运算**
- **获取web开发的常用对象**

>3、JSP标签

~~~java
<%--jsp:include--%>

<%--
相当于http://localhost:8080/jsptag.jsp?name=kuangshen&age=12
--%>

<jsp:forward page="/2.jsp">
    <jsp:param name="name" value="kuangshen"></jsp:param>
    <jsp:param name="age" value="12"></jsp:param>
</jsp:forward>
    
//2.jsp	取出参数
姓名：<%=request.getParamether("name")%>
年龄：<%=request.getParamether("age")%>    
~~~

> 4、JSTL表达式

1. 常用标签

* JSTL标签库的使用就是为了弥补HTML标签的不足；它自定义许多标签，可以供我们使用，标签的功能和Java代码一样！

作用：

* 格式化标签

* SQL标签

* XML 标签

* 核心标签 （掌握部分）

![image-20211204213953792](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211204213953792.png)

2. JSTL标签库使用步骤

* 引入对应的 taglib

~~~xml
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
~~~

* 使用其中的方法

**在Tomcat 也需要引入 jstl的包，否则会报错：JSTL解析错误**

> 5、JSTL表达式尝使用的标签

1. c：if

```jsp
<head>
    <title>Title</title>
</head>
<body>


<h4>if测试</h4>

<hr>

<form action="coreif.jsp" method="get">
    <%--
    EL表达式获取表单中的数据
    ${param.参数名}
    --%>
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>

<%--判断如果提交的用户名是管理员，则登录成功--%>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="管理员欢迎您！"/>
</c:if>

<%--自闭合标签--%>
<c:out value="${isAdmin}"/>

</body>
```

2. c:choose c:when

~~~jsp
<body>

<%--定义一个变量score，值为85--%>
<c:set var="score" value="55"/>

<c:choose>
    <c:when test="${score>=90}">
        你的成绩为优秀
    </c:when>
    <c:when test="${score>=80}">
        你的成绩为一般
    </c:when>
    <c:when test="${score>=70}">
        你的成绩为良好
    </c:when>
    <c:when test="${score<=60}">
        你的成绩为不及格
    </c:when>
</c:choose>

</body>
~~~

3. c:forEach

~~~xml
<%

    ArrayList<String> people = new ArrayList<>();
    people.add(0,"张三");
    people.add(1,"李四");
    people.add(2,"王五");
    people.add(3,"赵六");
    people.add(4,"田六");
    request.setAttribute("list",people);
%>


<%--
var , 每一次遍历出来的变量
items, 要遍历的对象
begin,   哪里开始
end,     到哪里
step,   步长
--%>
<c:forEach var="people" items="${list}">
    <c:out value="${people}"/> <br>
</c:forEach>

<hr>

<c:forEach var="people" items="${list}" begin="1" end="3" step="1" >
    <c:out value="${people}"/> <br>
</c:forEach>
~~~



## 9. JavaBean

> 1、概述

实体类

JavaBean有特定的写法：

- 必须要有一个无参构造
- 属性必须私有化
- 必须有对应的get/set方法；

一般用来和数据库的字段做映射 ORM；

ORM ：对象关系映射

- 表—>类
- 字段–>属性
- 行记录---->对象

> 2、people表

| id   | name    | age  | address |
| ---- | ------- | ---- | ------- |
| 1    | 秦疆1号 | 3    | 西安    |
| 2    | 秦疆2号 | 18   | 西安    |
| 3    | 秦疆3号 | 100  | 西安    |

~~~java
class People{
    private int id;
    private String name;
    private int id;
    private String address;
}

class A{
    new People(1,"秦疆1号",3，"西安");
    new People(2,"秦疆2号",3，"西安");
    new People(3,"秦疆3号",3，"西安");
}
~~~

> 3、作用

- 过滤器
- 文件上传
- 邮件发送
- JDBC 复习 ： 如何使用JDBC , JDBC crud， jdbc 事务



## 10. MVC三层架构(*)

> 1、什么是MVC？

* Model view Controller 模型、视图、控制器



### 10.1 以前的架构

> 1、原理图

![image-20211204213901531](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211204213901531.png)

* 用户直接访问控制层，控制层就可以直接操作数据库；

~~~properties
servlet--CRUD-->数据库
弊端：程序十分臃肿，不利于维护  
servlet的代码中：处理请求、响应、视图跳转、处理JDBC、处理业务代码、处理逻辑代码

架构：没有什么是加一层解决不了的！
程序猿调用
↑
JDBC （实现该接口）
↑
Mysql Oracle SqlServer ....（不同厂商）
~~~



### 10.2 MVC三层架构

> 1、原理图

![image-20211203175102737](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211203175102737.png)

> 2、三层架构

1. **Model**

- 业务处理 ：业务逻辑（Service）
- 数据持久层：CRUD （Dao - 数据持久化对象）

2. **View**

- 展示数据
- 提供链接发起Servlet请求 （a，form，img…）

3. **Controller （Servlet）**

- 接收用户的请求 ：（req：请求参数、Session信息….）
- 交给业务层处理对应的代码
- 控制视图的跳转

~~~properties
登录
--->接收用户的登录请求
--->处理用户的请求（获取用户登录的参数，username，password）
---->交给业务层处理登录业务（判断用户名密码是否正确：事务）
--->Dao层查询用户名和密码是否正确-->数据库
~~~



## 11. Filter（*）

> 1、概述

比如 Shiro安全框架技术就是用Filter来实现的

**Filter：过滤器 ，用来过滤网站的数据；**

- 处理中文乱码
- 登录验证….

（比如用来过滤网上骂人的话，我***我自己 0-0）

> 2、原理图

![image-20211203210625019](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211203210625019.png)

> 3、Filter开发步骤：

1. 导包

![image-20211203210654679](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211203210654679.png)

2. 编写过滤器CharacterEncodingFilter

* 重写方法即可！

~~~java
 public class CharacterEncodingFilter implements Filter {
      
          //初始化：web服务器启动，就以及初始化了，随时等待过滤对象出现！
          public void init(FilterConfig filterConfig) throws ServletException {
              System.out.println("CharacterEncodingFilter初始化");
          }
      
          //Chain : 链
          /*
          1. 过滤中的所有代码，在过滤特定请求的时候都会执行
          2. 必须要让过滤器继续同行
              chain.doFilter(request,response);
           */
          public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
              request.setCharacterEncoding("utf-8");
              response.setCharacterEncoding("utf-8");
              response.setContentType("text/html;charset=UTF-8");
      
              System.out.println("CharacterEncodingFilter执行前....");
              chain.doFilter(request,response); //让我们的请求继续走，如果不写，程序到这里就被拦截停止！
              System.out.println("CharacterEncodingFilter执行后....");
          }
      
          //销毁：web服务器关闭的时候，过滤器会销毁
          public void destroy() {
              System.out.println("CharacterEncodingFilter销毁");
          }
      }

public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("你好，世界");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
~~~

3. 在web.xml中配置 Filter

~~~xml
<servlet>
    <servlet-name>ShowServlet</servlet-name>
    <servlet-class>com.koko.servlet.ShowServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ShowServlet</servlet-name>
    <url-pattern>/servlet/show</url-pattern>
  </servlet-mapping>

<filter>
       <filter-name>CharacterEncodingFilter</filter-name>
       <filter-class>com.kuang.filter.CharacterEncodingFilter</filter-class>
   </filter>
   <filter-mapping>
       <filter-name>CharacterEncodingFilter</filter-name>
       <!--只要是 /servlet的任何请求，会经过这个过滤器-->
       <url-pattern>/servlet/*</url-pattern>
       <!--<url-pattern>/*</url-pattern>-->
       <!-- 别偷懒写个 /* -->
   </filter-mapping>
~~~



## 12. 监听器

* 实现一个监听器的接口；（有n种监听器）

> 1、步骤：编写一个监听器

实现监听器的接口…

![image-20211203213123174](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211203213123174.png)

1. OnlineCountListener

~~~java
//统计网站在线人数 ： 统计session
public class OnlineCountListener implements HttpSessionListener {

    //创建session监听： 看你的一举一动
    //一旦创建Session就会触发一次这个事件！
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();

        System.out.println(se.getSession().getId());

        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount==null){
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count+1);
        }

        ctx.setAttribute("OnlineCount",onlineCount);

    }

    //销毁session监听
    //一旦销毁Session就会触发一次这个事件！
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();

        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount==null){
            onlineCount = new Integer(0);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count-1);
        }

        ctx.setAttribute("OnlineCount",onlineCount);

    }

    /*
    Session销毁：
    1. 手动销毁  getSession().invalidate();
    2. 自动销毁	
    <session-config>
    <session-timeout>1</session-timeout>
  </session-config>
     */
}
~~~

2. web.xml注册监听器

~~~xml
<!--注册监听器-->
<listener>
    <listener-class>com.kuang.listener.OnlineCountListener</listener-class>
</listener>
~~~

> 2、测试

![image-20211203220316591](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211203220316591.png)

* 看情况是否使用！(一般不使用)



## 13. 过滤器、监听器常见应用

> 1、监听器：GUI编程中经常使用

~~~java
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("中秋节快乐");  //新建一个窗体
        Panel panel = new Panel(null); //面板
        frame.setLayout(null); //设置窗体的布局

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255)); //设置背景颜色

        panel.setBounds(50,50,300,300);
        panel.setBackground(new Color(0,255,0)); //设置背景颜色

        frame.add(panel);

        frame.setVisible(true);

        //监听事件，监听关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });

    }
}
~~~

> 2、用户登录之后才能进入主页！用户注销后就不能进入主页了！

1. 用户登录之后，向Sesison中放入用户的数据
2. 进入主页的时候要判断用户是否已经登录；要求：在过滤器中实现！

~~~java
HttpServletRequest request = (HttpServletRequest) req;
HttpServletResponse response = (HttpServletResponse) resp;

if (request.getSession().getAttribute(Constant.USER_SESSION)==null){
    response.sendRedirect("/error.jsp");
}

chain.doFilter(request,response);
~~~

> 3、测试

1. 启动tomcat

![image-20211205111518303](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211205111518303.png)

2. 当输入不为admin时：（admin以后在数据库中查找）

![image-20211205111544314](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211205111544314.png)

3. 当输入为admin时：

![image-20211205111624477](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211205111624477.png)



## 14. JDBC复习

* 什么是JDBC ： Java连接数据库！

> 1、原理图

![image-20211205115534729](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211205115534729.png)

需要jar包的支持：

- java.sql
- javax.sql
- mysql-connetor-java… 连接驱动（必须要导入）

> **2、步骤：通过maven导包形式测试**

1. 实验环境搭建

~~~mysql
CREATE TABLE users(
    id INT PRIMARY KEY,
    `name` VARCHAR(40),
    `password` VARCHAR(40),
    email VARCHAR(60),
    birthday DATE
);

INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(1,'张三','123456','zs@qq.com','2000-01-01');
INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(2,'李四','123456','ls@qq.com','2000-01-01');
INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(3,'王五','123456','ww@qq.com','2000-01-01');

SELECT	* FROM users;
~~~

2. 导入数据库依赖

~~~xml
<!--mysql的驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
</dependency>
~~~

3. IDEA中连接数据库：

![image-20211205115723434](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211205115723434.png)

4. JDBC 固定步骤：
   * 加载驱动
   * 连接数据库,代表数据库
   * 向数据库发送SQL的对象Statement : CRUD
   * 编写SQL （根据业务，不同的SQL）
   * 执行SQL
   * 关闭连接（先开的后关）

~~~java
public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/ocean_student?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //2.连接数据库,代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.向数据库发送SQL的对象Statement,PreparedStatement : CRUD
        Statement statement = connection.createStatement();

        //4.编写SQL
        String sql = "select * from users";

        //5.执行查询SQL，返回一个 ResultSet  ： 结果集
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()){
            System.out.println("id="+rs.getObject("id"));
            System.out.println("name="+rs.getObject("name"));
            System.out.println("password="+rs.getObject("password"));
            System.out.println("email="+rs.getObject("email"));
            System.out.println("birthday="+rs.getObject("birthday"));
        }

        //6.关闭连接，释放资源（一定要做） 先开后关
        rs.close();
        statement.close();
        connection.close();
    }
}
~~~

5. 预编译SQL

~~~java
public class TestJDBC2 {
    public static void main(String[] args) throws Exception {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/ocean_student?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //2.连接数据库,代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.编写SQL
        String sql = "insert into  users(id, name, password, email, birthday) values (?,?,?,?,?);";

        //4.预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,2);//给第一个占位符？ 的值赋值为1；
        preparedStatement.setString(2,"狂神说Java");//给第二个占位符？ 的值赋值为狂神说Java；
        preparedStatement.setString(3,"123456");//给第三个占位符？ 的值赋值为123456；
        preparedStatement.setString(4,"24736743@qq.com");//给第四个占位符？ 的值赋值为1；
        preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));//给第五个占位符？ 的值赋值为new Date(new java.util.Date().getTime())；

        //5.执行SQL
        int i = preparedStatement.executeUpdate();

        if (i>0){
            System.out.println("插入成功@");
        }

        //6.关闭连接，释放资源（一定要做） 先开后关
        preparedStatement.close();
        connection.close();
    }
}
~~~

> 3、事务

* 要么都成功，要么都失败！

* ACID原则：保证数据的安全。

~~~properties
开启事务
事务提交  commit()
事务回滚  rollback()
关闭事务

转账：
A:1000
B:1000
    
A(900)   --100-->   B(1100)
~~~

> 4、Junit单元测试

1. 导入依赖

~~~xml
<!--单元测试-->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
~~~

2. 生成注解

@Test注解只有在方法上有效，只要加了这个注解的方法，就可以直接运行！

~~~java
@Test
public void test(){
    System.out.println("Hello");
}
~~~

成功时：

![image-20211205120211237](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211205120211237.png)

失败时：

![image-20211205120228215](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20211205120228215.png)

> 5、测试

~~~mysql
CREATE TABLE account(
   id INT PRIMARY KEY AUTO_INCREMENT,
   `name` VARCHAR(40),
   money FLOAT
);

INSERT INTO account(`name`,money) VALUES('A',1000);
INSERT INTO account(`name`,money) VALUES('B',1000);
INSERT INTO account(`name`,money) VALUES('C',1000);
~~~

~~~java
    @Test
    public void test() {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/ocean_student?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection connection = null;

        //1.加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.连接数据库,代表数据库
             connection = DriverManager.getConnection(url, username, password);

            //3.通知数据库开启事务,false 开启
            connection.setAutoCommit(false);

            String sql = "update account set money = money-100 where name = 'A'";
            connection.prepareStatement(sql).executeUpdate();

            //制造错误
            //int i = 1/0;

            String sql2 = "update account set money = money+100 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();

            connection.commit();//以上两条SQL都执行成功了，就提交事务！
            System.out.println("success");
        } catch (Exception e) {
            try {
                //如果出现异常，就通知数据库回滚事务
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
~~~

