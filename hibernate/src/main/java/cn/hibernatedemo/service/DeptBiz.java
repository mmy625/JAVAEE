package cn.hibernatedemo.service;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cn.hibernatedemo.dao.DeptDao;
import cn.hibernatedemo.dao.HibernateUtil;
import cn.hibernatedemo.entity.Dept;

public class DeptBiz {
    private DeptDao deptDao = new DeptDao();
    
    // 通过DeptDao.get()方法加载数据
    public Dept findDeptById(Byte id) {
        Transaction tx = null;
        Dept result = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            result = deptDao.get(id);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
        return result;
    }
    
    // 通过DeptDao.load()方法加载数据
    public Dept findDeptById_2(Byte id) {
        Transaction tx = null;
        Dept result = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            result = deptDao.load(id);
            System.out.println(result.getDeptName());
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
        return result;
    }
    
    public void addNewDept(Dept dept) {
        Transaction tx = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            deptDao.save(dept);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }
    
    public void updateDept(Dept dept) {
        Transaction tx = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            Dept deptToUpdate = deptDao.load(dept.getDeptNo());  // 加载要修改的部门对象
            // 更新部门数据
            deptToUpdate.setDeptName(dept.getDeptName());
            deptToUpdate.setLocation(dept.getLocation());
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }
    
    public void updateDept_2(Dept dept) {
        Transaction tx = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            deptDao.update(dept); // 修改Dept对象的状态，Dept对象由游离状态转为持久状态
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }
    
    public void deleteDept(Byte id) {
        Transaction tx = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            Dept deptToDelete = deptDao.load(id); // 加载要删除的部门对象
            deptDao.delete(deptToDelete); // 删除部门数据
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

    public DeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
