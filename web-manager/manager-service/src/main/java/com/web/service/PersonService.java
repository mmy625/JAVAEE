package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.PersonMapper;
import com.web.entity.Person;

@Service
public class PersonService
{
    
    @Autowired
    PersonMapper personMapper;
    
    @Transactional
    public List<Person> selectPersonList()
    {
        return personMapper.selectPersonList();
    }
    
}
