package com.kgc.pojo;

import java.util.Date;

/**
 * 地址 <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月28日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Address
{
    private Integer id; // 主键ID
    
    private String postCode; // 邮编
    
    private String contact; // 联系人
    
    private String addressDesc; // 地址
    
    private String tel; // 联系电话
    
    private Integer createdBy; // 创建者
    
    private Date creationDate; // 创建时间
    
    private Integer modifyBy; // 更新者
    
    private Date modifyDate; // 更新时间
    
    private Integer userId; // 用户ID
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getPostCode()
    {
        return postCode;
    }
    
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
    
    public String getContact()
    {
        return contact;
    }
    
    public void setContact(String contact)
    {
        this.contact = contact;
    }
    
    public String getAddressDesc()
    {
        return addressDesc;
    }
    
    public void setAddressDesc(String addressDesc)
    {
        this.addressDesc = addressDesc;
    }
    
    public String getTel()
    {
        return tel;
    }
    
    public void setTel(String tel)
    {
        this.tel = tel;
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

    @Override
    public String toString()
    {
        return "Address [id=" + id + ", postCode=" + postCode + ", contact=" + contact + ", addressDesc=" + addressDesc
            + ", tel=" + tel + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
            + ", modifyDate=" + modifyDate + ", userId=" + userId + "]";
    }
    
}