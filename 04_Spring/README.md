# Spring学习资源

> 学习大纲（容器思想）

![image-20220125092207196](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125092207196.png)



## 1. Spring简介

### 1.1 Spring背景

- Spring：春天 给软件行业带来了春天
- 2002，首次推出了Spring框架的雏形：interface21框架
- Spring框架即是以interface21框架为基础经过重新设计，并不断丰富其内涵，于2004年3月24日发布了1.0正式版
- Spring理念：使现有的技术更加容易使用，本身是一个大杂烩，整合了现有的技术框架！
- SSH :Struct2 + Spring + Hibernate
- SSM：SpringMVC + SPring +Mybatis

> 学习必备网站

- 官网：https://spring.io/

- 官方下载地址：http://repo.spring.io/release/org/springframework/spring
- GitHub：https://github.com/spring-projects/spring-framework
- Spring核心技术地址：https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-annotation-config



### 1.2 Spring优点

- Spring是一个开源的免费的框架（容器）！
- Spring是一个轻量级的，非入侵式的框架

- 控制反转（IOC），面向切面编程（AOP）
- 支持事务的处理，对框架整合的支持！

==**Spring就是一个轻量级的控制反转（IOC）和切面编程（AOP）的框架！**==



### 1.3 Spring组成

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201223175525840.png)

==现代化的java开发，就是基于Spring开发！==

![image-20220129143821151](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220129143821151.png)

* Spring Boot
  * 一个快速开发的脚手架
  * 基于SpringBoot可以快速的开发单个微服务
  * 约定大于配置！
* Spring Cloud
  * SpringCloud是基于SpringBoot实现的

> 学习SpringBoot前提

因为大部分公司都用SpringBoot进行快速开发，学习SpringBoot之前要先学会Spring和SpringMVC！

> Spring弊端

**Spring弊端：发展太久后，违背了“简化开发”的理念！配置十分繁琐，人称“配置地狱”！**

> Spring的maven配置

~~~xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.15</version>
</dependency>
~~~



## 2. IOC理论推导

### 2.1 IOC组成理论推导

> 1、原来的实现方式

1.UserDao接口

~~~java
public interface UserDao {
    void getUser();
}
~~~

2.UserDaoImpl实现类

~~~java
public class UserDaoImpl implements UserDao{
    public void getUser() {
        System.out.println("默认获取用户的数据");
    }
}
~~~

3.UserService业务接口

~~~java
public interface UserService {
    void getUser();
}
~~~

4.UserServiceImpl实现类

~~~java
public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl();

    public void getUser() {
        userDao.getUser();
    }
}
~~~

问题：如果想要改变，就需要每次更改UserDao

> 2、解决方法

​	**若将UserDao使用Set接口实现**

~~~java
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    //利用set进行动态实现值得注入
    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

    public void getUser() {
        userDao.getUser();
    }
}
~~~

> 3、思想图解

![image-20220129152145177](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220129152145177.png)

- 之前，程序通过new主动创建对象！控制权在程序猿手上
- 使用set注入后，程序不再具有主动性，而是变成了被动的接受对象！
- 这种思想，从本质上解决了问题，程序员不用再去管理对象的创建了，降低了耦合性！



### 2.2 IOC本质

**控制反转IOC（Inversion of Control），是一种设计思想，DI（依赖注入）是实现IOC的一种方法**， 也有人认为DI只是IOC的另一种说法。没有IOC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓的控制反转就是：获得依赖的方式反转了。

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

**控制反转是一种通过描述（xml或注解）并通过第三方去生产或获取特定对象的方式。在spring中实现控制反转的是IOC容器，其实现方法是依赖注入（Dependency Injection，DI）**

![image-20220129152350741](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220129152350741.png)



### 2.3 HelloSpring

> 1、beans.xml层

