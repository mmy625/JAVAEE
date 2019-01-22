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
       
       System.out.println("�����ݣ�"+totalRecord);
        PageBean<UserInfor> pageBean = new PageBean<UserInfor>();
       pageBean.setT(new UserInfor("%1%", ""));//������������
//       pageBean.setPageSize(2);//����ÿҳ��ʾ������
       pageBean.setTotalRecord(totalRecord);//�����ܵļ�¼��
      
       
       
       pageBean =  uid.getAllUserList(pageBean);
       System.out.println( "��ǰҳ���ݣ�"+pageBean.getList().size());
       System.out.println("��ҳ����"+pageBean.getTotalPage());
       System.out.println();
       System.out.println();
    }
}
