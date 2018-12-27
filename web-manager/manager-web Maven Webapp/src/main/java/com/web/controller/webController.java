package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.service.PersonService;

@Controller
public class webController
{
    
    @Autowired
    PersonService personService;
    
    @GetMapping("/test.do")
    public String get()
    {
        System.out.println(personService.selectPersonList());
        return "test";
    }
    
}