![image-20220208143102277](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220208143102277.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--使用Spring来创建对象，在Spring这些都称为Bean-->
    <bean id="hello" class="com.koko.util.Hello">
        <property name="name" value="spring"/>
    </bean>

</beans>
```

> 2、实体类层

![image-20220208143137360](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220208143137360.png)

```java
package com.koko.util;

public class Hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

> 3、测试

```java
@Test
public void test01(){
    //获取spring的上下文对象
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    //我们的对象现在都在spring中管理，我们要使用，直接去里面取出来
    Hello hello = (Hello) context.getBean("hello");
    System.out.println(hello.toString());

}
```

![image-20220208143215406](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220208143215406.png)

**会发现，已经不需要手动new对象，对象是在xml文件中配置。或者通俗来讲，不需要改底层代码，而xml文件不算底层代码。**



> **概念：控制反转**

- **控制：** 谁来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用Spring后，对象是由Spring来创建的
- **反转:** 程序本身不创建对象，而变成被动的接收对象。
- **依赖注入：** 就是利用set方法来进行注入的
- **IOC是一种编程思想，由主动的编程变为被动的接收，所谓的IOC，即对象由Spring来创建，管理，装配**



> 小技巧

**【ctrl+alt+u】查询继承与接口的关系**

![image-20220208142824392](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220208142824392.png)



### 2.4 IOC创建对象的方式

1. 默认使用无参构造创建对象
2. 使用有参构造创建对象的三种方式

> a.下标赋值 Constructor argument index

```xml
<bean id="user" class="com.yang.entity.User">
    <constructor-arg index="0" value="张三"/>
    <constructor-arg index="1" value="18"/>
</bean>
```

> b.变量类型赋值 Constructor argument type matching

```xml
<bean id="user1" class="com.yang.entity.User">
    <constructor-arg type="int" value="18"/>
    <constructor-arg type="java.lang.String" value="张三"/>
</bean>
```

> **c.变量名称赋值 Constructor argument name**

```xml
<bean id="user2" class="com.yang.entity.User">
    <constructor-arg name="name" value="张三"/>
    <constructor-arg name="age" value="18"/>
</bean>
```

==在获取spring的上下文对象（ new ClassPathXmlApplicationContext(“beans.xml”); ）时，spring容器中的所有的对象就已经被创建了。[单例模式]==



## 3. Spring的基础配置

### 3.1 别名alias

~~~xml
<!--如果添加了别名，通过别名也可以获取对象-->
<alias name="user" alias="userAlias"/>
~~~

注：可以给别名起别名，只能一对一修改别名，无意义



### 3.2 Bean的配置

~~~xml
<!--
        id: bean的唯一标识符，也就是相当于我们学的对象名
        class： bean对象的全限定名：包名 + 类型
        name： 也是别名 而且name可以同时设置多个别名，可以用逗号 空格 分号隔开
    -->
<bean id="user1" class="com.yang.entity.User" name="test test1, test2; test3"> 
    <constructor-arg type="int" value="18"/>
    <constructor-arg type="java.lang.String" value="张三"/>
</bean>
~~~



### 3.3 import

**import，一般用于团队开发使用，他可以将多个配置文件，导入合并为1个**
		假设，现在项目中又多个人开发，这三个人负责不同的类开发，不同的类需要注册在不同的bean中，我们可以用import将所有人的beans.xml合并为一个总的！

- appliacationContext1.xml
- appliacationContext2.xml
- appliacationContext3.xml
- 合并

~~~xml
<import resource="applicationContext1.xml"/>
<import resource="applicationContext2.xml"/>
<import resource="applicationContext3.xml"/>
~~~



## 4. DI依赖注入（*）

### 4.1 构造器注入

### 4.2 set方式注入 【重点】

> **依赖注入**

依赖：bean对象的创建依赖于容器
		注入：bean对象中的所有属性，由容器来注入



【环境搭建】

> 1.复杂类型

~~~java
package com.koko.pojo;

public class Address {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
~~~

> 2.真实测试对象

~~~java
package com.koko.pojo;

import java.util.*;

public class Student {

    private String name;
    private Address address;
    private String [] books;
    private List<String> hobbies;
    private Map<String, String> card;
    private Set<String> games;
    private String wife;
    private Properties info;

    //以及Getter与Setter方法,toString方法
}
~~~

> 3.applicationContext.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="address" class="com.koko.pojo.Address">
        <property name="address" value="Dalian"/>
    </bean>

    <!--第一种 普通注入 value-->
    <bean id="student" class="com.koko.pojo.Student">
        <property name="name" value="yang"/>
        <!--第二种 Bean注入， ref-->
        <property name="address" ref="address"/>

        <!--数组-->
        <property name="books">
            <array>
                <value>红楼梦</value>
                <value>三国演义</value>
                <value>水浒传</value>
                <value>西游记</value>
            </array>
        </property>

        <!--List-->
        <property name="hobbies">
            <list>
                <value>抽烟</value>
                <value>喝酒</value>
                <value>烫头</value>
            </list>
        </property>

        <!--Map-->
        <property name="card">
            <map>
                <entry key="身份证" value="220......."/>
                <entry key="银行卡" value="626......."/>
            </map>
        </property>

        <!--Set-->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>COC</value>
                <value>BOB</value>
            </set>
        </property>

        <!--null-->
        <property name="wife">
            <null/>
        </property>

        <!--Properties-->
        <property name="info">
            <props>
                <prop key="driver">驱动</prop>
                <prop key="name">root</prop>
                <prop key="password">123456</prop>
            </props>
        </property>
    </bean>
</beans>
~~~

>4.测试类

```java
@Test
public void test01(){
    ApplicationContext contest = new ClassPathXmlApplicationContext("applicationContest.xml");

    Student student = (Student) contest.getBean("student");
    System.out.println(student.toString());
}
```

~~~java
        /*
        * Student{
        * name='yang',
        * address=Address{address='Dalian'},
        * books=[红楼梦, 三国演义, 水浒传, 西游记],
        * hobbies=[抽烟, 喝酒, 烫头],
        * card={身份证=220......., 银行卡=626.......},
        * games=[LOL, COC, BOB],
        * wife='null',
        * info={password=123456, name=root, driver=驱动}}
        * */
~~~



### 4.3 pc标签注入

> 1、官方文档

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210110191424534.png)

**1、p标签注入，须在beans中引入**

**xmlns:p="http://www.springframework.org/schema/p"**

**2、c标签注入，需在实体中增加有参构造方法**

**并引入 xmlns:c="http://www.springframework.org/schema/c"**

> 2、beans.xml配置

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--p命名空间注入，可以直接注入属性的值：property-->
    <bean id="p_test" class="com.koko.pojo.User" p:name="koko" p:age="18"/>

    <!--c命名空间注入，通过构造器注入：construct-args-->
    <bean id="c_test" class="com.koko.pojo.User" c:name="koko" c:age="18"/>

</beans>
~~~

> 3、测试：

~~~java
@Test
public void test01(){
ApplicationContext contest = new ClassPathXmlApplicationContext("applicationContest.xml");

User user =contest.getBean("p_test",User.class);
System.out.println(user);
}
~~~

> 4、注意

p命名和c命名空间不能直接使用，要导入xml约束！

~~~properties
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"
~~~



### 4.4 Bean的作用域

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210110191656330.png)

