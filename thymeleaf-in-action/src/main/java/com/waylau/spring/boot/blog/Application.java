
package com.waylau.spring.boot.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
@MapperScan("com.waylau.spring.boot.blog.repository")
public class Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
    
}
