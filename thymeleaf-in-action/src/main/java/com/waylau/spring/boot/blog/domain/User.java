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
    
    private int id;
    
    private String userName;
    
    private String password;
    
    private int age;
    
    public User()
    { // 无参数默认构造器
    }
    
    public User(String userName, String password, int age)
    {
        super();
        this.userName = userName;
        this.password = password;
        this.age = age;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    @Override
    public String toString()
    {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", age=" + age + "]";
    }
    
}