> **1.单例模式（Spring默认机制）**

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210110192236774.png)

~~~xml
<bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/>
~~~

>**2.原型模式：每次从容器中get对象时，都重新创建**

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210110192420718.png)

~~~xml
<bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>
~~~

**3.其余的request、session、application、websocket这些只能在web开发中使用**



## 5. Bean的自动装配

- 自动装配是spring满足bean依赖的一种方式
- Spring会在上下文中自动寻找，并自动给bean装配属性

> 在Spring中由三种装配方式

1. 在xml中显式配置
2. 在java中显式配置
3. **隐式的自动装配bean**

~~~xml
<--1.在xml中显式配置-->
<bean id="dog" class="com.koko.pojo.Dog"/>
<bean id="cat" class="com.koko.pojo.Cat"/>

<bean id="people" class="com.koko.pojo.People">
    <property name="cat" ref="cat"/>
    <property name="dog" ref="dog"/>
    <property name="name" value="name"/>
</bean>
~~~

> 改进：

### 5.1 byName与byType自动装配

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="cat" class="com.koko.pojo.Cat"/>
    <bean id="dog" class="com.koko.pojo.Dog"/>
    
    <!--
        byName:会在容器上下文中查找，和自己对象set方法后面的值相对应的beanid
        byType：会自动在容器上下文中查找，和自己对象属性类型相同的bean
    -->
    <bean id="people" class="com.koko.pojo.People" autowire="byName">
        <property name="name" value="koko"/>
    </bean>
    <bean id="people" class="com.koko.pojo.People" autowire="byType">
        <property name="name" value="koko"/>
    </bean>

</beans>
~~~

> 测试

```java
@Test
public void testMethodAutowire() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    People people = context.getBean("people", People.class);
    people.getCat().shout();
    people.getDog().shout();
}
```

**小结：**
		byName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致
		byType的时候，需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致



### 5.2 使用注解实现自动装配

> 1、配置注解的支持context:annotation-config

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:context="http://www.springframework.org/schema/context"
      xmlns:aop="http://www.springframework.org/schema/aop"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">

   <!--开启注解支持-->
   <context:annotation-config/>
