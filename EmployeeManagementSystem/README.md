# EmployeeManagementSystem

* 基于SpringBoot框架的员工管理系统（狂神说无数据库版本）


## 1. 导入静态资源

> **1、Web架构目录**

![image-20220305162819248](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305162819248.png)



> **2、配置前端页面（Thymeleaf）**

**注意**：每个页面都配置

![image-20220305162911088](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305162911088.png)

~~~properties
xmlns:th=“http://www.thymeleaf.org”
~~~



> 3、maven导入（pom.xml）

* 导入thymeleaf支持

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```



## 2. 模拟数据库

### **2.1 编写实体类**

![image-20220305163133440](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305163133440.png)

```xml
<!--lombok-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
</dependency>
```

> 1、Department类

```java
package com.koko.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
```

> 2、Employee类

```java
package com.koko.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer sex;
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer sex, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.department = department;
        //默认的创建日期
        this.birth = new Date();
    }

}
```



### 2.2 编写mapper类

* 模拟数据库的数据

![image-20220306090113244](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306090113244.png)

> 1、DepartmentMapper类

```java
package com.koko.dao;

import com.koko.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentMapper {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    //初始化数据
    static{
        departments = new HashMap<>();
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"销售部"));
    }

    //获取所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id获取部门信息
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
```

* 小技巧：Alt+鼠标左键选择多行

> 2、EmployeeMapper类

```java
package com.koko.mapper;

import com.koko.pojo.Department;
import com.koko.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeMapper {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    //员工所属的部门
    @Autowired
    private DepartmentMapper departmentMapper;

    //初始话数据
    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "A2280253534@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "B2280253534@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "C2280253534@qq.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "D2280253534@qq.com", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "E2280253534@qq.com", 0, new Department(105, "销售部")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getEmployeeAll(){
        return employees.values();
    }

    //通过Id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void deleteEmployee(Integer id){
        employees.remove(id);
    }
}
```



### 2.3 登录页实现

![image-20220305163748909](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305163748909.png)

> 1、MyMvcConfig配置类

* 进行视图跳转

```java
package com.koko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
}
```

* 但是现在运行还没有样式，接下来要接管Thymeleaf

> 1、修改404.html

![image-20220305224104091](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305224104091.png)

> 2、修改dashboard.html

![image-20220305224233471](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305224233471.png)

![image-20220306102836628](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306102836628.png)

> 3、修改index.html

![image-20220305224327487](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305224327487.png)

> 4、修改list.html

![image-20220305224423686](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305224423686.png)

> 5、测试

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305224536873.png" alt="image-20220305224536873" style="zoom:50%;" />



## 3. 页面国际化

### 3.1 准备工作

> **1、统一properties编码为UTF-8**

![image-20220305224642788](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305224642788.png)



> **2、编写i18n国际化资源文件**

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615151051237.png)

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615151127497.png)

**以下方式命名**，IDEA会帮我们识别这是个国际化配置包，自动绑定在一起转换成如下的模式：

![image-20220305224822350](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305224822350.png)

> 3、文件操作

1. 然后打开英文或者中文语言的配置文件，点击Resource Bundle进入可视化编辑页面

![image-20220305231641978](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305231641978.png)

2. 进入到可视化编辑页面后，点击加号，添加属性，首先新建一个login.tip代表首页中的提示

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615151337987.png)

3. 然后对该提示分别做三种情况的语言配置，在三个对应的输入框输入即可

（注意：IDEA2020.1可能无法保存，建议直接在配置文件中编写）

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/2021061515135770.png)

4. 然后打开三个配置文件的查看其中的文本内容，可以看到已经做好了全部的配置

> **login.properties：**

~~~properties
login.tip=请登录
login.password=密码
login.remember=记住我
login.btn=登录
login.username=用户名
~~~

>**login_en_US.properties：**

~~~properties
login.tip=Please sign in
login.password=password
login.remember=remember me
login.btn=login
login.username=username
~~~

>**login_zh_CN.properties：**

~~~properties
login.tip=请登录
login.password=密码
login.remember=记住我
login.btn=登录
login.username=用户名
~~~

> **配置yml 配置类中配置**

![image-20220305232143834](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305232143834.png)

~~~yml
server:
  port: 8080
spring:
  thymeleaf:
    cache: false
  messages:
    basename: i18n.login
~~~



### 3.2 配置国际化资源文件名称

> 1、index页面

**1、首页获取显示国际化值：**

![image-20220306093447202](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306093447202.png)

**重启项目，访问首页，可以发现已经自动识别为中文！**

* 不用看上面的图，直接复制下面代码

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>Signin Template for Bootstrap</title>
   <!-- Bootstrap core CSS -->
   <link th:href="@{/css/bootstrap.min.css}" rel="stylesheet">
   <!-- Custom styles for this template -->
   <link th:href="@{/css/signin.css}" rel="stylesheet">
</head>

<body class="text-center">
<form class="form-signin" th:action="@{/login}">
   <img class="mb-4" th:src="@{/img/bootstrap-solid.svg}" alt="" width="72" height="72">
   <h1 class="h3 mb-3 font-weight-normal" th:text="#{login.tip}">Please sign in</h1>
   <input type="text" class="form-control" name="username" th:placeholder="#{login.username}" required="" autofocus="">
   <input type="password" class="form-control" name="password" th:placeholder="#{login.password}" required="">
   <div class="checkbox mb-3">
      <label>
         <input type="checkbox" value="remember-me">[[#{login.remember}]]
      </label>
   </div>
   <button class="btn btn-lg btn-primary btn-block" type="submit">[[#{login.btn}]]</button>
   <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
   <a class="btn btn-sm" th:href="@{/index.html(l='zh_CN')}">中文</a>
   <a class="btn btn-sm" th:href="@{/index.html(l='en_US')}">English</a>
</form>
</body>

</html>
```



