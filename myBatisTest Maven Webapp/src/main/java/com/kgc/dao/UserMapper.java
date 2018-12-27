package com.kgc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.kgc.pojo.User;

/**
 * 用户操作 接口 Mapper <一句话功能简述> <namespace的命名必须跟某个接口同名 接口中的方法与映射文件中SQL语句id一一对应>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月27日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UserMapper
{
    /**
     * 查询用户表记录数
     * 
     * @return
     */
    public int count();
    
    /**
     * 查询用户列表
     * 
     * @return
     */
    public List<User> getUserList(User user);
    
    /**
     * saveUser <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int saveUser(User user);
    
    /**
     * 根据名字模糊查找 <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> listUserLikeName(User user);
    
    /**
     * 结果集以resultMap的方式 然后在map中封装成user对象 <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> listUserResultMap();
    
    /**
     * 根据Id得到用户 <演示公共的sql > XML配置如下： <sql id="selectUser"> select * from smbms_user </sql> 引用方法：
     * <include refid="selectUser"/> where id =#{id} <功能详细描述>
     * 
     * @param id 用户id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public User getUserByIdForCommon(int id);
    
    /**
     * 根据角色ID获得用户对象 用户表和角色表联表查询 演示一对一映射 <一句话功能简述> <功能详细描述>
     * 
     * @param roleId
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> getUserListByRoleId(@Param("userRoleId") int roleId);
    
    /**
     * 根据用户Id 得到此用户的多个地址 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public User getAddressListByUserId(@Param("userId") int id);
    
    /**
     * 根据角色和用户名称 查询 <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> listUserByRoleIdAndUserName(User user);
    
    /**
     * 系统用户
     * <一句话功能简述>
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    public void modifyUser(User user);
    
    /**
     * 测试foreach标签 list
     * <一句话功能简述>
     * <功能详细描述>
     * @param list
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> selectUserByListId(@Param("ids")List list);
    
    /**
     * 测试foreach标签 数组
     * <一句话功能简述>
     * <功能详细描述>
     * @param ids
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> selectUserByArrayId(@Param("ids")int[] ids);
    
    
    /**
     * 一对多演示   根据用户id查询user，但还需要把user里面的 addressList 集合数一并查询处理
     * 此处配置了延迟加载 fetchType=FetchType.LAZY，不使用数据，即不会执行查询地址集合数据
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select   u.id as uid,u.* from smbms_user u  where u.id = #{id}")
    @Results({@Result(column="uid",property="id"),@Result(column="id",property="addressList",many=@Many(select="com.kgc.dao.AddressMapper.listAddressByUserId",fetchType=FetchType.LAZY))})
    public User getUserByIdForOneTwoMany(int id);
    
    @Select("select * from smbms_user")
    public List<User> listUserPageHelper();
    
    
}