</beans>
~~~



### 5.3 @Autowired与@Resource自动装配

> 1、@Autowired

~~~java
public class People {
    @Autowired
    private Cat cat;
    @Autowired
    @Qualifier(value = "xxx")
    private Dog dog;
    private String name;
}
~~~

如果@Autowired自动装配的环境比较复杂，自动装配无法通过一个注解【@Autowired】完成的时候，我们可以使用@Qualifier（value = “xxx”）去配置@Autowired的使用，指定一个唯一的bean对象注入！



> 2、@Resource

**不指定name值，先去判断byName和byType，有一个能注入即成功**

~~~java
public class People {
    @Resource(name = "xxxx")
    private Cat cat;
}
~~~



> **3、小结：@Resource和@Autowired的区别**

- 都是用来自动装配的，都可以放在属性字段上
- @Autowired通过byType的方式实现，而且必须要求这个对象存在！

- @Resource默认通过byName的方式实现，如果找不到名字，则通过byType实现！如果两个都找不到的情况下，就报错！
- 执行顺序不同：@Autowired通过byType的方式实现。@Resource默认通过byName的方式实现。



### 5.4 使用注解开发

在Spring4之后，要使用注解开发，必须保证aop的包导入了

![image-20220209170107209](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220209170107209.png)

> 使用注解需要导入context约束，增加注解的支持！

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--开启注解支持-->
    <context:annotation-config/>
    <!--指定要扫描的包，这个包下的注解就会生效-->
    <context:component-scan base-package="com.koko"/>
</beans>
~~~

>**1. bean注入使用@Componet注解**

~~~java
//@Component 等价于<bean id="user" class="com.koko.pojo.User"/>
@Component
public class User {
    String name;
}
~~~

>**2. 属性注入使用@Value注解**

~~~java
//@Component 等价于<bean id="user" class="com.koko.pojo.User"/>
@Component
public class User {
    @Value("koko")
    String name;
    //@Value("yang") 相当于<property name="name" value="yang"/>
    @Value("koko")
    public void setName(String name) {
        this.name = name;
    }
}
~~~

>**3. 衍生注解**

@Componet有几个衍生注解，我们在web开发中，会按照mvc三层架构分层！

- dao层 【@Repository】
- service层 【@Service】

- controller层 【@Controller】

这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配Bean

>**4.自动装配**

~~~properties
@Autowired  自动装配通过类型、名字
			如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
@Nullable   字段标记了这个注解，说明这个字段可以为null
@Resource 自动装配通过名字，类型
~~~

>**5. 作用域**

~~~java
//类中定义
@Scope("singleton")单例模式
@Scope("prototype")原型模式    
~~~

* 类中定义

>**6. 小结**

1、XML 与 注解

- xml更加万能，适用于任何场合！维护简单方便
- 注解不是自己类使用不了， 维护相对复杂

2、XML 与 注解最佳实践

- xml用来管理bean
- 注解只负责完成属性的注入
- 我们在使用过程中，只需要注意一个问题：必须让注解生效，就需要开启注解的支持

~~~xml
<!--开启注解支持-->
<context:annotation-config/>
<!--指定要扫描的包，这个包下的注解就会生效-->
<context:component-scan base-package="com.koko"/>
~~~



### 5.5 使用java的方式配置Spring

> 与上述配置文件开发思路不同

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210117164149562.png)

> 测试模块框架

![image-20220209173525270](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220209173525270.png)

>1、实体类

~~~java
package com.koko.pojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

    private String name;

    public String getName() {
        return name;
    }
    @Value("koko")
    public void setName(String name) {
        this.name = name;
    }
}
~~~

> 2、配置类

~~~java
package com.koko.config;
import com.koko.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration,这个也会被Spring容器托管，注册到容器中，因为打开注解，它本身就被定义为组件了@Component
//@Configuration该注解代表了这是一个配置类，与applicationContext.xml一样
@Configuration
@ComponentScan("com.koko.pojo")
@Import(kokoConfig2.class)
public class kokoConfig {

    //注册一个Bean，就相当于我们之前写的一个bean标签
    //方法名字 == bean标签的id
    //方法的返回值 == bean标签中的class属性

    @Bean
    public User getUser () {
        return new User();//就是返回要注入到bean的对象
    }
}
~~~

> 3、测试类

```java
@Test
public void test01(){
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(kokoConfig.class);

    User getUser = annotationConfigApplicationContext.getBean("getUser", User.class);
    System.out.println(getUser.getName());

}
```

