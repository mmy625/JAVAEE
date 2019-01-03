package cn.hibernatedemo.dao;

import java.io.Serializable;

import cn.hibernatedemo.entity.Dept;

public class DeptDao extends BaseDao {
    public Dept get(Serializable id) {
        // 通过Session的get( )方法根据OID加载指定对象
        return (Dept) HibernateUtil.currentSession().get(Dept.class, id);
    }
    
    public Dept load(Serializable id) {
        // 通过Session的load( )方法根据OID加载指定对象
        return (Dept) HibernateUtil.currentSession().load(Dept.class, id);
    }
    
    public void save(Dept dept) {
        currentSession().save(dept); // 保存指定的Dept对象
    }
    
    public void update(Dept dept) {
        currentSession().update(dept); // 更新指定的Dept对象
    }
    
    public void delete(Dept dept) {
        currentSession().delete(dept); // 删除指定的Dept对象
    }
}
