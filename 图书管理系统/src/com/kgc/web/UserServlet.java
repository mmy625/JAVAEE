package com.kgc.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgc.entity.UserInfor;
import com.kgc.excepiton.LoginException;
import com.kgc.service.UserInforService;
import com.kgc.service.UserInforServiceImpl;
import com.kgc.util.PageBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * �û���servlet <һ�仰���ܼ���> <������ϸ����>
 * 
 * @author ���� ����
 * @version [�汾��, 2018��11��19��]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet
{
    // ҵ���
    UserInforService uis = new UserInforServiceImpl();
    
    /**
     * ��¼ <һ�仰���ܼ���> <������ϸ����>
     * 
     * @param request
     * @param response
     * @return
     * @throws LoginException
     * @see [�ࡢ��#��������#��Ա]
     */
    public String login(HttpServletRequest request, HttpServletResponse response)
        throws LoginException
    {
        // ��ȡ�û���¼����Ϣ �û��������� ����װ��user����
        UserInfor user = new UserInfor(request.getParameter("userName"), request.getParameter("password"));
        
        // ����ҵ���߼���� ��¼���� �����ز�ѯ�Ķ���
        try
        {
            uis.login(user);
            return "redirect:main.jsp";
        }
        catch (LoginException e)
        {
            request.setAttribute("loginError", e.getMessage());
            return "forward:login.jsp";
        }
        
    }
    
    /**
     * 
     * <��ҳ��ѯ���е��û�����> <������ϸ����>
     * 
     * @param request
     * @param response
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public void getAllUserList(HttpServletRequest request, HttpServletResponse response)
    {
        PageBean<UserInfor> pageBean = new PageBean<UserInfor>();
        // ����������ѯ����
        UserInfor user = new UserInfor(request.getParameter("userName"));
        pageBean.setT(user);
        
        try
        {
            // ���õ�ǰҳ
            pageBean.setPageNum(Integer.parseInt(request.getParameter("page")));
        }
        catch (Exception e)
        {
            pageBean.setPageNum(1);
        }
        // ��ѯ
        pageBean = uis.getAllUserList(pageBean);
        
//        request.setAttribute("pageBean", pageBean);
        
        JSONObject json = new JSONObject();
        json.put("page", pageBean.getPageNum());
        json.put("total", pageBean.getTotalPage());
        json.put("rows", JSONArray.fromObject(pageBean.getList()).toString());
        
        try
        {
            System.out.println(json.toString());
            response.getWriter().write(json.toString());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void test(HttpServletRequest request, HttpServletResponse response)
    {
        Integer.parseInt(request.getParameter("id"));
    }
    
}