### 3.3 配置国际化组件实现中英文切换

> 1、index.html

**1. 添加中英文切换标签链接**

~~~html
<a class="btn btn-sm">中文</a>
<a class="btn btn-sm">English</a>
~~~

**2. 然后这两个标签上加上跳转链接并带上相应的参数：**

~~~html
<a class="btn btn-sm" th:href="@{/index.html(l='zh_CN')}">中文</a>
<a class="btn btn-sm" th:href="@{/index.html(l='en_US')}">English</a>
~~~

![image-20220305232645540](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305232645540.png)



> 2、自定义地区解析器组件：

怎么实现我们自定义的地区解析器呢？我们首先来分析一波源码

在[Spring](https://so.csdn.net/so/search?q=Spring&spm=1001.2101.3001.7020)中有关于国际化的两个类：

Locale：代表地区，每一个Locale对象都代表了一个特定的地理、政治和文化地区 LocaleResolver：地区解析器

* **config包下新建MyLocaleResolver**
* **作为自己的国际化地区解析器**

![image-20220305232744227](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305232744227.png)

**我们在index.html中，编写了对应的请求跳转**

如果点击中文按钮，则跳转到/index.html(l=‘zh_CN’)页面
		如果点击English按钮，则跳转到/index.html(l=‘en_US’)页面

> **1、MyLocaleResolver解析器类**

```java
package com.koko.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        //获取请求中的语言参数
        String language = request.getParameter("l");

        //如果为空走默认
        Locale locale = Locale.getDefault();

        //如果请求链接携带国际化参数
        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            //国家，地区
            locale = new Locale(split[0], split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
```

> 2、MyMvcConfig配置类

**为了让我们的区域化信息能够生效，我们需要再配置一下这个组件！在自己的MvcConofig配置类下添加bean；**

![image-20220306093158808](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306093158808.png)

```java
//自定义的国际化组件生效
@Bean
public LocaleResolver localeResolver() {
    return new MyLocaleResolver();
}
```

**我们重启项目，来访问一下，发现点击按钮可以实现成功切换！
点击中文按钮，跳转到http://localhost:8080/index.html?l=zh_CN，显示为中文**

> 1、中文页面

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305233054916.png" alt="image-20220305233054916" style="zoom:50%;" />

> 2、英文页面

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305233115013.png" alt="image-20220305233115013" style="zoom:50%;" />



## 4. 登录功能实现

### 4.1 页面跳转

> 1、index.html

**在index.html中的表单编写一个提交地址/login，并给名称和密码输入框添加username和password属性为了后面的传参**

![image-20220306093600851](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306093600851.png)

> 2、LoginController控制类

**然后编写对应的controller**

![image-20220305233446265](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305233446265.png)

```java
package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        //如果用户名和密码正确
        if (username.equals("admin") && password.equals("123456")) {
            //跳转到dashboard页面
            return "dashboard";
        } else { //如果用户名或者密码不正确
            //显示错误信息
            model.addAttribute("msg","用户名或密码错误");
            //跳转到首页
            return "index";
        }
    }

}
```

> 3、index.html补充

**在index.html首页中加一个标签用来显示controller返回的错误信息**

![image-20220306101614095](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306101614095.png)

~~~html
<!--如果用户为空，则不显示-->
    <p style="color: red" th:text="${msg}" th:if="${not #strings.isEmpty(msg)}"></p>
~~~

> 4、测试1

**localhost:8080**
		页面展示：

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305233801430.png" alt="image-20220305233801430" style="zoom:50%;" />

浏览器url为http://localhost:8080/user/login?username=admin&password=123456

![image-20220305233852478](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305233852478.png)



### 4.2 重定向到主界面

>1、测试2

随便输入错误的用户名12，输入错误的密码12

浏览器url为http://localhost:8080/user/login?username=12&password=123456，页面上附有错误提示信息
页面展示：

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220305233947587.png" alt="image-20220305233947587" style="zoom:50%;" />

到此我们的登录功能实现完毕，但是有一个很大的问题，浏览器的url暴露了用户的用户名和密码，这在实际开发中可是重大的漏洞，泄露了用户信息，因此我们需要编写一个映射

我们在自定义的配置类MyMvcConfig中加一句代码

>2、MyMvcConfig配置类

~~~java
registry.addViewController("/main.html").setViewName("dashboard");
~~~

也就是访问/main.html页面就跳转到dashboard页面

然后我们稍稍修改一下LoginController，当登录成功时重定向到main.html页面，也就跳转到了dashboard页面

```java
package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        //如果用户名和密码正确
        if (username.equals("admin") && password.equals("123456")) {
            //跳转到dashboard页面
            return "redirect:/main.html"; //重定向到main.html页面,也就是跳转到dashboard页面
        } else { //如果用户名或者密码不正确
            //显示错误信息
            model.addAttribute("msg","用户名或密码错误");
            //跳转到首页
            return "index";
        }
    }
}
```

![image-20220306102755620](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306102755620.png)

但是这又出现了新的问题，无论登不登陆，我们访问localhost/main.html都会跳转到dashboard的页面，这就引入了接下来的**拦截器**



## 5. 登录拦截器配置

> 1、需求概述

用户登录成功后，后台会得到用户信息；如果没有登录，则不会有任何的用户信息；

我们就可以利用这一点通过拦截器进行拦截：

当用户登录时将用户信息存入session中，访问页面时首先判断session中有没有用户的信息
		**如果没有**，拦截器进行拦截；
		**如果有**，拦截器放行

> 2、LoginController控制器类

**在LoginController中当用户登录成功后，存入用户信息到session中**

```java
package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        //如果用户名和密码正确
        if (username.equals("admin") && password.equals("123456")) {
            session.setAttribute("LoginUser",username);
            //跳转到dashboard页面
            return "redirect:/main.html"; //重定向到main.html页面,也就是跳转到dashboard页面
        } else { //如果用户名或者密码不正确
            //显示错误信息
            model.addAttribute("msg","用户名或密码错误");
            //跳转到首页
            return "index";
        }
    }
}
```

> 3、LoginHandlerInterceptor登录拦截器

实现自定义的登录拦截器，继承HandlerInterceptor接口

![image-20220306103833981](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306103833981.png)

```java
package com.koko.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //用户登录成功后,应该有自己的session
        Object user = request.getSession().getAttribute("LoginUser");

        if (user == null) {
            request.setAttribute("msg", "您没有权限,请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
```

> 4、MyMvcConfig配置类

**然后配置到bean中注册，在MyMvcConfig配置类中，重写关于拦截器的方法，添加我们自定义的拦截器，注意屏蔽静态资源及主页以及相关请求的拦截**

~~~java
@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginHandlerInterceptor())
        .addPathPatterns("/**") //拦截所有请求
        .excludePathPatterns("/index.html", "/", "/login", "/css/**", "/js/**", "/img/**"); //排除拦截的内容
}
~~~

