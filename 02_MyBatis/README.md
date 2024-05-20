# MyBatis学习资源

> 学习大纲

![image-20220125092130444](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125092130444.png)



## 1. 简介

![](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125093230579.png)



### 1.1 什么是Mybatis？

* MyBatis 是一款优秀的持久层框架，
* 它支持自定义 SQL、存储过程以及高级映射。
* MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。
* MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

> 1、如何获得Mybatis

~~~xml
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.6</version>
</dependency>
~~~

- 中文文档：https://mybatis.org/mybatis-3/zh/index.html
- Github:https://github.com/mybatis/mybatis-3

### 1.2 持久化

> 1、数据持久化

- 持久化就是将程序的数据在持久状态和瞬时状态转化的过程
- 内存：**断电即失**
- 数据库（Jdbc），io文件持久化
- 生活方面例子：冷藏，罐头。

> **2、为什么需要持久化？**

- 不想丢掉一些对象
- 内存太贵



### 1.3 持久层

> 1、概述

Dao层，Service层，Controller层…

- 完成持久化工作的代码块
- 层界限十分明显



### 1.4 为什么需要Mybatis

> 1、特点（功能）

- 帮助程序猿将数据存入到数据库中
- 方便
- 传统的JDBC代码太复杂，简化–>框架–>自动化

> 2、优点

- 提供映射标签，支持对象与数据库的orm字段关系映射
- 提供对象关系映射标签，支持对象关系组建维护
- 提供xml标签，支持编写动态sql。

**最重要的一点：使用的人多！**

Spring-SpringMVC-SpringBoot



## 2. 第一个Mybatis程序

思路：搭建环境–>导入Mybatis–>编写代码–>测试



### 2.1 搭建环境

> 1、创建一个普通的Maven项目（子项目和父项目）

![image-20220125161150425](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125161150425.png)

- 新建一个普通maven项目
- 删除src目录
- 导入maven依赖

~~~xml
<!--1、jdk版本-->
<properties>
    <java.version>16</java.version>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>
</properties>

<!--2、在build中配置resources，来防止我们的资源导出失败问题-->
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

<dependencies>
    <!--1、mysql driver-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.16</version>
    </dependency>

    <!--2、mybatis-->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.6</version>
    </dependency>

    <!--3、junit-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
</dependencies>
~~~

> 2、创建数据库

![image-20220125165143267](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125165143267.png)



### 2.2 创建一个模块

> 1、编写mybatis的核心配置文件

![image-20220125161756166](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125161756166.png)

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<!--configuration core file-->
<configuration>

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

    <!--a Mapper.xml need regist in Mybatis core configuration file-->
    <mappers>
        <mapper resource="com/koko/dao/UserMapper.xml"/>
    </mappers>
</configuration>
~~~

注意：mysql8和mysql5的区别

> 2、编写mybatis工具类

![image-20220125161943964](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125161943964.png)

~~~java
package com.koko.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

