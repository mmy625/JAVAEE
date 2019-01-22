package com.kgc.entity;

import java.io.Serializable;

import com.kgc.annotation.Column;
import com.kgc.annotation.Table;

/**
 * �û��� <һ�仰���ܼ���> <������ϸ����>
 * 
 * @author ���� ����
 * @version [�汾��, 2018��11��12��]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
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