> 5、测试

**然后重启主程序进行测试，直接访问http://localhost:8080/main.html**

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306104228510.png" alt="image-20220306104228510" style="zoom:50%;" />

* 拦截器功能完备



## 6. 展示员工信息

### **6.1 实现Customers视图跳转**

点击dashboard.html页面中的Customers展示跳转到list.html页面显示所有员工信息

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615174330221.png)

> 1、dashboard.html

因此，我们首先给dashboard.html页面中Customers部分标签添加href属性，实现点击该标签请求/emps路径跳转到list.html展示所有的员工信息

![image-20220306104645783](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306104645783.png)

> 2、list.html

**同样修改list.html对应该的代码为上述代码**

![image-20220306104811883](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306104811883.png)

> 3、重构模板结构

在实际开发中：我们在templates目录下新建一个包emp，用来放所有关于员工信息的页面，我们将list.html页面移入该包中

![image-20220306104929524](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306104929524.png)

> **4、EmployeeController控制类**

**然后编写请求对应的controller，处理/emps请求，在controller包下，新建一个EmployeeController类**

![image-20220306105055375](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306105055375.png)

```java
package com.koko.controller;

import com.koko.mapper.EmployeeMapper;
import com.koko.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("/emps")
    public String EmployeeList(Model model){
        Collection<Employee> employeeAll = employeeMapper.getEmployeeAll();
        model.addAttribute("emps", employeeAll);
        return "emp/list";
    }

}
```

