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
 * <�Զ���Servlet ��Ҫ extends BaseServlet> <������ϸ����>
 * 
 * @author ���� ����
 * @version [�汾��, 2018��11��12��]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
public class BaseServlet extends HttpServlet
{
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if (!"".equals(action))// ������Ĳ�����Ϊ��ʱ
        {
            Class clasz = this.getClass(); // ���ע���servlet��Class this����ǰsevlet��ʵ��
            // �õ���servletʵ���ķ�������
            Method method;
            try
            {
                method = clasz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
                
                // ����servletʵ���ķ�������
                Object methodReturnResult = method.invoke(this, request, response); // ���ص�ֵ��Ϊ��ʱ�����ص��ַ����ĸ�ʽΪ�� forward:index.jsp
                if (methodReturnResult != null || "".equals(methodReturnResult))
                {
                    String str = (String)methodReturnResult;
                    String[] strs = str.split(":");
                    // ���Ϊforward�� ת���� strs[1]
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
            request.setAttribute("infor", "���������");
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }
    
}