//SqlSessionFactory -->SqlSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    
    static {
        try {
            //使用Mybaties第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
~~~



### 2.3 编写代码

> 1、实体类

![image-20220125162122458](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125162122458.png)

~~~java
package com.koko.pojo;

//实体类
public class User {
    private int id;
    private String name;
    private String pwd;

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
~~~

> 2、Dao接口

![image-20220125162224521](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125162224521.png)

~~~java
package com.koko.dao;

import com.koko.pojo.User;
import java.util.List;

public interface UserDao {
    List<User> getUserList();
}
~~~

> 3、Mapper配置文件

接口实现类由原来的UserDaoImpl转变成一个Mapper配置文件。

![image-20220125162254079](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125162254079.png)

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.koko.dao.UserDao">

    <!--selectAll-->
    <select id="getUserList" resultType="com.koko.pojo.User">
        select * from mybatis.user
    </select>

</mapper>
~~~

注意：不要在这个文件写中文除非配置文件编码改为GBK

~~~properties
<?xml version="1.0" encoding="GBK" ?>
~~~



### 2.4 测试

> 1、注意：(error)

- org.apache.ibatis.binding.BindingException: Type interface com.kuang.dao.UserDao is not known to the MapperRegistry.

**MapperRegistry是什么？**

核心配置文件中注册mappers

![image-20220125162443669](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125162443669.png)

> 2、junit测试

![image-20220125162556789](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125162556789.png)

~~~java
package com.koko.dao;

import com.koko.pojo.User;
import com.koko.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class UserDaoTest {

    @Test
    //1、查找全部数据
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }
}
~~~

> 3、测试结果

![image-20220125162644936](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125162644936.png)

可能遇到的问题：

1. 配置文件没有注册；
2. 绑定接口错误；
3. 方法名不对；
4. 返回类型不对；
5. Maven导出资源问题。



## 3. CRUD

### 3.1 namespace

namespace中的包名要和Dao/Mapper接口的包名一致！

![image-20220125190900961](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125190900961.png)



### 3.2 select查找

选择，查询语句；

- id:就是对应的namespace中的方法名；
- resultType:Sql语句执行的返回值！
- parameterType:参数类型！

> 1、编写接口

~~~java
//查询用户
User getUserById(int id);
~~~

> 2、编写对应的mapper中的sql语句

~~~xml
<!--select-->
    <select id="getUserById" parameterType="int" resultType="com.koko.pojo.User">
    select * from mybatis.user where id=#{id}
</select>
~~~

> 3、测试Test

~~~java
@Test
//2、查找某个人的信息
public void getUserById(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User user = mapper.getUserById(1);
    System.out.println(user);

    //关闭SqlSession
    sqlSession.close();
}
~~~

> 4、结果

![image-20220125191245932](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125191245932.png)



### 3.3 Insert添加

> 1、编写接口

~~~java
//添加用户
int addUser(User user);
~~~

> 2、编写对应的mapper中的sql语句

~~~xml
<!--insert-->
    <insert id="addUser" parameterType="com.koko.pojo.User">
    insert into mybatis.user (id,name,pwd) values (#{id},#{name},#{pwd})
    </insert>
~~~

> 3、测试Test

~~~java
@Test
//3、添加某个人的信息
public void addUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    int res = mapper.addUser(new User(4, "马六", "123"));
    if(res>0){
        System.out.println("插入成功！");
    }

    //提交事务
    sqlSession.commit();
    sqlSession.close();
}
~~~

> 4、结果

![image-20220125191556487](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125191556487.png)



### 3.4 Update修改

> 1、编写接口

~~~java
//修改用户
int updateUser(User user);
~~~

> 2、编写对应的mapper中的sql语句

~~~xml
<!--update-->
    <update id="updateUser" parameterType="com.koko.pojo.User">
    update mybatis.user set name=#{name},pwd=#{pwd} where id = #{id}
</update>
~~~



### 3.5 Delete删除

> 1、编写接口

~~~java
//删除用户
int deleteUser(int id);
~~~

> 2、编写对应的mapper中的sql语句

~~~xml
<!--delete-->
<delete id="deleteUser" parameterType="int">
    delete from mybatis.user where id = #{id}
</delete>
~~~

注意点：

- 增删改需要提交事务！



### 3.6 error分析

> 1、常见错误！！！

1. 标签不要匹配错！
2. resource绑定mapper，需要使用路径！
3. 程序配置文件必须符合规范！
4. NullPointerException，没有注册到资源！
5. maven资源没有导出问题！
6. xml文件中注释不能出现中文报错，查看自己的是UTF-8还是GBK编码，改成为相应的就行。

~~~properties
<?xml version="1.0" encoding="UTF-8" ?>
<?xml version="1.0" encoding="GBK" ?>
~~~

注释：在idea中点File-->Editor-->File Encodings 中Encoding都改为UTF-8就没有乱码了



### 3.7 万能Map

假设，我们的实体类，或者数据库中的表，字段或者参数过多，我们应当考虑使用Map！

> 1、步骤

1. Mapper接口类

~~~java
//改进Map
int addUser2(Map<String,Object> map);
~~~

2. Mapper接口实现类

```xml
<!--map for insert-->
<insert id="addUser2" parameterType="map">
    insert into mybatis.user (id,pwd) values (#{userid},#{password})
</insert>
```

3. 测试类

~~~java
@Test
//Map插入对象
public void addUser2(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("userid",4);
    map.put("password","123321");

    mapper.addUser2(map);

    sqlSession.commit();
    sqlSession.close();
}
~~~

> 2、测试

![image-20220125200958847](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125200958847.png)

1. Map传递参数，直接在sql中取出key即可【parameterType=“map”】
2. 对象传递参数，直接在sql中取对象的属性即可！【parameterType=“Object”】
3. 只有一个基本类型参数的情况下，可以直接在sql中取到！
4. 多个参数用Map，**或者注解！**



### 3.8 模糊查询

> 1、步骤

1. Mapper接口类

~~~java
//模糊查询
List<User> getUserLike(String s);
~~~

2. Mapper接口实现类

```xml
<!--select-->
    <select id="getUserLike" resultType="com.koko.pojo.User">
    select * from mybatis.user where name like #{value}
</select>
```

3. 测试类

~~~java
@Test
//模糊查询
public void getUserLike(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    List<User> userList = userMapper.getUserLike("%李%");

    for (User user : userList) {
        System.out.println(user);
    }

    //关闭SqlSession
    sqlSession.close();
}
~~~

> 2、测试

![image-20220125201243592](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125201243592.png)



## 4. 配置解析

### 4.1 核心配置文件

- mybatis-config.xml

![image-20220125201745663](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125201745663.png)

- MyBatis的配置文件包含了会深深影响MyBatis行为的设置和属性信息

![image-20220125201700530](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125201700530.png)

注意：编写配置文件时要按照图中顺序来，否则会报错！



### 4.2 环境配置（environments）

> 1、Mybatis可以配置成适应多种环境

![image-20220125221037971](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125221037971.png)

**不过要记住：尽管可以配置多个环境，但每个SqlSessionFactory实例只能选择一种环境。**
学会使用配置多套运行环境！

> 2、Mybatis默认的配置

事务管理器：JDBC

连接池：POOLED



### 4.3 属性（properties）

1、我们可以通过properties属性来实现引用配置文件

2、这些属性都是可外部配置且可动态替换的，既可以在典型的Java属性文件中配置，亦可通过properties元素的子元素来传递。【db.properties】

> 1、步骤

1. 编写一个配置文件【db.properties】

![image-20220125223121084](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125223121084.png)

~~~properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT
username=root
password=123456
~~~

2. 编写mybatis-config.xml

~~~xml
<!--1、properties-->
<properties resource="db.properties"/>

<!--2、environments-->
<environments default="development">
    <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"/>
            <property name="url" value="${url}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </dataSource>
    </environment>
</environments>

<!--3、mappers-->
<mappers>
    <mapper resource="com/koko/dao/UserMapper.xml"/>
</mappers>
~~~



### 4.4 类型别名（typeAliases）

> 1、第一个方法

- 类型别名是为Java类型设置一个短的名字。
- 存在的意义仅在于用来减少类完全限定名的冗余。

~~~xml
<!--可以给实体类起别名-->
<typeAliases>
    <typeAlias type="com.koko.pojo.User" alias="User"/>
</typeAliases>
~~~

1. 在UserMapper.xml中

![image-20220125234225791](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125234225791.png)

返回结果集设为User（缩写）

> 2、第二个方法

也可以指定一个包名，MyBatis会在包名下面搜索需要的JavaBean，比如：
扫描实体类的包，它的默认别名就为这个类的类名，**首字母小写**！

~~~xml
<!--可以给实体类起别名-->
<typeAliases>
    <package name="com.koko.pojo"/>
</typeAliases>
~~~

![image-20220125234746662](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220125234746662.png)

> 3、第三个方法

注：保留第二个方法的文件配置

1、在实体类比较少的时候，使用第一种方式。
		2、如果实体类十分多，建议使用第二种。
		3、第一种可以DIY别名，第二种则不行，如果非要改，需要在实体上增加注解

~~~java
//实体类
@Alias("hello")
public class User {}
~~~

![image-20220126000210877](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126000210877.png)



### 4.5 设置（settings）

![image-20220126001034048](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126001034048.png)

注：后续会讲，现在知道有这么个东西即可！



### 4.6 映射器（mappers）

> MapperRegistry：注册绑定我们的Mapper文件；	

方式一：【推荐使用】

~~~xml
<!--每一个Mapper.xml都需要在Mybatis核心配置文件中注册！-->
<mappers>
    <mapper resource="com/kuang/dao/UserMapper.xml"/>
</mappers>
~~~

方式二：使用class文件绑定注册

~~~xml
<!--每一个Mapper.xml都需要在Mybatis核心配置文件中注册！-->
<mappers>
    <mapper class="com.kuang.dao.UserMapper"/>
</mappers>
~~~

方式三：使用扫描包进行注入绑定

~~~xml
<!--每一个Mapper.xml都需要在Mybatis核心配置文件中注册！-->
<mappers>
    <package name="com.kuang.dao"/>
</mappers>
~~~

注意点（方法二和方法三）：

- 接口和它的Mapper配置文件必须同名！
- 接口和它的Mapper配置文件必须在同一个包下!

因此，用第一个方法百利无害！！！



### 4.7 其他配置

- typeHandlers（类型处理器）
- objectFactory（对象工厂）
- plugins（插件）
  1. mybatis-generator-core
  2. mybatis-plus
  3. 通用mapper

暂时不用了解！！！



### 4.8 生命周期和作用域

> 流程图解

![image-20220126100603798](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126100603798.png)

生命周期和作用域是至关重要的，因为错误的使用会导致非常严重的**并发问题**。

> **1、SqlSessionFactoryBuilder：**

- 一旦创建了 SqlSessionFactory，就不再需要它了。
- 局部变量

![image-20220126101748274](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126101748274.png)

> **2、SqlSessionFactory：**

- 说白就是可以想象为：数据库连接池。
- SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，**没有任何理由丢弃它或重新创建另一个实例**。
- SqlSessionFactory 的最佳作用域是应用作用域。
- 最简单的就是使用**单例模式**或者静态单例模式。

![image-20220126101917464](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126101917464.png)

> **3、SqlSession：**

- 连接到连接池的一个请求！
- SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。
- 用完后需要赶紧关闭，否则资源被占用！

![image-20220126101945423](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126101945423.png)

![image-20220126102031713](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126102031713.png)

> 业务流程图

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201023104427946.png)

这里的每一个Mapper，就代表一个具体的业务！



## 5. 属性名&字段问题

### 5.1 解决属性名和字段名不一致的问题

> 1、数据库中的字段

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201023111734299.png)