> 5、测试

**重启主程序进行测试，登录到dashboard页面，再点击Customers，成功跳转到/emps**

![image-20220306105529292](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306105529292.png)

**问题：**
1.我们点击了Customers后，它应该处于高亮状态，但是这里点击后还是普通的样子，高亮还是在Dashboard上
2.list.html和dashboard.html页面的侧边栏和顶部栏是相同的，可以抽取出来



#### 6.1.1 提取页面公共部分

![image-20220306175331671](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306175331671.png)

> 1、common.html

利用th:fragment标签抽取公共部分（顶部导航栏和侧边栏）

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<!--头部导航栏-->
<!--顶部导航栏-->
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0" th:fragment="topbar">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">[[${session.loginuser}]]</a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" th:href="@{/user/loginout}">注销</a>
        </li>
    </ul>
</nav>


<!--侧边栏-->
<!--侧边栏-->
<nav class="col-md-2 d-none d-md-block bg-light sidebar" th:fragment="sidebar(active)">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a th:class="${active=='main.html'?'nav-link active':'nav-link'}" th:href="@{/index.html}">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-home">
                        <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                        <polyline points="9 22 9 12 15 12 15 22"></polyline>
                    </svg>
                    首页 <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-file">
                        <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                        <polyline points="13 2 13 9 20 9"></polyline>
                    </svg>
                    Orders
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-shopping-cart">
                        <circle cx="9" cy="21" r="1"></circle>
                        <circle cx="20" cy="21" r="1"></circle>
                        <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                    </svg>
                    Products
                </a>
            </li>
            <li class="nav-item">
                <a th:class="${active=='list.html'?'nav-link active':'nav-link'}" th:href="@{/emps}">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-users">
                        <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                        <circle cx="9" cy="7" r="4"></circle>
                        <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                        <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                    </svg>
                    员工管理
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-bar-chart-2">
                        <line x1="18" y1="20" x2="18" y2="10"></line>
                        <line x1="12" y1="20" x2="12" y2="4"></line>
                        <line x1="6" y1="20" x2="6" y2="14"></line>
                    </svg>
                    Reports
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-layers">
                        <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                        <polyline points="2 17 12 22 22 17"></polyline>
                        <polyline points="2 12 12 17 22 12"></polyline>
                    </svg>
                    Integrations
                </a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Saved reports</span>
            <a class="d-flex align-items-center text-muted"
               href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                     stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                     class="feather feather-plus-circle">
                    <circle cx="12" cy="12" r="10"></circle>
                    <line x1="12" y1="8" x2="12" y2="16"></line>
                    <line x1="8" y1="12" x2="16" y2="12"></line>
                </svg>
            </a>
        </h6>
        <ul class="nav flex-column mb-2">
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-file-text">
                        <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                        <polyline points="14 2 14 8 20 8"></polyline>
                        <line x1="16" y1="13" x2="8" y2="13"></line>
                        <line x1="16" y1="17" x2="8" y2="17"></line>
                        <polyline points="10 9 9 9 8 9"></polyline>
                    </svg>
                    Current month
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-file-text">
                        <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                        <polyline points="14 2 14 8 20 8"></polyline>
                        <line x1="16" y1="13" x2="8" y2="13"></line>
                        <line x1="16" y1="17" x2="8" y2="17"></line>
                        <polyline points="10 9 9 9 8 9"></polyline>
                    </svg>
                    Last quarter
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-file-text">
                        <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                        <polyline points="14 2 14 8 20 8"></polyline>
                        <line x1="16" y1="13" x2="8" y2="13"></line>
                        <line x1="16" y1="17" x2="8" y2="17"></line>
                        <polyline points="10 9 9 9 8 9"></polyline>
                    </svg>
                    Social engagement
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-file-text">
                        <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                        <polyline points="14 2 14 8 20 8"></polyline>
                        <line x1="16" y1="13" x2="8" y2="13"></line>
                        <line x1="16" y1="17" x2="8" y2="17"></line>
                        <polyline points="10 9 9 9 8 9"></polyline>
                    </svg>
                    Year-end sale
                </a>
            </li>
        </ul>
    </div>