这种纯Java的配置方式，在SpringBoot中随处可见！



## 6. 代理模式（*）

> 1、为什么要学习代理模式？

因为这就是SpringAOP的底层！【SpringAOP和SpringMVC】

![image-20220209202921677](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220209202921677.png)



### 6.1 静态代理

> 1、角色分析：

- 抽象角色：一般会使用接口或者抽象类来解决
- 真实角色：被代理的角色
- 代理角色：代理真实角色，代理真实角色后，我们一般会做一些附属操作
- 客户：访问代理对象的人

>2、代码步骤：

1. 接口
2. 真实角色
3. 代理角色
4. 客户端访问代理角色
5. 具体代码可参考：[多线程中的静态代理](https://blog.csdn.net/weixin_45416687/article/details/108552758)

> **3、特点：代理模式**

优点：

- 可以使真实角色的操作更加存粹！不用去关注一些公共的业务
- 公共交给了代理角色，实现了业务的分工
- 公共业务发生扩展的时候，方便集中管理

缺点：

- 一个真实角色就会产生一个代理角色，代码量会翻倍 开发效率变低

> 4、聊聊AOP

![image-20220209204109716](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220209204109716.png)



### 6.2 动态代理

- 动态代理和静态代理角色一样

- 动态代理的代理类是动态生成的，不是我们直接写好的

- 动态代理分为两大类：基于接口的动态代理，基于类的动态代理

  基于接口：JDK动态代理
  基于类： cglib
  java字节码实现： javasist

> 1、需要了解两个类：

Proxy：代理 

InvocationHandler：调用处理程序



> 2、Proxy：代理 

* 2-1、基本特质：

java.lang.reflect.Proxy

Proxy提供了创建动态代理类和实例的静态方法，它也是由这些方法创建的所有动态代理类的超类。

(大白话：这是一个静态类，类里边有方法得到代理类)

* 2-2、动态代理类：

动态代理类 （以下简称为代理类 ）是一个实现在类创建时在运行时指定的接口列表的类，具有如下所述的行为。

 代理接口是由代理类实现的接口。 代理实例是代理类的一个实例。 每个代理实例都有一个关联的调用处理程序对象，它实现了接口InvocationHandler 。

 通过其代理接口之一的代理实例上的方法调用将被分派到实例调用处理程序的invoke方法，传递代理实例， java.lang.reflect.Method被调用方法的java.lang.reflect.Method对象以及包含参数的类型Object Object的数组。

 调用处理程序适当地处理编码方法调用，并且返回的结果将作为方法在代理实例上调用的结果返回。


> 3、InvocationHandler：调用处理程序

* 3-1、基本特质：

InvocationHandler是由代理实例的调用处理程序实现的接口 。

每个代理实例都有一个关联的调用处理程序。 当在代理实例上调用方法时，方法调用将被编码并分派到其调用处理程序的invoke方法。

invoke(Object proxy, 方法 method, Object[] args) 处理代理实例上的方法调用并返回结果。



> 4、示例编写

![image-20220209230637020](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220209230637020.png)

> 1、UserService接口

```java
package com.koko.pojo;

public interface UserService {
    public void add();
    public void delete();
    public void update();
    public void select();
}
```

> 2、接口实现类

```java
package com.koko.pojo;

public class UserServiceImpl implements UserService{
    public void add() {
        System.out.println("增加一个用户");
    }
    public void delete() {
        System.out.println("删除一个用户");
    }
    public void update() {
        System.out.println("更新一个用户");
    }
    public void select() {
        System.out.println("检索一个用户");
    }
}
```

> **3、创建代理工具类**

```java
package com.koko.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Object target;

    //接口的set方法
    public void setTarget(Object target){
        this.target=target;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    //处理代理实例，并返回结果:
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }

}
```

> 4、测试类

```java
package com.koko.test;

import com.koko.pojo.UserService;
import com.koko.pojo.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色，不存在
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        //设置要代理的对象
        proxyInvocationHandler.setTarget(userService);

        //注意要用接口强转，否则会报异常
        UserService proxy = (UserService)proxyInvocationHandler.getProxy();
        proxy.add();
        proxy.delete();
    }
}
```

![image-20220209231314790](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220209231314790.png)



> **4、动态代理的好处：**

在原先代理模式的前提下：

* 一个动态代理类代理的是一个接口，一般就是对应的一类业务
* 一个动态代理类可以代理多个类，只要是实现了同一个接口即可！



## 7. AOP

### 7.1 什么是AOP

AOP（Aspect Oriented Programming）意为：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术，AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生泛型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210120190356959.png)



