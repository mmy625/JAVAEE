package com.kgc.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <自定义Servlet 需要 extends BaseServlet> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月12日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BaseServlet extends HttpServlet
{
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if (!"".equals(action))// 当传入的参数不为空时
        {
            Class clasz = this.getClass(); // 获得注册的servlet的Class this代表当前sevlet的实例
            // 得到此servlet实例的方法对象
            Method method;
            try
            {
                method = clasz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
                
                // 调用servlet实例的方法对象
                Object methodReturnResult = method.invoke(this, request, response); // 返回的值不为空时，返回的字符串的格式为： forward:index.jsp
                if (methodReturnResult != null || "".equals(methodReturnResult))
                {
                    String str = (String)methodReturnResult;
                    String[] strs = str.split(":");
                    // 如果为forward则 转发到 strs[1]
                    if ("forward".equals(strs[0]))
                    {
                        request.getRequestDispatcher(strs[1]).forward(request, response);
                    }
                    else if ("redirect".equals(strs[0]))
                    {
                        response.sendRedirect(strs[1]);
                    }
                    
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
             
            
        }
        else
        {
            request.setAttribute("infor", "请检查请求的");
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }
    
}
