package com.kgc.pojo;

import java.util.Date;
import java.util.List;

/**
 * 用户
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年11月28日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class User
{
    private Integer id; // id
    
    private String userCode; // 用户编码
    
    private String userName; // 用户名称
    
    private String userPassword; // 用户密码
    
    private Integer gender; // 性别
    
    private Date birthday; // 出生日期
    
    private String phone; // 电话
    
    private String address; // 地址
    
    private Integer userRole; // 用户角色
    
    private Integer createdBy; // 创建者
    
    private Date creationDate; // 创建时间
    
    private Integer modifyBy; // 更新者
    
    private Date modifyDate; // 更新时间
    
    
   private Role role; //一对一  对应关系 
   
   
   
   
   
   
   
   private List<Address>  addressList; //一对多 
    
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getUserCode()
    {
        return userCode;
    }
    
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getUserPassword()
    {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
    
    public Integer getGender()
    {
        return gender;
    }
    
    public void setGender(Integer gender)
    {
        this.gender = gender;
    }
    
    public Date getBirthday()
    {
        return birthday;
    }
    
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public Integer getUserRole()
    {
        return userRole;
    }
    
    public void setUserRole(Integer userRole)
    {
        this.userRole = userRole;
    }
    
    public Integer getCreatedBy()
    {
        return createdBy;
    }
    
    public void setCreatedBy(Integer createdBy)
    {
        this.createdBy = createdBy;
    }
    
    public Date getCreationDate()
    {
        return creationDate;
    }
    
    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }
    
    public Integer getModifyBy()
    {
        return modifyBy;
    }
    
    public void setModifyBy(Integer modifyBy)
    {
        this.modifyBy = modifyBy;
    }
    
    public Date getModifyDate()
    {
        return modifyDate;
    }
    
    public void setModifyDate(Date modifyDate)
    {
        this.modifyDate = modifyDate;
    }


    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public List<Address> getAddressList()
    {
        return addressList;
    }

    public void setAddressList(List<Address> addressList)
    {
        this.addressList = addressList;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", userPassword=" + userPassword
            + ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + ", address=" + address
            + ", userRole=" + userRole + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyBy="
            + modifyBy + ", modifyDate=" + modifyDate + "]";
    }

  
    
}
