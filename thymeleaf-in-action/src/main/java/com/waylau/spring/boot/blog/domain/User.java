package com.waylau.spring.boot.blog.domain;

/**
 * User <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2019年1月22日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class User
{
    
    private Long id; // 实体的唯一标识
    
    private String name;
    
    private String email;
    
    public User()
    { // 无参数默认构造器
    }
    
    public User(Long id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
}