新建一个项目，拷贝之前的，测试实体类字段不一致的情况

~~~java
public class User {
    private int id;
    private String name;
    private String password;
}
~~~

测试出现问题

![image-20220126104444879](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126104444879.png)

>2、解决方法

* 起别名

~~~xml
<select id="getUserById" parameterType="int" resultType="user">
    select id,name,pwd as password from mybatis.user where id = #{id}
</select>
~~~

- resultMap解决



### 5.2 ResultMap（*）

> 概述：结果集映射

~~~properties
id name pwd
id name password
~~~

~~~xml
<resultMap id="UserMap" type="User">
    <!--column数据库中的字段，property实体类中的属性-->
    <result column="id" property="id"></result>
    <result column="name" property="name" />
    <result column="pwd" property="password" />
    </resultMap>

    <!--select-->
    <select id="getUserById" resultMap="UserMap">
    select * from mybatis.user where id=#{id}
</select>
~~~

![image-20220126110645468](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126110645468.png)

>resultMap的特点

- resultMap 元素是 MyBatis 中最重要最强大的元素。
- ResultMap 的设计思想是，对简单的语句做到零配置，对于复杂一点的语句，只需要描述语句之间的关系就行了。
- ResultMap 的优秀之处——你完全可以不用显式地配置它们。

![image-20220126110855217](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126110855217.png)

- 如果这个世界总是这么简单就好了。



## 6. 日志

### 6.1 日志工厂

 如果一个数据库操作出现了异常，我们需要排错。日志就是最好的助手！

* 曾经：sout、debug
* 现在：日志工厂！

![image-20220126113225707](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126113225707.png)

- SLF4J
- LOG4J 【掌握】
- LOG4J2
- JDK_LOGGING
- COMMONS_LOGGING
- STDOUT_LOGGING【掌握】
- NO_LOGGING

