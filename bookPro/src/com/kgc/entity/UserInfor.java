package com.kgc.entity;

import java.io.Serializable;

import com.kgc.annotation.Column;
import com.kgc.annotation.Table;

/**
 * 用户类 <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月12日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Table(tableName = "tb_userinfor")
public class UserInfor implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    @Column(columnName = "id", isPrimaryKEY = true)
    private int id;
    
    @Column(columnName = "user_name")
    private String userName;
   
    
    @Column(columnName = "password")
    private String password;
    
    public UserInfor()
    {
    }
    
    public UserInfor(String userName)
    {
        this.userName = userName;
    }
    
    public UserInfor(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }
    
    public UserInfor(int id, String userName, String password)
    {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
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
    
    @Override
    public String toString()
    {
        return "UserInfor [id=" + id + ", userName=" + userName + ", password=" + password + "]";
    }
    
}
