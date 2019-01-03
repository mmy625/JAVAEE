package cn.hibernatedemo.test;

import org.junit.Test;

import cn.hibernatedemo.entity.Dept;
import cn.hibernatedemo.service.DeptBiz;

public class T1
{
    
    /**
     * 按主键获取Dept对象，get方法
     */
    @Test
    public void eg5_getDept()
    {
        // 1. 加载数据操作
        Dept dept = new DeptBiz().findDeptById(new Byte("10"));
        // 2. 输出数据
        System.out.println(dept.getDeptName());
    }
    
    /**
     * 按主键获取Dept对象，load方法
     */
    @Test
    public void eg6_loadDept()
    {
        // 加载数据操作
        Dept dept = (Dept)new DeptBiz().findDeptById_2(new Byte("10"));
    }
    
    /**
     * 新增Dept
     */
    @Test
    public void eg7_saveDept()
    {
        // 构建测试数据
        Dept dept = new Dept();
        dept.setDeptNo(new Byte("11"));
        dept.setDeptName("测试部");
        dept.setLocation("东区");
        // 保存新部门信息
        new DeptBiz().addNewDept(dept);
        
    }
    
    /**
     * 修改部门信息，Dept对象处于持久状态
     */
    @Test
    public void eg8_updateDept1()
    {
        // 构建测试数据
        Dept dept = new Dept();
        dept.setDeptNo(new Byte("11"));
        dept.setDeptName("质管部"); // 发生变化的属性
        dept.setLocation("东区");
        // 更新部门信息
        new DeptBiz().updateDept(dept);
    }
    
    /**
     * 修改部门信息，Dept对象处于脱管状态
     */
    @Test
    public void eg8_updateDept_2()
    {
        // 创建部门对象
        Dept dept = new Dept();
        dept.setDeptNo(new Byte("11"));
        // 部门信息
        dept.setDeptName("质管部");
        dept.setLocation("西区");
        new DeptBiz().updateDept_2(dept);
    }
    
    /**
     * 删除部门
     */
    @Test
    public void eg9_deleteDept()
    {
        new DeptBiz().deleteDept((byte)11);
    }
    
}