在Mybatis中具体使用哪一个日志实现，在设置中设定！

> **STDOUT_LOGGING**标准日志输出

在mybatis-config.xml核心配置文件中，配置我们的日志！

~~~xml
<settings>
    <setting name="logImpl" value="STDOUT_LOGGING"/>
</settings>
~~~

![image-20220126114536419](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126114536419.png)



### 6.2 Log4j

> 什么是Log4j？

* Log4j是Apache的一个开源项目，通过使用Log4j，我们可以控制日志信息输送的目的地是控制台、文件、GUI组件;
* 我们也可以控制每一条日志的输出格式;
* 通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程;
* 可以通过一个配置文件来灵活地进行配置，而不需要修改应用的代码;

>1、先在pom.xml文件中导入log4j的依赖包

~~~xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/log4j/log4j -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
    </dependency>
</dependencies>
~~~

> 2、在resources文件夹下建立log4j.properties文件进行配置

~~~properties
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
log4j.rootLogger = DEBUG,console ,file

#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold = DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern =  [%c]-%m%n

#文件输出的相关设置
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File = ./log/koko.txt
log4j.appender.file.MaxFileSize = 10mb
log4j.appender.file.Threshold = DEBUG
log4j.appender.file.layout = org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern = [%p][%d{yy-MM-dd}][%c]%m%n

#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
~~~

> 3.在mybatis-config.xml核心配置文件，配置log4j为日志的实现

~~~xml
<settings>
    <setting name="logImpl" value="LOG4J"/>
</settings>
~~~

> 4.Log4j的使用，直接测试运行

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201024101856564.png)

> **5、简单使用**

1. 在要使用Log4j的测试类中，导入包import org.apache.log4j.Logger;
2. 日志对象，参数为当前类的class

~~~java
static Logger logger = Logger.getLogger(UserDaoTest.class);
~~~

​	3.日志级别

~~~java
@Test
//1、编写日志
public void testlog4j(){
    logger.info("info:进入了testLog4j");
    logger.debug("DEBUG:进入了testLog4j");
    logger.error("erro:进入了testLog4j");
}
~~~

​	4.之后可在log文件夹中查看日志文件信息

![image-20220126135150342](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126135150342.png)



## 7. 分页

> **思考：为什么要分页！**

- 减少数据的处理量



### 7.1 使用Limit分页

~~~mysql
语法：SELECT * from user limit startIndex,pageSize
SELECT  * from user limit 3 #[0,n)
~~~

**使用Mybatis实现分页，核心SQL**

> 1、接口

~~~java
//分页
List<User> getUserByLimit(Map<String,Integer> map);
~~~

> 2、Mapper.xml

~~~xml
<!--分页-->
<select id="getUserByLimit" parameterType="map" resultMap="UserMap">
    select * from mybatis.user limit #{startIndex},#{pageSize}
</select>
~~~

> 3、测试

~~~java
@Test
public void getUserByLimit(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("startIndex",0);
    map.put("pageSize",2);

    List<User> userList = mapper.getUserByLimit(map);
    for (User user : userList) {
        System.out.println(user);
    }

    sqlSession.close();
}
~~~

![image-20220126141938427](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126141938427.png)



### 7.2 RowBounds分页

注：无用，了解

作用：不再使用SQL实现分页

> 1、接口

~~~java
//分页2
List<User> getUserByRowBounds();
~~~

> 2、Mapper.xml

~~~xml
<!--分页2-->
<select id="getUserByRowBounds" resultMap="UserMap">
    select * from mybatis.user
</select>
~~~

> 3、测试

~~~java
@Test
public void getUserByRowBounds(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    //RowBounds实现
    RowBounds rowBounds = new RowBounds(0, 2);

    //通过java代码层面实现分页
    List<User> userList = sqlSession.selectList("com.koko.dao.UserMapper.getUserByRowBounds",null,rowBounds);

    for (User user : userList) {
        System.out.println(user);
    }

    sqlSession.close();
}
~~~



### 7.3 分页插件

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20201024131905259.png)

了解即可，使用时，需要知道是什么东西！



## 8. 使用注解开发

### 8.1 面向接口编程

- 之前学过面向对象编程，也学习过接口，但在真正的开发中，很多时候会选择面向接口编程。
- **根本原因：解耦，可拓展，提高复用，分层开发中，上层不用管具体的实现，大家都遵守共同的标准，使得开发变得容易，规范性更好**

- 在一个面向对象的系统中，系统的各种功能是由许许多多的不同对象协作完成的。在这种情况下，各个对象内部是如何实现自己的，对系统设计人员来讲就不那么重要了；
- 而各个对象之间的协作关系则成为系统设计的关键。小到不同类之间的通信，大到各模块之间的交互，在系统设计之初都是要着重考虑的，这也是系统设计的主要工作内容。面向接口编程就是指按照这种思想来编程。



### 8.2 使用注解开发

> 1、注解在UserMapper接口上实现，并删除UserMapper.xml文件

~~~java
@Select("select * from user")
List<User> getUsers();
~~~

> 2、需要在mybatis-config.xml核心配置文件中绑定接口

~~~xml
<!--绑定接口！-->
<mappers>
    <mapper class="com.koko.dao.UserMapper" />
</mappers>
~~~

> 3、测试

~~~java
@Test
public void getUsers(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    //底层主要应用反射
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    List<User> users = mapper.getUsers();

    for (User user : users) {
        System.out.println(user);
    }
    sqlSession.close();
}
~~~

