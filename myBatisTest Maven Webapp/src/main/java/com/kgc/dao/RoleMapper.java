package com.kgc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.kgc.pojo.Role;
import com.kgc.pojo.User;

/**
 * 角色 Mapper 
 *  1:演示参数传递的3种方法。
 *  2:全注解配置，（需要在mybatis-config.xml文件中配置 <mapper class="com.kgc.dao.RoleMapper" />）
 *  3:演示 注解Results 代替XML文件中的 resultMap的结果集映射
 *  4：演示 提取公共的resultMap 
 * @author 姓名 工号
 * @version [版本号, 2018年11月27日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

public interface RoleMapper
{
    /**
     * 
     * <查询全部的角色>
     * <无ResultMap映射>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_role ")
    public List<Role> listRole();
    
    
    /**
     * Map 传参法 <一句话功能简述> <功能详细描述>
     * 设置公共的ResultMap  其他方法只需要使用id即可，位置在任意方法上，不分先后顺序
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_role where roleName = #{roleName}")
    @Results(id="roleMap", value={@Result(column = "id", property = "id"), @Result(column = "roleCode", property = "roleCode")})
    public List<Role> listRoleForMap(Map<String, Object> map);
    
    /**
     * 2：注解传参法 查询角色集合 <一句话功能简述>
     * 此处@ResultMap引用了公共的 @Results
     * @param roleName 角色名字
     * @param roleCode 角色编码
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_role where roleName = #{role_Name} and roleCode = #{role_code}")
    @ResultMap("roleMap")
    public List<Role> listRoleForAnnotation(@Param("role_Name") String roleName, @Param("role_code") String roleCode);
    
    /**
     * Java Bean传参法 <一句话功能简述> <功能详细描述>
     * 此处未使用公共的resultMap
     * @param role
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_role where roleName = #{roleName} and roleCode = #{roleCode}")
    @Results({@Result(column = "id", property = "id"), @Result(column = "roleCode", property = "roleCode")})
    public List<Role> listRoleForJavaBean(Role role);
    
    /**
     * 根据角色ID 获得角色对象
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select r.id as rid, r.* from smbms_role r where r.id = #{roleId}")
    @Results({@Result(column = "rid", property = "id")})
    public Role getRoleById(@Param("roleId")int id);
    
    
    /**延迟加载
     * FetchType.LAZY 此处为延迟加载
     * 意思是，虽然查询的是User，如果不使用user里面的role对象，即不需要执行查询use对应的role，只执行一条sql语句>
     * 
     * 根据用户的角色ID 查询多个用户对象，还有对应的角色实体，采用 one配置
     *  
     * <功能详细描述>
     * @param roleId
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("SELECT  u.id AS uid,u.*   FROM smbms_user   u   WHERE     u.userRole = #{userRole}")
    @Results({@Result(column="uid",property="id"),@Result(column = "userRole", property = "role",one=@One(select="com.kgc.dao.RoleMapper.getRoleById",fetchType=FetchType.LAZY))})
    public List<User> listUserByRoleIdForLazy(@Param("userRole")int roleId);
    
    
    /** 立即加载 FetchType.EAGER
     * 
     * 根据用户的角色ID 查询多个用户对象，还有对应的角色实体，采用 one配置
     * 
     * <功能详细描述>
     * @param roleId
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("SELECT  u.id AS uid,u.*   FROM smbms_user   u   WHERE  u.userRole = #{userRole}")
    @Results({@Result(column="uid",property="id"),@Result(column = "userRole", property = "role",one=@One(select="com.kgc.dao.RoleMapper.getRoleById",fetchType=FetchType.EAGER))})
    public List<User> listUserByRoleIdForEanger(@Param("userRole")int roleId);  
    
    
}
