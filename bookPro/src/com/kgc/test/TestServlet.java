package com.kgc.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgc.entity.UserInfor;

public class TestServlet extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        req.setAttribute("user", new UserInfor(22, "abc","abc123"));
        req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
    
}