本质：反射机制实现
		底层：动态代理！

![image-20220126160749766](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126160749766.png)

> 4、开发原理

![image-20220126160205780](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126160205780.png)

**Mybatis详细的执行流程！（之后应用的多了详细再走一遍）**

![image-20220126161943962](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126161943962.png)

【暂不分析】



### 8.3 CRUD

> 1、在MybatisUtils工具类创建的时候实现自动提交事务！

~~~java
public static SqlSession getSqlSession(){
    return sqlSessionFactory.openSession(true);
}
~~~

> 2、编写接口，增加注解

~~~java
public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有参数前面必须加上@Param("id")注解
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);

}
~~~

> 3、测试类（举两个例子）

~~~java
@Test
//查询某人信息
public void test02(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    //底层主要应用反射
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    User userByID = mapper.getUserById(1);
    System.out.println(userByID);

    sqlSession.close();
}

@Test
//添加某人信息
public void test03(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    //底层主要应用反射
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    mapper.addUser(new User(4,"赵六","123456"));

    sqlSession.close();
}
~~~

【注意：我们必须要将接口注册绑定到我们的核心配置文件中！】



### 8.4 **关于注解**

> **1、关于@Param()注解**

- 基本类型的参数或者String类型，需要加上

- 引用类型不需要加

- 如果只有一个基本类型的话，可以忽略，但是建议都加上！

* 我们在SQL中引用的就是我们这里的@Param("")中设定的属性名！

**#{}和${}区别**：#{}可以防止sql注入，所以一般不写${}

> 2、要记的注解

~~~java
//一般的增删改查和Param
@Select()
@Insert()
@Update()
@Delete()
@Param()
~~~



## 9. Lombok

> 使用步骤：

1. 在IDEA中安装Lombok插件！
2. 在项目pom.xml文件中导入Lombok的jar包

![image-20220126165907126](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220126165907126.png)

~~~xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.10</version>
</dependency>
~~~

​	3.在实体类上加注解即可！

~~~properties
//常用：
@Data
@AllArgsConstructor
@NoArgsConstructor
~~~

![image-20220127001726236](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127001726236.png)

~~~properties
@Getter and @Setter
@FieldNameConstants
@ToString
@EqualsAndHashCode
@AllArgsConstructor, @RequiredArgsConstructor and @NoArgsConstructor
@Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j, @CommonsLog, @JBossLog, @Flogger, @CustomLog
@Data
@Builder
@SuperBuilder
@Singular
@Delegate
@Value
@Accessors
@Wither
@With
@SneakyThrows
~~~

> 说明：

~~~properties
@Data:无参构造、get、set、toString、hashCode、equals
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter and @Setter
~~~



## 10. 多对一处理

> 1、多对一概念

- 多个学生，对应一个老师
- 对于学生而言，**关联**–多个学生，关联一个老师【多对一】
- 对于老师而言，**集合**–一个老师，有很多个学生【一对多】

关联：association

集合：collection

>  2、SQL语句：

~~~mysql
CREATE TABLE `teacher` (
	`id` INT(10) NOT NULL,
	`name` VARCHAR(30) DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE = INNODB DEFAULT CHARSET=utf8

INSERT INTO teacher(`id`,`name`) VALUES (1,'秦老师');

CREATE TABLE `student` (
	`id` INT(10) NOT NULL,
	`name` VARCHAR(30) DEFAULT NULL,
	`tid` INT(10) DEFAULT NULL,
	PRIMARY KEY (`id`),
	KEY `fktid`(`tid`),
	CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
)ENGINE = INNODB DEFAULT CHARSET=utf8

INSERT INTO `student`(`id`,`name`,`tid`) VALUES ('1','小明','1');
INSERT INTO `student`(`id`,`name`,`tid`) VALUES ('2','小红','1');
INSERT INTO `student`(`id`,`name`,`tid`) VALUES ('3','小张','1');
INSERT INTO `student`(`id`,`name`,`tid`) VALUES ('4','小李','1');
INSERT INTO `student`(`id`,`name`,`tid`) VALUES ('5','小王','1');
~~~

![image-20220127012541351](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127012541351.png)

> 3、多表之间的关系

![image-20220127013522346](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127013522346.png)



### 10.1 测试环境搭建

> 1、导入Lombok

~~~xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
    <scope>provided</scope>
</dependency>
~~~

> 2、新建实体类Teacher，Student

![image-20220127012718372](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127012718372.png)

~~~java
@Data
public class Student {
    private int id;
    private String name;

    //学生关联一个老师！
    private Teacher teacher;
}

@Data
public class Teacher {
    private int id;
    private String name;
}
~~~

> 3、建立Mapper接口

![image-20220127012936282](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127012936282.png)

~~~java
package com.koko.dao;

import com.koko.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//老师类dao接口
public interface TeacherMapper {

    @Select("select * from teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);
}
~~~

> 4、建立Mapper.XML文件

![image-20220127012958415](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127012958415.png)

~~~xml
<?xml version="1.0" encoding="GBK" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.koko.dao.StudentMapper"></mapper>

<?xml version="1.0" encoding="GBK" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.koko.dao.TeacherMapper"></mapper>
~~~

> 5、在核心配置文件mybatis-config.xml中

绑定注册我们的Mapper接口或者文件！【方式很多,随心选】

~~~xml
<mappers>
    <mapper class="com.koko.dao.TeacherMapper"/>
    <mapper class="com.koko.dao.StudentMapper"/>
</mappers>
~~~

> 6、测试查询是否能够成功！

![image-20220127013155866](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127013155866.png)



> 7、问题：

java包和resources包下的包折叠也可能发生Mapper接口找不到的情况！

![image-20220127223914478](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127223914478.png)

![image-20220127223846236](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127223846236.png)

解决思路：resources包一层层建立以及调整以下两个配置

![image-20220127224117756](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220127224117756.png)



### 10.2 嵌套处理（*）

> **1、按照结果嵌套处理（*）**

相当于“联表查询”！！！

~~~xml
<!--按照结果嵌套处理    -->
<select id="getStudent2" resultMap="StudentTeacher2">
    select s.id sid,s.name sname,t.name tname
    from mybatis.student s,mybatis.teacher t
    where s.tid = t.id
</select>

<resultMap id="StudentTeacher2" type="Student">
    <result property="id" column="sid"/>
    <result property="name" column="sname"/>
    <association property="teacher" javaType="Teacher">
        <result property="name" column="tname"/>
    </association>
</resultMap>
~~~

> 2、按照查询嵌套处理

相当于“子查询”！！！

~~~xml
<!--
思路：
   1.查询所有的学生信息
   2.根据查询出来的学生的tid，寻找对应的老师！ 子查询-->
<select id="getStudent" resultMap="StudentTeacher">
    select * from mybatis.student
</select>

<resultMap id="StudentTeacher" type="Student">
    <result property="id" column="id"/>
    <result property="name" column="name"/>
    <!--  复杂的属性，我们需要单独处理 对象：association 集合：collection      -->
    <association property="teacher" column="tid" javaType="Teacher" select="getTeacher"/>
</resultMap>

<select id="getTeacher" resultType="Teacher">
    select * from mybatis.teacher where id = #{id}
</select>
~~~



## 11. 一对多处理

比如：一个老师拥有多个学生！
		对于老师而言，就是一对多的关系！

### 11.1 测试环境搭建

环境搭建，和刚才一样

> **1、实体类：**

~~~java
@Data
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;

    //一个老师拥有多个学生
    private List<Student> students;
}

@Data
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int tid;
}
~~~



