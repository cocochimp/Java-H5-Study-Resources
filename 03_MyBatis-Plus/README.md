# MyBatis-Plus学习资源

## 1. 简介

> 1、什么是Mybatis-plus？

官网：[MyBatis-Plus (baomidou.com)](https://baomidou.com/)

![在这里插入图片描述](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20200930150327276.png)

> 2、特性

- **无侵入**：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
- **损耗小**：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
- **强大的 CRUD 操作**：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
- **支持 Lambda 形式调用**：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错
- **支持主键自动生成**：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题
- **支持 ActiveRecord 模式**：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作
- **支持自定义全局通用操作**：支持全局通用方法注入（ Write once, use anywhere ）
- **内置代码生成器**：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用
- **内置分页插件**：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询
- **分页插件支持多种数据库**：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer 等多种数据库
- **内置性能分析插件**：可输出 SQL 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
- **内置全局拦截插件**：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作



## 2. 编写第一个程序

### 2.1 快速入门

> 流程

1. 导入对应的依赖
2. 研究依赖如何配置
3. 代码如何编写
4. 提高扩展技术能力

> 步骤

1. 创建数据库`mybatis_plus`

```mysql
USE mybatis_plus;

--创建表
CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);
-- 真实开发中，version(乐观锁)、deleted(逻辑删除)、gmt_create、gmt_modified

--插入数据
INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
```

2. 创建SpringBoot项目`Mybatis-plus_Study`
3. 导入依赖

```xml
<!--数据库驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.20</version>
</dependency>

<!--mybatis-plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.0.5</version>
</dependency>

<!--lombok-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

* 尽量不要同时导入mybatis和mybatis-plus，因为版本有差异！

4. application.properties连接数据库

```properties
# mysql 5 驱动不同  com.mysql.jdbc.Driver

# mysql 8 驱动不同 com.mysql.cj.jdbc.Driver . 需要增加时区的配置 serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis_plus?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

5. 持久层编写

**传统的方式pojo-dao(连接mybatis,配置mapper.xml文件)-service-controller，而使用mybatis-plus之后：**

* User实体类

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```

* mapper接口

```java
//在对应的mapper上面继承基本的类 BaseMapper
@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {
    //所有CRUD操作都已经编写完成了
    //你不需要向以前一样配置一大堆文件了!
}
```

6. 主启动类`MybatisPlusApplication`扫描我们Mapper包下的所有接口

```java
//扫描我们的 mapper 文件夹
@MapperScan("com.koko.mapper")
```

7. 测试类测试

```java
@SpringBootTest
class MybatisPlusApplicationTests {

    //继承了BaseMapper, 所有的方法都来自己父类
    //我们也可以编写自己的扩展方法
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //参数是一个Wrapper , 条件构造器,这里我们先不用 --null
        //查询全部用户
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
```

> 运行

![image-20220331171921820](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331171921820.png)

思考：

1. sql谁帮我们写的?—mybatis-plus
2. 方法谁帮我们写的?—mybatis-pluss





### 2.2 配置日志

> 测试

```properties
# 配置日志  (默认控制台输出)
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

![image-20220331172050814](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331172050814.png)



## 3. CRUD扩展

### 3.1 主键生成策略

> 概述

默认 ID_WORKER 全局唯一id

对应数据库中的主键(uuid.自增id.雪花算法.redis.zookeeper)

分布式系统唯一id生成:[分布式系统唯一ID生成方案汇总](https://www.cnblogs.com/haoxinyue/p/5208136.html)

**雪花算法**😦**Twitter的snowflake算法**)

snowflake是Twitter开源的分布式ID生成算法，结果是一个long型的ID。其核心思想是：使用41bit作为毫秒数，10bit作为机器的ID（5个bit是数据中心，5个bit的机器ID），12bit作为毫秒内的流水号（意味着每个节点在每毫秒可以产生 4096 个 ID），最后还有一个符号位，永远是0.可以保证几乎全球唯一

> 1、主键自增

1. 实体类字段上加注释

```java
@TableId(type = IdType.AUTO)
```

2. 数据库字段`自增`！

![image-20220331173216815](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331173216815.png)

3. 测试类测试

```java
@Test
public void testInsert(){
    User user = new User();
    user.setName("koko");
    user.setAge(3);
    user.setEmail("2427886409@qq.com");

    int result = userMapper.insert(user);
    System.out.println(result);
    System.out.println(user);
}
```

![image-20220331174852444](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331174852444.png)

> 拓展：其余源码解释

```java
public enum IdType {     
    AUTO(0),//数据库ID自增  
    NONE(1),//该类型为未设置主键类型      
    INPUT(2),//用户输入ID
      		 //该类型可以通过自己注册自动填充插件进行填充  
    
	//以下3种类型、只有当插入对象ID 为空，才自动填充。     
    ID_WORKER(3),//全局唯一ID (idWorker)      
    UUID(4),//全局唯一ID (UUID)          
    ID_WORKER_STR(5);//字符串全局唯一ID (idWorker 的字符串表示)       
}
```



### 3.2 更新数据

> 动态sql

1. 测试类测试

```java
//测试更新
@Test
public void testUpdate(){
    User user = new User();
    user.setId(2L);
    user.setName("giao");

    //注意:updateById()参数是 一个对象!
    int i = userMapper.updateById(user);
    System.out.println(i);
}
```

![image-20220331175211083](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331175211083.png)

![image-20220331175324080](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331175324080.png)

* 所有的sql都是动态帮你配置的！！！



### 3.3 自动填充

> 概述

创建时间 . 修改时间! 这些个操作都是自动化完成的,我们不希望手动更新!

阿里巴巴开发手册:所有的数据库表:gmt_create .gmt_modified几乎所有的表都要配置上!而且需要自动化!

> 方式一:数据库级别

1. 在表中新增字段 create_time , update_time

![image-20220331175454700](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331175454700.png)

2. 实体类添加字段

```java
private Data creatTime;
private Data updateTime;
```

3. 再次更新查看结果即可

>方式二:代码级别

1. 实体类User添加注解

```java
//记住用util包下的Date!!
//字段添加填充内容
@TableField(fill = FieldFill.INSERT)
private Date createTime;

@TableField(fill = FieldFill.INSERT_UPDATE)
private Date updateTime;
```

2. 编写处理器来处理这个注解

```java
@Slf4j
@Component //把处理器加到IOC容器中
public class MyMetaObjectHandler implements MetaObjectHandler {

    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("Start insert fill.... ");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("Start update fill.... ");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
```

3. 测试类测试

> 运行

* 插入一条新消息

![image-20220331195320796](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331195320796.png)

* 修改一条消息

![image-20220331195336942](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331195336942.png)



### 3.4 乐观锁

在面试过程中，我们经常会被问到乐观锁，悲观锁！

> 概述

* 乐观锁：顾名思义，它总是认为不会出现问题，无论干什么都不去上锁！如果出现了问题，再次更新值测试！
* 悲观锁：顾名思义，它总是认为总是出现问题，无论干什么都上锁！再去操作！

> 乐观锁实现方式：

- 取出记录时，获取当前version
- 更新时，带上这个version
- 执行更新时， set version = newVersion where version = oldVersion
- 如果version不对，就更新失败

>测试

1. 数据库中增加一个version字段

![image-20220331200255778](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331200255778.png)

2. 实体类User加上对应的字段

```java
@Version // 乐观锁的version注解
private Integer version;
```

3. 新建config包，注册组件

```java
// 扫描我们的 mapper文件夹
@MapperScan("com.koko.mapper")
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {

    // 注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
```

* 主启动类中的扫描包注释删除！

4. 测试类测试

```java
// 测试乐观锁成功
    @Test
    public void testVersionSuccess(){
        // 1. 查询用户信息
        User user = userMapper.selectById(1L);
        // 2. 修改用户信息
        user.setName("koko");
        user.setAge(24);
        // 3. 执行更新操作
        userMapper.updateById(user);
    }

    // 测试乐观锁失败!多线程下
    @Test
    public void testVersionFall(){
        // 线程1
        User user1 = userMapper.selectById(1L);
        user1.setName("koko01");
        user1.setAge(14);

        // 线程2
        User user2 = userMapper.selectById(1L);
        user2.setName("koko02");
        user2.setAge(24);
        userMapper.updateById(user2);

        //自旋锁来多次尝试提交！
        userMapper.updateById(user1); //如果没有乐观锁就会覆盖插队线程的值
    }
```

> 运行

1. 原理：将version设置为判断条件

![image-20220331201938639](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331201938639.png)

2. 测试乐观锁成功

![image-20220331201734477](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331201734477.png)

3. 测试乐观锁失败!多线程下

![image-20220331201907933](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331201907933.png)



### 3.5 查询操作

* Mybatis_plus帮我们简化了查询！！！

> 测试

```java
//1、测试查询
@Test
public void testSelectById(){
    User user = userMapper.selectById(1L);
    System.out.println(user);
}

//2、测试批量查询
@Test
public void testSelectBatchId(){
    List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
    users.forEach(System.out::println);
}

//3、按条件查询之--使用Map操作
@Test
public void testSelectBatchIds(){
    HashMap<String, Object> map = new HashMap<>();
    map.put("name","koko");
    map.put("age","18");

    List<User> users = userMapper.selectByMap(map);
    users.forEach(System.out::println);
}
```



### 3.6 分页查询

> 概述

分页网站频繁使用

1. 原始使用limit进行分页
2. pageHelper第三方插件
3. MybatisPlus内置了分页插件

> 测试

1. 在配置类中添加分页插件

```java
// 分页插件
@Bean
public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
}
```

2. 测试类中测试

```java
// 测试分页查询
@Test
public void testPage(){
    // 参数一: 当前页
    // 参数二： 页面大小
    // 使用了分页插件之后，所有的分页操作变得简单了
    Page<User> page = new Page<>(1,5);
    userMapper.selectPage(page, null);

    page.getRecords().forEach(System.out::println);
    System.out.println(page.getTotal());
}
```

> 运行

![image-20220331203939196](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331203939196.png)



### 3.7 删除操作

```java
// 测试删除
@Test
public void testdelete(){
    userMapper.deleteById(7L);
}

// 测试批量删除
@Test
public void testdeleteBatchId(){
    userMapper.deleteBatchIds(Arrays.asList(1L,2L));
}

//通过map删除
@Test
public void testDeleteByMap(){
    HashMap<String, Object> map = new HashMap<>();
    map.put("name","koko");
    userMapper.deleteByMap(map);
}
```



### 3.8 逻辑删除

> 概述

* 物理删除：从数据库中直接移除
* 逻辑删除：在数据库中没有被移除，而是通过一个变量让他生效！deleted=0 --> deleted=1

管理员可以查看被删除的记录！防止数据的丢失！类似于回收站！



> 测试

1. 在数据库表中增加一个deleted字段

![image-20220331204837106](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331204837106.png)

2. 实体类中增加属性

```java
@TableLogic // 逻辑删除
private Integer deleted;
```

3. 在配置类中添加方法

```java
// 逻辑删除组件
@Bean
public ISqlInjector sqlInjector(){
    return new LogicSqlInjector();
}
```

4. application.properties

```properties
# 配置逻辑删除
mybatis-plus.global-config.db-config.logic-delete-value=1
mybatis-plus.global-config.db-config.logic-not-delete-value=0
```

> 运行

1. 删除操作

![image-20220331210540043](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331210540043.png)

![image-20220331210639188](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331210639188.png)

2. 查询操作

![image-20220331210815789](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331210815789.png)

以上所有的CRUD操作及其扩展操作，我们必须精通掌握！



## 4. 性能分析插件

> 概述

我们在平时的开发中，会遇到一些慢sql。解决方案：测试，druid监控…

**作用：性能分析拦截器，用于输出每条SQL语句及其执行时间**

MyBatisPlus也提供性能分析插件，如果超过这个时间就停止运行！

> 测试

1. application.properties配置开发环境

```properties
# 设置开发环境
spring.profiles.active=dev
```

2. MyBatisPlusConfig导入插件

```java
// SQL执行效率插件
@Bean
@Profile({"dev","test"})
public PerformanceInterceptor performanceInterceptor(){
    PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    performanceInterceptor.setMaxTime(100); //ms 设置sql执行的最大时间，如果超过了则不执行
    performanceInterceptor.setFormat(true); // 是否格式化
    return performanceInterceptor;
}
```

3. 测试类测试

```java
//查询所有
@Test
void contextLoads() {
    //参数是一个Wrapper , 条件构造器,这里我们先不用 --null
    //查询全部用户
    List<User> users = userMapper.selectList(null);
    users.forEach(System.out::println);
}
```

> 运行

![image-20220331220117624](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331220117624.png)

* 只要超出时间就会抛出异常

注：使用性能分析插件可以提高效率，新版本MP已经移除该拆件了，可以使用druid



## 5. 代码自动生成(*)

> 概述

AutoGenerator 是 MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成 Entity、

Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率

**dao、pojo、service、controller都给我自己去编写完成！**

* 只需要改实体类名字 和包名 还有 数据库配置即可

> 测试

1. KuangCode测试类编写

```java
import com.baomidou.mybatisplus.annotation.DbType; import com.baomidou.mybatisplus.annotation.FieldFill; import com.baomidou.mybatisplus.annotation.IdType; import com.baomidou.mybatisplus.annotation.TableField; import com.baomidou.mybatisplus.generator.AutoGenerator; import com.baomidou.mybatisplus.generator.config.DataSourceConfig; import com.baomidou.mybatisplus.generator.config.GlobalConfig; import com.baomidou.mybatisplus.generator.config.PackageConfig; import com.baomidou.mybatisplus.generator.config.StrategyConfig; import com.baomidou.mybatisplus.generator.config.po.TableFill; import com.baomidou.mybatisplus.generator.config.rules.DateType; import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy; import java.util.ArrayList; 

// 代码自动生成器 
public class KuangCode {
public static void main(String[] args) {
    // 需要构建一个 代码自动生成器 对象 
    AutoGenerator mpg = new AutoGenerator(); 
    
    // 配置策略 
    // 1、全局配置 
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir"); 
    gc.setOutputDir(projectPath+"/src/main/java");
    gc.setAuthor("狂神说"); 
    gc.setOpen(false);
    
    // 是否覆盖
    gc.setFileOverride(false);
    
    // 去Service的I前缀
    gc.setServiceName("%sService");
    
    gc.setIdType(IdType.ID_WORKER);
    gc.setDateType(DateType.ONLY_DATE);
    gc.setSwagger2(true);
    mpg.setGlobalConfig(gc);
    
    //2、设置数据源
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl("jdbc:mysql://localhost:3306/kuang_community? useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("123456");
    dsc.setDbType(DbType.MYSQL); 
    mpg.setDataSource(dsc);
    
    //3、包的配置
    PackageConfig pc = new PackageConfig();
    //只需要改实体类名字 和包名 还有 数据库配置即可
    pc.setModuleName("blog"); 
    pc.setParent("com.kuang");
    pc.setEntity("entity"); 
    pc.setMapper("mapper");
    pc.setService("service"); 
    pc.setController("controller");
    mpg.setPackageInfo(pc);
    
    //4、策略配置
    StrategyConfig strategy = new StrategyConfig();
 	//设置要映射的表名字（重点，唯一要改的地方）
    strategy.setInclude("user01","user02");
    strategy.setNaming(NamingStrategy.underline_to_camel);
	 strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    // 自动lombok；
    strategy.setEntityLombokModel(true);
    strategy.setLogicDeleteFieldName("deleted"); 
    
    // 自动填充配置
    TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
    TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
    ArrayList<TableFill> tableFills = new ArrayList<>();
    tableFills.add(gmtCreate); 
    tableFills.add(gmtModified);
    strategy.setTableFillList(tableFills);
    
    // 乐观锁
    strategy.setVersionFieldName("version");
    strategy.setRestControllerStyle(true);
    strategy.setControllerMappingHyphenStyle(true);
    
    // localhost:8080/hello_id_2 
    mpg.setStrategy(strategy);
    mpg.execute(); //执行 
	}
}
```

> 运行

![image-20220331230816270](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220331230816270.png)

* 直接实现各个模块的代码！！！


