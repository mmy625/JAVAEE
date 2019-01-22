package com.kgc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtils
{
    
    // 定义数据库的用户名
    private final String USERNAME = "root";
    
    // 定义数据库的密码
    private final String PASSWORD = "root";
    
    // 定义数据库的驱动信息
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    // 定义访问数据库的地址
    private final String URL = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
    
    // 定义访问数据库的连接
    private Connection connection;
    
    // 定义sql语句的执行对象
    private PreparedStatement pstmt;
    
    // 定义查询返回的结果集合
    private ResultSet resultSet;
    
    public JdbcUtils()
    {
        // TODO Auto-generated constructor stub
        try
        {
            Class.forName(DRIVER);
            System.out.println("注册驱动成功！！");
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            System.out.println("注册驱动失败！！");
        }
        
    }
    
    // 定义获得数据库的连接
    public Connection getConnection()
    {
        
        try
        {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            // TODO: handle exception
            System.out.println("Connection exception !");
        }
        
        return connection;
        
    }
    
}
