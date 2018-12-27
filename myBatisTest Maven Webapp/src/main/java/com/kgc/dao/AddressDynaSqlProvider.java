package com.kgc.dao;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.kgc.pojo.Address;

/**
 * 地址的动态sql类 <一句话功能简述> <功能详细描述> 说明： WHERE("addressDesc like \"%\"#{addressDesc}\"%\""); 单引号属于转义字符，所以需要转换
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月30日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AddressDynaSqlProvider
{
    /**
     * 方法中的关键字是区分大小写的 SQL SELECT WHERE 方法会根据传递过来的Address中的参数内容 动态构建sql语句 <一句话功能简述> <功能详细描述>
     * 
     * @param address
     * @return
     * @see [类、类#方法、类#成员]
     */
    public String selectWhitParamSql(Address address)
    {
        return new SQL()
        {
            {
                SELECT("*");
                FROM("smbms_address");
                if (address.getId() != null)
                {
                    WHERE("id=#{id}");
                }
                if (address.getContact() != null && !"".equals(address.getContact()))
                {
                    WHERE("contact=#{contact}");
                }
                if (address.getModifyBy() != null)
                {
                    WHERE("modifyBy=#{modifyBy}");
                }
                if (address.getModifyDate() != null)
                {
                    WHERE("modifyDate=#{modifyDate}");
                }
                if (address.getPostCode() != null && "".equals(address.getPostCode()))
                {
                    WHERE("postCode=#{postCode}");
                }
                if (address.getAddressDesc() != null && !"".equals(address.getAddressDesc()))
                {
                    WHERE("addressDesc  like \"%\"#{addressDesc}\"%\"");
                }
            }
            
        }.toString();
    }
    
    
    public String insertWhitParamSql(Address address)
    {
        return new SQL()
        {
            {
                INSERT_INTO("smbms_address");
                if (address.getUserId() != null)
                {
                    VALUES("userId", "#{userId}");
                }
                if (address.getContact() != null || !"".equals(address.getContact()))
                {
                    VALUES("contact", "#{contact}");
                }
                if (address.getModifyBy() != null)
                {
                    VALUES("modifyBy", "#{modifyBy}");
                }
                if (address.getModifyDate() != null)
                {
                    VALUES("modifyDate", "#{modifyDate}");
                }
                if (address.getPostCode() != null || "".equals(address.getPostCode()))
                {
                    VALUES("postCode", "#{postCode}");
                }
                if (address.getAddressDesc() != null || "".equals(address.getAddressDesc()))
                {
                    VALUES("addressDesc", "#{addressDesc}");
                }
            }
            
        }.toString();
    }
    
    public String updateWhitParamSql(Address address)
    {
        return new SQL()
        {
            {
                UPDATE("smbms_address");
                
                if (address.getUserId() != null)
                {
                    SET("userId=#{userId}");
                }
                if (address.getContact() != null || !"".equals(address.getContact()))
                {
                    SET("contact=#{contact}");
                }
                if (address.getModifyBy() != null)
                {
                    SET("modifyBy=#{modifyBy}");
                }
                if (address.getModifyDate() != null)
                {
                    SET("modifyDate=#{modifyDate}");
                }
                if (address.getPostCode() != null || "".equals(address.getPostCode()))
                {
                    SET("postCode=#{postCode}");
                }
                if (address.getAddressDesc() != null || "".equals(address.getAddressDesc()))
                {
                    SET("addressDesc=#{addressDesc}");
                }
            }
            
        }.toString();
    }
}
