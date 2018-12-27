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
 * 用户的servlet <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet
{
    // 业务层
    UserInforService uis = new UserInforServiceImpl();
    
    /**
     * 登录 <一句话功能简述> <功能详细描述>
     * 
     * @param request
     * @param response
     * @return
     * @throws LoginException
     * @see [类、类#方法、类#成员]
     */
    public String login(HttpServletRequest request, HttpServletResponse response)
        throws LoginException
    {
        // 获取用户登录的信息 用户名和密码 并封装成user对象
        UserInfor user = new UserInfor(request.getParameter("userName"), request.getParameter("password"));
        
        // 调用业务逻辑层的 登录方法 并返回查询的对象
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
     * <分页查询所有的用户对象> <功能详细描述>
     * 
     * @param request
     * @param response
     * @return
     * @see [类、类#方法、类#成员]
     */
    public void getAllUserList(HttpServletRequest request, HttpServletResponse response)
    {
        PageBean<UserInfor> pageBean = new PageBean<UserInfor>();
        // 设置条件查询对象
        UserInfor user = new UserInfor(request.getParameter("userName"));
        pageBean.setT(user);
        
        try
        {
            // 设置当前页
            pageBean.setPageNum(Integer.parseInt(request.getParameter("page")));
        }
        catch (Exception e)
        {
            pageBean.setPageNum(1);
        }
        // 查询
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