</nav>

</html>
```

> 2、dashboard.html && list.html

**然后删除dashboard.html和list.html中顶部导航栏和侧边栏的代码**

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615175011126.png)

再次重启主程序测试一下，登陆成功后，可以看到已经没有了顶部导航栏和侧边栏

![image-20220306180014071](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306180014071.png)

**注**：这是因为我们删除了公共部分，还没有引入，我们分别在dashboard.html和list.html删除的部分插入提取出来的公共部分topbar和sidebar

~~~html
<!--顶部导航栏-->
<div th:replace="~{commons/commons::topbar}" }></div>

<!--侧边栏-->
<div th:replace="~{commons/commons::siderbar}"></div>
~~~

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/2021061517513876.png)

> 3、测试

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615175205549.png)



#### 6.1.2 点击高亮处理

> 1、dashboard.html

在页面中，使高亮的代码是class="nav-link active"属性

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615175255187.png)

我们可以传递参数判断点击了哪个标签实现相应的高亮

首先在dashboard.html的侧边栏标签传递参数active为dashboard.html

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615175339718.png)

~~~html
<!--侧边栏-->
<div th:replace="~{commons/commons::siderbar(active='dashboard.html')}"></div>
~~~

> 2、list.html

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615175415372.png)

~~~html
<!--侧边栏-->
<div th:replace="~{commons/commons::siderbar(active='list.html')}"></div>
~~~

> 3、commons.html

然后我们在公共页面commons.html相应标签部分利用thymeleaf接收参数active，利用三元运算符判断决定是否高亮

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615175517500.png)

> 4、测试

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615175550597.png)



### 6.2 显示员工信息

> 1、list.html

![image-20220306172702867](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306172702867.png)

```html
<thead>
   <tr>
      <th>id</th>
      <th>lastName</th>
      <th>email</th>
      <th>sex</th>
      <th>department</th>
      <th>date</th>
   </tr>
</thead>
<tbody>
   <tr th:each="emps:${emps}">
      <td th:text="${emps.getId()}"></td>
      <td th:text="${emps.getLastName()}">Lorem</td>
      <td th:text="${emps.getEmail()}">ipsum</td>
      <td th:text="${emps.getSex()}">sit</td>
      <td th:text="${emps.getDepartment()}">dolor</td>
      <td th:text="${emps.getBirth()}">sit</td>
   </tr>