### 7.2 Aop在Spring中的作用

==提供生命事务：允许用户自定义切面==

- 横切关注点：跨越应用程序多个模块的方法或功能。即与我们的业务逻辑无关的，但是我们需要关注的部分，就是横切关注点。如日志，安全，缓存，事务等等。。。
- 切面（ASPECT）：横切关注点 被模块化的特殊对象。即 它是一个类
- 通知（Advice）：切面必须要完成的工作，即 他是类中的一个方法

- 目标（target）：被通知的对象
- 代理（Proxy）：向目标对象应用通知之后创建的对象
- 切入点（PointCut）：切面通知 执行的"地点"的定义
- 连接点（jointPoint）：与切入点匹配的执行点

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210120191529526.png)

SpringAop中，通过Advice定义横切逻辑，Spring中支持的5种类型的Advice

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210120192909523.png)



### 7.3 使用Spring实现Aop

**【重点】使用AOP织入，需要依赖包**

~~~xml
<dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.4</version>
</dependency>
~~~

使用Spring实现Aop主要有三种方法：

* 使用Spring的API接口
* 自定义来实现AOP
* 使用注解实现AOP



> 项目文件

![image-20220210162449493](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210162449493.png)



#### **7.3.1 使用Spring的API接口**

eg:在执行UserService实现类的所有方法时，增加日志功能

> 1、UserServer接口

~~~java
package com.koko.service;

public interface UserService {
    public void add();
    public void delete();
    public void update();
    public void select();
}
~~~

> 2、UserServer实现类

```java
package com.koko.service;

public class UserServiceImpl implements UserService{
    public void add() {
        System.out.println("增加一个用户");
    }
    public void delete() {
        System.out.println("删除一个用户");
    }
    public void update() {
        System.out.println("更新一个用户");
    }
    public void select() {
        System.out.println("检索一个用户");
    }
}
```

> 3、Log类

```java
package com.koko.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;
public class log implements MethodBeforeAdvice, AfterReturningAdvice {
    //method:要执行的目标对象的方法（method being invoked）
    //args:参数（args: arguments to the method）
    //object:目标对象 （target：target of the method invocation）
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了");
    }
    //returnValue:返回值
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + method.getName() + "方法，返回值为" + returnValue);
    }
}
```

> **4、applicationContext.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--注册bean-->
    <bean id="userService" class="com.koko.service.UserServiceImpl"/>
    <bean id="log" class="com.koko.log.log"/>

    <!--方式：使用原生Spring Api接口-->
    <!--配置aop-->
    <aop:config>
        <!--切入点：execution:表达式，execution(*(修饰词) *(返回值) *(类名) *(方法名) *(参数))  ..任意参数-->
        <aop:pointcut id="pointcut" expression="execution(* com.koko.service.UserServiceImpl.*(..))"/>

        <!--执行环绕增加-->
        <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
    </aop:config>
</beans>
```

> 5、测试类

```java
import com.koko.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mytest {
    @Test
    public void test01(){
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //动态代理的代理对象是接口
        UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);
        userService.add();
    }
}
```

![image-20220210164104653](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210164104653.png)



#### **7.3.2 自定义来实现AOP**

【主要是切面定义】

> 1、自定义类DiyPointCut

```java
package com.koko.diy;

public class DiyPointCut {
    public void beforeMethod () {
        System.out.println("方法执行之前");
    }

    public void afterMethod(){
        System.out.println("方法执行之后");
    }
}
```

> **2、applicationContext.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--注册bean-->
    <bean id="userService" class="com.koko.service.UserServiceImpl"/>
    <bean id="log" class="com.koko.log.log"/>
    <bean id="diy" class="com.koko.diy.DiyPointCut"/>
    <!--方式2：自定义类-->
    <aop:config>
        <!--<aop:aspect ref="diy"> : 标注这个类为切面-->
        <aop:aspect ref="diy">
            <!--切入点-->
            <aop:pointcut id="point" expression="execution(* com.koko.service.UserServiceImpl.*(..))"/>
            <!--通知-->
            <aop:before method="beforeMethod" pointcut-ref="point"/>
            <aop:after method="afterMethod" pointcut-ref="point"/>
        </aop:aspect>
    </aop:config>

</beans>
```

