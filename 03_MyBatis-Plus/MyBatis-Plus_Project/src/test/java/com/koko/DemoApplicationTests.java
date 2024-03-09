package com.koko;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.koko.mapper.UserMapper;
import com.koko.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    //继承了BaseMapper, 所有的方法都来自己父类
    //我们也可以编写自己的扩展方法
    @Autowired
    private UserMapper userMapper;

    //查询所有
    @Test
    void contextLoads() {
        //参数是一个Wrapper , 条件构造器,这里我们先不用 --null
        //查询全部用户
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //测试插入
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


    //测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(7L);
        user.setName("giao");

        //注意:updateById()参数是 一个对象!
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

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

    //1、测试查询
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(9L);
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

    // 测试删除
    @Test
    public void testdelete(){
        userMapper.deleteById(9L);
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

}




