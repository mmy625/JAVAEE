package com.waylau.spring.boot.blog.repository;

import java.util.List;

import com.waylau.spring.boot.blog.domain.User;

public interface UserRepository
{
    /**
     * 
     * <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    User saveOrUpdateUser(User user);
    
    /**
     * 根据id删除 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @see [类、类#方法、类#成员]
     */
    void deleteUser(Long id);
    
    /**
     * 根据id获取用户 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    User getUserById(Long id);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<User> listUser();
}