### 11.2 嵌套处理（*）

> **1、按照结果嵌套处理（*）**

~~~xml
<!--    按结果嵌套查询-->
<select id="getTeacher" resultMap="TeacherStudent">
    SELECT  s.id sid,s.name sname,t.name tname,t.id,tid
    from student s,teacher t
    where s.tid = t.id and t.id = #{tid}
</select>

<resultMap id="TeacherStudent" type="Teacher">
    <result property="id" column="tid"/>
    <result property="name" column="tname"/>
    <!--  复杂的属性，我们需要单独处理 对象：association 集合：collection
             javaType="" 指定属性的类型！
             集合中的泛型信息，我们使用ofType获取
             -->
    <collection property="students" ofType="Student">
        <result property="id" column="sid"/>
        <result property="name" column="sname"/>
        <result property="tid" column="tid"/>
    </collection>
</resultMap>
~~~

> 2、按照查询嵌套处理

~~~xml
<select id="getTeacher2" resultMap="TeacherStudent2">
    select * from mybatis.teacher where id = #{tid}
</select>

<resultMap id="TeacherStudent2" type="Teacher">
    <collection property="students" javaType="ArrayList" ofType="Student" select="getStudentByTeacherId" column="id"/>
</resultMap>

<select id="getStudentByTeacherId" resultType="Student">
    select * from  mybatis.student where tid = #{tid}
</select>
~~~

![image-20220128142839097](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128142839097.png)



### 11.3 小结

1. 关联-association【多对一】
2. 集合-collection【一对多】
3. **javaType** & **ofType**
   1. javaType 用来指定实体类中属性的类型
   2. ofType 用来指定映射到List或者集合中的pojo类型，泛型中的约束类型！

> 注意点：

- 保证SQL的可读性，尽量保证通俗易懂
- 注意一对多和多对一中，属性名和字段的问题！
- 如果问题不好排查错误，可以使用日志，建议使用Log4j

> **面试高频**

- Mysql引擎
- InnoDB底层原理
- 索引
- 索引优化



## 12. 动态SQL

**什么是动态SQL：**

​	**==动态SQL就是 指根据不同的条件生成不同的SQL语句==**

~~~xml
if
trim (where, set)
choose (when, otherwise)
foreach
~~~



### 12.1 搭建环境

> 1、创建数据库

~~~mysql
CREATE TABLE `blog`(
	`id` VARCHAR(50) NOT NULL COMMENT '博客id',
	`title` VARCHAR(100) NOT NULL COMMENT '博客标题',
	`author` VARCHAR(30) NOT NULL COMMENT '博客作者',
	`create_time` DATETIME NOT NULL COMMENT '创建时间',
	`views` INT(30) NOT NULL COMMENT '浏览量'
)ENGINE=INNODB DEFAULT CHARSET=utf8
~~~

> 2、编写配置文件和工具类

![image-20220128150710867](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128150710867.png)

~~~java
//设置随机id
public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }
}
~~~

记得配置文件的映射mapper要修改

![image-20220128150743574](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128150743574.png)

> 3、编写实体类

~~~java
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime; //属性名和字段名不一致
    private int views;
}
~~~

> 4、编写实体类对应Mapper接口和Mapper.XML文件

![image-20220128151008270](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128151008270.png)

~~~java
//插入数据
    int addBlog(Blog blog);
~~~

~~~xml
<?xml version="1.0" encoding="GBK" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.koko.dao.BlogMapper">