</tbody>
```

> 2、测试

![image-20220306172741032](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306172741032.png)

* 因为前面高亮没有实现，所以存在小bug

> 3、list.html

![image-20220306173050860](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306173050860.png)

~~~html
<th>操作</th>
<td>
    <button class="btn btn-sm btn-primary">编辑</button>
    <button class="btn btn-sm btn-danger">删除</button>
</td>
~~~

> 4、测试

![image-20220306173013874](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306173013874.png)



## 7. 添加员工信息

> 1、add.html

![image-20220306180511464](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306180511464.png)

```html
<!DOCTYPE html>
<!-- saved from url=(0052)http://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link th:href="@{/asserts/css/bootstrap.min.css}" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link th:href="@{/asserts/css/dashboard.css}" rel="stylesheet">
    <style type="text/css">
        /* Chart.js */

        @-webkit-keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }
            to {
                opacity: 1
            }
        }

        @keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }
            to {
                opacity: 1
            }
        }

        .chartjs-render-monitor {
            -webkit-animation: chartjs-render-animation 0.001s;
            animation: chartjs-render-animation 0.001s;
        }
    </style>
</head>

<body>
<div th:replace="~{commons/commons::topbar}"></div>

<div class="container-fluid">
    <div class="row">
        <div th:replace="~{commons/commons::sidebar(active='list.html')}"></div>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <form class="form-horizontal" th:action="@{/emp}" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">名字</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="张三" name="lastName">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">邮件</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" placeholder="1234567456@qq.com" name="email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-offset-2 col-sm-10">
                        <label>
                            <input type="radio" name="gender" checked value="1">&nbsp;男
                        </label>
                        &nbsp;&nbsp;&nbsp;
                        <label>
                            <input type="radio" name="gender" value="0">&nbsp;女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">部门</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="department.id">
                            <option th:each="dept:${departments}" th:text="${dept.getDepartmentName()}"
                                    th:value="${dept.getId()}"></option>
                        </select>
                    </div>

                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">生日</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="2000/11/11" name="birth">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-sm btn-success" type="submit">添加</button>
                    </div>
                </div>
            </form>
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="asserts/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="asserts/js/popper.min.js"></script>
<script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>

<!-- Icons -->
<script type="text/javascript" src="asserts/js/feather.min.js"></script>
<script>
    feather.replace()
</script>

<!-- Graphs -->
<script type="text/javascript" src="asserts/js/Chart.min.js"></script>
<script>
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            datasets: [{
                data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>

</body>

</html>
```

> 2、list.html

![image-20220306180802002](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306180802002.png)

~~~html
<a class="btn btn-sm btn-success" th:href="@{/emp}">添加</a>
~~~

> 3、EmployeeController控制类

```java
@GetMapping("/emp")
public String toAdd(Model model) {
    //查出部门的所有信息
    Collection<Department> departments = departmentDao.getDepartment();
    model.addAttribute("departments", departments);
    return "emp/add";
}
```

> 4、测试

![image-20220306180925136](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306180925136.png)

![image-20220306180954256](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306180954256.png)



> 5、add.html

在add.html页面，当我们填写完信息，点击添加按钮，应该完成添加返回到list页面，展示新的员工信息；因此在add.html点击添加按钮的一瞬间，我们同样发起一个请求/add，与上述提交按钮发出的请求路径一样，但这里发出的是post请求

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210615194831859.png)

> 6、EmployeeController

~~~java
@PostMapping("/emp")
public String add(Employee employee) {
    System.out.println(employee);
    //        添加的操作
    employeeDao.save(employee);
    return "redirect:/emps";
}
~~~

> 7、测试

![image-20220306181128395](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306181128395.png)

* 添加成功！！！

![image-20220306181141314](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306181141314.png)



## 8. 修改员工信息

> 1、list.html

**1. list页面编辑按钮增添请求**

![image-20220306191341946](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306191341946.png)

> 2、EmployeeController类

然后编写对应的controller，在EmployeeController中添加一个方法edit用来处理list页面点击编辑按钮的操作，返回到edit.html编辑员工页面，我们即将创建

```java
//去员工的修改页面
@GetMapping("/upemp/{id}")
public String toupdataEmp(@PathVariable("id") Integer id, Model model) {
    //查出原来的数据
    Employee employee = employeeDao.getEmployeeById(id);
    model.addAttribute("emp", employee);

    Collection<Department> departments = departmentDao.getDepartment();
    model.addAttribute("departments", departments);

    return "emp/update";
}
```

> 3、update.html

![image-20220306191731554](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306191731554.png)

```html
<!DOCTYPE html>
<!-- saved from url=(0052)http://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link th:href="@{/asserts/css/bootstrap.min.css}" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link th:href="@{/asserts/css/dashboard.css}" rel="stylesheet">
    <style type="text/css">
        /* Chart.js */

        @-webkit-keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }
            to {
                opacity: 1
            }
        }

        @keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }
            to {
                opacity: 1
            }
        }

        .chartjs-render-monitor {
            -webkit-animation: chartjs-render-animation 0.001s;
            animation: chartjs-render-animation 0.001s;
        }
    </style>
