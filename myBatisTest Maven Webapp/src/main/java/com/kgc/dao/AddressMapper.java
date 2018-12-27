package com.kgc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.kgc.pojo.Address;

/**
 * 地址 接口 <一句话功能简述> <功能详细描述> 动态SQL @ InsertProvider SelectProvider UpdateProvider DeleteProvider
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月29日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface AddressMapper
{
    /**
     * 根据用户ID查询 <一句话功能简述> <功能详细描述>
     * 
     * @param userId
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select  * from smbms_address where userId = #{userId}")
    public List<Address> listAddressByUserId(int userId);
    
    /**
     * 动态查询 type:指定一个类 method:使用这个类中的selectWhitParamSql方法返回的sql字符串 作为查询的语句 <一句话功能简述> <功能详细描述>
     * 
     * @param address
     * @return
     * @see [类、类#方法、类#成员]
     */
    @SelectProvider(type = AddressDynaSqlProvider.class, method = "selectWhitParamSql")
    public List<Address> selectWithParam(Address address);
    
    /**
     * 插入动态sql <一句话功能简述> <功能详细描述>
     * 
     * @param address
     * @see [类、类#方法、类#成员]
     */
    @InsertProvider(type = AddressDynaSqlProvider.class, method = "insertWhitParamSql")
    public void insertAddress(Address address);
    
    
}
