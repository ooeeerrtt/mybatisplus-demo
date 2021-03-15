package com.star.mpdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mpdemo.entity.User;
import com.star.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MpdemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setName("alex");
        user.setAge(34);
        user.setEmail("xxx@qq.com");

        int i = userMapper.insert(user);
        System.out.println(i);
    }

    @Test
    void updateTest() {
        User user = new User();
        user.setId(1L);
        user.setAge(120);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    // 多个id值的批量查询
    @Test
    void testSelectDemo1() {

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    // 分页查询
    @Test
    public void testPage() {
        Page<User> page = new Page<User>(1, 3);
        userMapper.selectPage(page, null);
        System.out.println(page.getCurrent());  //当前页
        System.out.println(page.getRecords()); // 每页数据list集合
        System.out.println(page.getSize());  // 每页显示记录数
        System.out.println(page.getTotal());   // 总记录是
        System.out.println(page.getPages());  // 总页数

        System.out.println(page.hasNext()); // 下一页
        System.out.println(page.hasPrevious());  // 上一页


    }

    @Test
    public void deleteDemo1() {
        int i = userMapper.deleteById(1L);
        System.out.println(i);
    }

    @Test
    public void deleteDemo2() {
        int i = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(i);
    }

    @Test
    public void testSelectQuery() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.ge("age", 30);

        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

}
