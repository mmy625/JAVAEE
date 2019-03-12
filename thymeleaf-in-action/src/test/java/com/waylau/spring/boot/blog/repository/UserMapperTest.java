package com.waylau.spring.boot.blog.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.waylau.spring.boot.blog.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest
{
    
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void testQuery()
        throws Exception
    {
        User user = userMapper.getUserById(1L);
        System.out.println(user);
    }
    
    @Test
    public void testQueryAll()
    {
        Page<User> pageInfo = PageHelper.startPage(1, 2);
        List<User> users = userMapper.listUser();
        System.out.println(users);
    }
    
    @Test
    public void testSaveUser()
    {
        User user = new User("lisi", "123455", 19);
        
        userMapper.saveUser(user);
    }
    
    /**
     * 根据id查询用户信息 <一句话功能简述> <功能详细描述>
     * 
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void testGetUserBy()
    {
        
        User user = userMapper.getUserById(1L);
        System.out.println(user);
    }
    
    @Test
    public void testDeleteUserById()
    {
        userMapper.deleteUserById(1L);
    }
    
    @Test
    public void testUpdateUser()
    {
        User user = new User("myn","111111",33);
        user.setId(2);
        userMapper.updateUser(user);
    }
}