![image-20220210164648987](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210164648987.png)



#### **7.3.3 使用注解实现AOP**

>1、注释自定义类

```java
package com.koko.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

@Aspect
class AnnotationPointcut {
    @Before("execution(* com.koko.service.UserServiceImpl.*(..))")
    public void before () {
        System.out.println("====方法执行前====");
    }
    @After("execution(* com.koko.service.UserServiceImpl.*(..))")
    public void after () {
        System.out.println("====方法执行后====");
    }
    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.koko.service.UserServiceImpl.*(..))")
    public void around (ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前");
        Signature signature = pjp.getSignature();//获得签名
        System.out.println("signature:" + signature);

        Object proceed = pjp.proceed();//执行方法
        System.out.println(proceed);
        System.out.println("环绕后");
    }
}
```

> **2、applicationContext.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--注册bean-->
    <bean id="userService" class="com.koko.service.UserServiceImpl"/>

    <!--方式3：使用注解-->
    <!--开启注解支持  JDK（默认proxy-target-class="false"）cglib默认proxy-target-class="true"）-->
    <aop:aspectj-autoproxy proxy-target-class="false"/>
    <bean id="annotationPointCut" class="com.koko.diy.AnnotationPointcut"/>

</beans>
```

![image-20220210165216464](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210165216464.png)



## 8. 整合Mybatis（*）

### 8.1 回顾Mabatis

> 1、导入相关jar包

* junit
* mybatis
* mysql数据库
* spring相关的
* aop织入
* mybatis-spring
* ......

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>spring_01_study</artifactId>
        <groupId>com.koko</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>spring_07_mybatis</artifactId>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.6</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.15</version>
        </dependency>
        <!--Spring操作数据库的话，还需要一个spring-jdbc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.1.9.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.4</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.8.13</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.22</version>
        </dependency>
    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>

</project>
~~~

> 2、项目模块

![image-20220210174521517](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210174521517.png)

> 2-1、User实体类

~~~java
package com.koko.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int pwd;
}
~~~

> 2-2、mybatis-config.xml

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<!--configuration core file-->
<configuration>

    <typeAliases>
        <package name="com.koko.pojo"/>
    </typeAliases>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=GMT"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper class="com.koko.mapper.UserMapper"/>
    </mappers>
</configuration>
~~~

> 2-3、接口类

```java
package com.koko.mapper;

import com.koko.pojo.User;
import java.util.List;

public interface UserMapper {
    public List<User> selectUser();
}
```

> 2-4、接口实现类

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.koko.mapper.UserMapper">

    <select id="selectUser" resultType="user">
        select * from mybatis.user;
    </select>

</mapper>
```

> 2-5、测试类

```java
import com.koko.mapper.UserMapper;
import com.koko.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mytest {
    @Test
    public void test01 () throws IOException {
        String resources="mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resources);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
```

![image-20220210174851551](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210174851551.png)



### 8.2 整合Mybatis方式一

> 1、步骤

* 编写数据源配置DataSource
* sqlSessionFactory
* sqlSessionTeamplate
* 需要给接口加实现类
* 将自己写的实现类注入Spring中
* 测试使用即可！

![image-20220210224455622](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210224455622.png)



> 2、spring-dao.xml

配置数据源DataSource与sqlSession

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--1、DataSource：使用Spring的数据源替换Mybatis的配置  c3p0  dbcp  druid
    我们这里使用Spring提供的JDBC：org.springframework.jdbc.datasource-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=GMT"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </bean>

    <!--2、sqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!--绑定Mybatis配置文件-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <property name="mapperLocations" value="classpath:com/koko/mapper/*.xml"/>
    </bean>

    <!--3、sqlSession-->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
        <!--只能使用构造器注入sqlSessionFactory，因为没有set方法-->
        <constructor-arg index="0" ref="sqlSessionFactory"/>
    </bean>
</beans>
```

>3、mybatis-config.xml

配置一些mybatis专属配置（让mybatis有点用！）

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<!--configuration core file-->
<configuration>

    <typeAliases>
        <package name="com.koko.pojo"/>
    </typeAliases>

</configuration>
```

>4、applicationContext.xml

整合与注册bean等

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <import resource="spring-dao.xml"/>
    
    <bean id="userMapper" class="com.koko.mapper.UserMapperImpl">
        <property name="sqlSessionTemplate" ref="sqlSession"/>
    </bean>
    
</beans>
~~~

> 5、接口实现类UserMapperImpl