</head>

<body>
<div th:replace="~{commons/commons::topbar}"></div>

<div class="container-fluid">
    <div class="row">
        <div th:replace="~{commons/commons::sidebar(active='list.html')}"></div>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <form class="form-horizontal" th:action="@{/updateEmp}" method="post">
                <input type="hidden" name="id" th:value="${emp.getId()}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">名字</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="lastName" th:value="${emp.getLastName()}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">邮件</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" th:value="${emp.getEmail()}" name="email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-offset-2 col-sm-10">
                        <label>
                            <input th:checked="${emp.getGender()==1}" type="radio" name="gender" checked value="1">&nbsp;男
                        </label>
                        &nbsp;&nbsp;&nbsp;
                        <label>
                            <input th:checked="${emp.getGender()==0}" type="radio" name="gender" value="0">&nbsp;女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">部门</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="department.id">
                            <option th:selected="${emp.getDepartment().getId()==dept.getId()}"
                                    th:each="dept:${departments}" th:text="${dept.getDepartmentName()}"
                                    th:value="${dept.getId()}"></option>
                        </select>
                    </div>

                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">生日</label>
                    <div class="col-sm-10">
                        <input th:value="${#dates.format(emp.getBirth(),'yyyy/MM/dd')}" type="text" class="form-control"
                               name="birth">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-sm btn-success" type="submit">修改</button>
                    </div>
                </div>
            </form>
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="asserts/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="asserts/js/popper.min.js"></script>
<script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>

<!-- Icons -->
<script type="text/javascript" src="asserts/js/feather.min.js"></script>
<script>
    feather.replace()
</script>

<!-- Graphs -->
<script type="text/javascript" src="asserts/js/Chart.min.js"></script>
<script>
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            datasets: [{
                data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>

</body>

</html>
```

> 4、测试

![image-20220306191919273](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306191919273.png)

![image-20220306191934500](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306191934500.png)



## 9. 删除员工信息

> 1、list.html

当我们点击删除标签时，应该发起一个请求，删除指定的用户，然后重新返回到list页面显示员工数据

![image-20220306192013422](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306192013422.png)

> 2、EmployeeController控制类

然后编写对应的controller，处理点击删除按钮的请求，删除指定员工，重定向到/emps请求，更新员工信息

```java
//删除员工
@GetMapping("/deleteEmp/{id}")
public String deleteEmp(@PathVariable("id") int id) {
    employeeDao.delete(id);
    return "redirect:/emps";
}
```

> 3、测试

**重启测试，点击删除按钮即可删除指定员工**

![image-20220306195532539](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306195532539.png)

![image-20220306195540396](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306195540396.png)



## 10. 注销登录操作

> 1、commons.html

在我们提取出来的公共commons页面，顶部导航栏处中的标签添加href属性，实现点击发起请求/user/logout

![image-20220306195712870](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306195712870.png)

> 2、LoginController控制类

然后编写对应的controller，处理点击注销标签的请求，在LoginController中编写对应的方法，清除session，并重定向到首页

```java
@RequestMapping("/user/loginout")
public String loginout(HttpSession session) {
    session.invalidate();
    return "redirect:/index.html";
}
```

> 3、测试

**重启测试，登录成功后，点击log out即可退出到首页!**

![image-20220306195857202](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306195857202.png)

* 回到页登录页

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220306195940583.png" alt="image-20220306195940583" style="zoom:50%;" />

> 4、小总结

跟着项目做项目，效率更高喔~

不要一味地自己一步步来，因为可能改bug会改到崩溃，而且解决不了实际上的问题，学习最重要的是学到知识和思路本身！

