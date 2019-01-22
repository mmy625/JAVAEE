package com.waylau.spring.boot.blog.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.waylau.spring.boot.blog.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository
{
    private static AtomicLong counter = new AtomicLong();
    
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();
    
    @Override
    public User saveOrUpdateUser(User user)
    {
        Long id = user.getId();
        if (id == null)
        {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        
        return user;
    }
    
    @Override
    public void deleteUser(Long id)
    {
       this.userMap.remove(id);
        
    }
    
    @Override
    public User getUserById(Long id)
    {
        // TODO Auto-generated method stub
        return this.userMap.get(id);
    }
    
    @Override
    public List<User> listUser()
    {
        // TODO Auto-generated method stub
        return new ArrayList<User>(this.userMap.values());
    }
    
}