```java
package com.koko.mapper;

import com.koko.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{

    //我们的所有操作，原来都是用sqlSession来执行，现在都是用sqlSessionTemplate
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate (SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    public List<User> selectUser() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
```

> 6、测试类

```java
@Test
public void test01 (){
    ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserMapper userMapper = classPathXmlApplicationContext.getBean("userMapper", UserMapper.class);
    List<User> userList = userMapper.selectUser();

    for (User user : userList) {
        System.out.println(user);
    }
}
```

![image-20220210225513041](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210225513041.png)



### 8.3 整合Mybatis方式二

> 1、SqlSessionDaoSupport介绍

SqlSessionDaoSupport 是一个抽象的支持类，用来为你提供 SqlSession。

调用 getSqlSession() 方法你会得到一个 SqlSessionTemplate，之后可以用于执行 SQL 方法，实现流程如下：

![image-20220210231613916](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220210231613916.png)

> 2、UserMapperImpl2类

mybatis—>Spring整合实现类（自我定位）

```java
package com.koko.mapper;

import com.koko.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> selectUser() {
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
```

> 3、applicationContext.xml

```xml
<bean id="userMapper2" class="com.koko.mapper.UserMapperImpl2">
    <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
</bean>
```

> 4、小结

==实际上是整合mybatis一与整合mybatis二是一样的方法，只不过二继承了SqlSessionDaoSupport ，在getSqlSession()，做的也是setSqlSessionTemplate==

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20210126191106175.png)



## 9. 声明式事务

### 9.1 回顾事务

* 把一组业务当做一个业务来做，要么都成功，要么都失败！
* 事务在项目开发中，十分的重要，涉及到数据的一致性问题，不能马虎！
* 确保完整性和一致性！



> 事务ACID原则：

* 原子性
* 一致性
* 隔离性
  * 多个业务可能操作同一个资源，防止数据损坏
* 持久性
  * 事务一旦提交，无论系统发生什么问题，结果都不会被影响，被持久化的写到存储器中！



### 9.2 Spring中的事务管理

* 声明式事务：AOP（推荐）
* 编程式事务：需要在代码中进行事务管理

> spring-dao.xml中配置

配置事务的传播特性 propagation:

* 1、**PROPAGATION_REQUIRED**:如果当前没有事务，就新建一个事务，如果已存在一个事务中，加入到这个事务中，这是最常见的选择
* 2、PROPAGATION_SUPPORTS:支持当前事务，如果没有当前事务，就以非事务方法执行。
* 3、PROPAGATION_MANDATORY:使用当前事务，如果没有当前事务，就抛出异常。
* 4、PROPAGATION_REQUIRES_NEW:新建事务，如果当前存在事务，把当前事务挂起。
* 5、PROPAGATION_NOT_SUPPORTED:以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
* 6、PROPAGATION_NEVER:以非事务方式执行操作，如果当前事务存在则抛出异常。
* 7、**PROPAGATION_NESTED**:	如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED 类似的操作

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd">

    <import resource="spring-dao.xml"/>

    <bean id="userMapper" class="com.koko.mapper.UserMapperImpl2">
        <property name="sqlSessionTemplate" ref="sqlSession"/>
    </bean>
    <!--配置声明事务注入-->
    <!--要开启 Spring 的事务处理功能，在 Spring 的配置文件中创建一个 DataSourceTransactionManager 对象：-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
        <!--或者使用构造注入-->
        <!--<constructor-arg ref="dataSource" />-->
    </bean>

    <!--结合AOP实现事务的织入-->
    <!--配置事务通知-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <!--给哪些方法配置事务-->
        <tx:attributes>
            <tx:method name="add" propagation="REQUIRED"/>
            <tx:method name="delete" propagation="REQUIRED"/>
            <tx:method name="update" propagation="REQUIRED"/>
            <tx:method name="select" read-only="true"/>
            <!--全部方法-->
            <tx:method name="*" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>

    <!--配置事务切入-->
    <aop:config>
        <!--该包下的所有方法-->
        <aop:pointcut id="txPointCut" expression="execution(* com.koko.mapper.*.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
    </aop:config>
</beans>
~~~

> 思考：

为什么需要事务？

* 如果不配置事务，可能存在数据提交不一致的情况
* 如果我们不在spring中配置声明式事务，我们就需要在代码中手动配置事务！
* 事务在项目的开发中十分重要！设计到数据的一致性和完整性问题，不容马虎！

