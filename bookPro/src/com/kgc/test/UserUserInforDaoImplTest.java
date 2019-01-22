package com.kgc.test;

import org.junit.Test;

import com.kgc.dao.UserInforDao;
import com.kgc.dao.UserInforDaoImpl;
import com.kgc.entity.UserInfor;
import com.kgc.util.PageBean;

public class UserUserInforDaoImplTest
{
    UserInforDao uid = new UserInforDaoImpl();
    
    @Test
    public void login()
    {
        System.out.println(uid.login(new UserInfor()));
    }
    
    @Test
    public void getAllUser()
    {
        
       int totalRecord =  uid.getCount(new UserInfor("%1%", ""));
       
       System.out.println("总数据："+totalRecord);
        PageBean<UserInfor> pageBean = new PageBean<UserInfor>();
       pageBean.setT(new UserInfor("%1%", ""));//设置条件对象
//       pageBean.setPageSize(2);//设置每页显示的条数
       pageBean.setTotalRecord(totalRecord);//设置总的记录数
      
       
       
       pageBean =  uid.getAllUserList(pageBean);
       System.out.println( "当前页数据："+pageBean.getList().size());
       System.out.println("总页数："+pageBean.getTotalPage());
       System.out.println();
       System.out.println();
    }
}