<insert id="addBlog" parameterType="blog">
    insert into blog(id,title,author,create_time,views)
    values (#{id},#{title},#{author},#{createTime},#{views});
</insert>

</mapper>
~~~

> 5、测试类

~~~java
@Test
public void test01(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

    Blog blog = new Blog();
    blog.setId(IDutils.getId());
    blog.setTitle("1");
    blog.setAuthor("张三");
    blog.setCreateTime(new Date());
    blog.setViews(999);
    mapper.addBlog(blog);

    blog.setId(IDutils.getId());
    blog.setTitle("2");
    mapper.addBlog(blog);

    blog.setId(IDutils.getId());
    blog.setTitle("3");
    mapper.addBlog(blog);

    blog.setId(IDutils.getId());
    blog.setTitle("4");
    mapper.addBlog(blog);

    sqlSession.close();
}
~~~

![image-20220128151159459](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128151159459.png)



### 12.2 IF标签

> 1、Mapper接口

```java
//查询博客
List<Blog> queryBlogIF(Map map);
```

> 2、Mapper接口的实现类

```xml
<select id="queryBlogIF" parameterType="map" resultType="Blog">
    select * from mybatis.blog where 1=1
    <if test="title != null">
        and title = #{title}
    </if>
    <if test="author != null">
        and author = #{author}
    </if>
</select>
```

> 3、测试类

```java
@Test
public void test02(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

   HashMap map=new HashMap();
   map.put("title","1");

    List<Blog> blogs = mapper.queryBlogIF(map);

    for(Blog blog:blogs){
        System.out.println(blog);
    }
    sqlSession.close();
}
```

![image-20220128162643410](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128162643410.png)



### 12.3 trim标签

> 1、Mapper接口

```java
//查询博客if
List<Blog> queryBlogIF(Map map);

//修改博客trim
int updateBlog(Map map);
```

> 2、Mapper接口的实现类

~~~xml
<!--if的完善方法-->
<select id="queryBlogIF" parameterType="map" resultType="Blog">
    select * from mybatis.blog
    <where>
        <if test="title != null">
            and title = #{title}
        </if>
        <if test="author != null">
            and author = #{author}
        </if>
    </where>
</select>

<update id="updateBlog" parameterType="map">
    update mybatis.blog
    <set>
        <if test="title != null">
            title = #{title},
        </if>
        <if test="author != null">
            author = #{author}
        </if>
    </set>
    where id = #{id}
</update>
~~~

> 3、测试类

~~~java
//第一种方法结果与if相同,所以不展示
@Test
public void test04(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

    HashMap map=new HashMap();
    map.put("id","aad349619f7043538c9f27077c11db87");
    map.put("title","1");

    mapper.updateBlog(map);

    sqlSession.close();
}
~~~

![image-20220128185128656](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128185128656.png)

![image-20220128185148805](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128185148805.png)



### 12.4 choose标签

> 1、Mapper接口

```java
//查询博客choose
List<Blog> queryBlogChoose(Map map);
```

> 2、Mapper接口的实现类

```xml
<select id="queryBlogChoose" parameterType="map" resultType="Blog">
    select * from mybatis.blog
    <where>
        <choose>
            <when test="title != null">
                title = #{title}
            </when>
            <when test="author != null">
                author = #{author}
            </when>
            <otherwise>
                views = #{views}
            </otherwise>
        </choose>
    </where>
</select>
```

>3、测试类

```java
@Test
public void test03(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

    HashMap map=new HashMap();
    map.put("title","1");

    List<Blog> blogs = mapper.queryBlogChoose(map);

    for(Blog blog:blogs){
        System.out.println(blog);
    }
    sqlSession.close();
}
```

![image-20220128185411929](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128185411929.png)

==**所谓的动态SQL，本质还是SQL语句，只是我们可以在SQL层面，去执行一个逻辑代码**==



### 12.5 Foreach标签

![image-20220128190807106](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128190807106.png)

> 1、Mapper接口

```java
//查询1,2,3号记录的博客
List<Blog> queryBlogForeach(Map map);
```

> 2、Mapper接口的实现类

```xml
<!--select * from blog where 1=1 and (id=1 or id=2 or id=3)
    我们现在传递一个万能的map，这map中可以存在一个集合！
    -->
<select id="queryBlogForeach" parameterType="map" resultType="Blog">
    select * from mybatis.blog
    <where>
        <foreach collection="ids" item="id" open="and (" close=")" separator="or">
            id = #{id}
        </foreach>
    </where>
</select>
```

>3、测试类

```java
@Test
public void test05(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

    HashMap map=new HashMap();

    ArrayList<Integer> ids=new ArrayList<>();
    ids.add(1);
    ids.add(2);
    ids.add(3);

    map.put("ids",ids);
    List<Blog> blogs = mapper.queryBlogForeach(map);

    for (Blog blog : blogs) {
        System.out.println(blog);
    }

    sqlSession.close();
}
```

![image-20220128202511395](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128202511395.png)



### 12.6 SQL片段

有的时候，我们可以能会将一些功能的部分抽取出来，方便复用（公共类）

> 1、使用SQL标签抽取公共的部分

```xml
<sql id="if-title-author">
    <if test="title != null">
        title = #{title}
    </if>
    <if test="author != null">
        and author = #{author}
    </if>
</sql>
```

> 2、在需要使用的地方使用Include标签引用即可

```xml
<select id="queryBlogIF" parameterType="map" resultType="Blog">
    select * from mybatis.blog
    <where>
        <include refid="if-title-author"></include>
    </where>
</select>
```



> 动态sql总结

==动态SQL就是在拼接SQL语句，我们只要保证SQL的正确性，按照SQL的格式，去排列组合就可以了 。==

建议：

- 先在Mysql中写出完整的SQL，再对应的去修改成我们的动态SQL实现通用即可！



## 13. 缓存

### 13.1 简介

> 1、什么是缓存[Cache]？

- 存在内存中的临时数据。
- 将用户经常查询的数据放在缓存（内存）中，用户去查询数据就不用从磁盘上（关系型数据库查询文件）查询，从缓存中查询，从而提高查询效率，解决了==高并发系统==的性能问题。

> 2、为什么使用缓存？

- 减少和数据库的交互次数，减少系统开销，提高系统效率。

> **3、什么样的数据能使用缓存？**

- 经常查询并且不经常改变的数据。【可以使用缓存】



### 13.2 Mybatis缓存

- Mybatis包含一个非常强大的查询缓存特性，它可以非常方便地定制和配置缓存。缓存可以极大的提升查询效率。
- Mybatis系统中默认定义了两级缓存：**一级缓存**和**二级缓存**

- 默认情况下，只有一级缓存开启。（SqlSession级别的缓存，也称为本地缓存）
- 二级缓存需要手动开启和配置，它是基于namespace级别的缓存。
- 为了提高扩展性，Mybatis定义了缓存接口Cache，我们可以通过实现Cache接口来自定义二级缓存。



### 13.3 一级缓存

- 一级缓存也叫本地缓存：
  - 与数据库同一次会话期间查询到的数据会放在本地缓存中。
  - 以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库

> 测试步骤：

1. 开启日志！
2. 测试在一个Session中查询两次相同记录

~~~java
//Mapper接口
//根据id查询用户
User queryUserById(@Param("id")int id);

//Mapper接口实现类
<select id="queryUserById" resultType="user">
    select * from user where id=#{id}
</select>
~~~

~~~java
//测试类
@Test
public void test01(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    User user01 = mapper.queryUserById(1);
    System.out.println(user01);

    System.out.println("================");

    User user02 = mapper.queryUserById(1);
    System.out.println(user02);

    sqlSession.close();
}
~~~

​	3.查看日志输出

![image-20220128212128999](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128212128999.png)

此时只有开启了一次数据库连接池，缓存成功（自带功能）

> 缓存失效的情况：

1. 查询不同的东西；
2. 增删改操作，可能会改变原来的数据，所以必定会刷新缓存！

![image-20220128215205314](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128215205314.png)

​	3.查询不同的Mapper.xml

​	4.手动清理缓存！

![image-20220128215324795](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128215324795.png)

小结：一级缓存默认是开启的，只在一次SqlSession中有效，也就是拿到连接到关闭连接这个区间段！
==一级缓存相当于一个Map==



### 13.4 二级缓存

![image-20220128215525111](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128215525111.png)

- 二级缓存也叫全局缓存，一级缓存作用域太低了，所以诞生了二级缓存；
- 基于namespace级别的缓存，一个名称空间，对应一个二级缓存；

> 1、工作机制

- 一个会话查询一条数据，这个数据就会被放在当前会话的一级缓存中；
- 如果当前会话关闭了，这个会话对应的一级缓存就没了；但是我们想要的是，会话关闭了，一级缓存中的数据被保存到二级缓存中；
- 新的会话查询信息，就可以从二级缓存中获取内容；
- 不同的mapper查出的数据就会放在自己对应的缓存（map）中；

> 2、步骤

1. 在mybatis-config.xml开启全局缓存

~~~xml
<!--显示的开启全局缓存-->
<setting name="cacheEnabled" value="true"/>
~~~

​	2.在要使用二级缓存的Mapper中开启

~~~xml
<!--在当前Mapper.xml中使用二级缓存-->
<cache/>
~~~

也可以自定义参数

~~~xml
<!--在当前Mapper.xml中使用二级缓存-->
<cache
       eviction="FIFO"
       flushInterval="60000"
       size="512"
       readOnly="true"/>
~~~

> 3、测试

~~~java
@Test
public void test02(){
    SqlSession sqlSession01 = MybatisUtils.getSqlSession();
    UserMapper mapper01 = sqlSession01.getMapper(UserMapper.class);
    SqlSession sqlSession02 = MybatisUtils.getSqlSession();
    UserMapper mapper02 = sqlSession02.getMapper(UserMapper.class);

    User user01 = mapper01.queryUserById(1);
    System.out.println(user01);
    sqlSession01.close();

    System.out.println("================");

    User user02 = mapper02.queryUserById(1);
    System.out.println(user02);
    System.out.println(user01==user02);
    sqlSession02.close();
~~~

![image-20220128221211778](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128221211778.png)

> 4、问题

如果没有自定义参数，则会报错，我们需要将实体类序列化！

~~~xml
Cause: java.io.NotSerializableException: com.kuang.pojo.User
~~~

![image-20220128221323211](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128221323211.png)

> 5、小结

- 只要开启了二级缓存，在同一个Mapper下就有效；
- 所有的数据都会先放在一级缓存中；
- 只有当会话提交或者关闭的时候，才会提交到二级缓存中！



### 13.5 缓存原理

![image-20220128222249189](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220128222249189.png)



### 13.6 自定义缓存-ehcache（可以了解）

Ehcache是一种广泛使用的开源Java分布式缓存，主要面向通用缓存。

要在程序中使用ehcache，先要导包！

在mapper中指定使用我们的ehcache缓存实现！

==**目前：Redis数据库来做缓存！K-V**==

