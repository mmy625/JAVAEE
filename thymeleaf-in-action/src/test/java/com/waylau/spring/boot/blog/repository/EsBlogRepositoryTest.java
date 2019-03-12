package com.waylau.spring.boot.blog.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.waylau.spring.boot.blog.domain.es.EsBlog;
import com.waylau.spring.boot.blog.repository.es.EsBlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest
{
    @Autowired
    EsBlogRepository esBlogRepository;
    
    @Before
    public void initRepositroy()
    {
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("Had I not seen the Sun", "I could have borne the shade",
            "But Light a newer Wilderness. My Wilderness has made."));
        esBlogRepository.save(new EsBlog("There is room in the halls of pleasure", "For a long and lordly train",
            "But one by one we must all file on, Through the narrow aisles of pain."));
        esBlogRepository.save(new EsBlog("When you are old", "When you are old and grey and full of sleep",
            "And nodding by the fire，take down this book."));
        
    }
    
    @Test
    public void testFindDistinctEsblogByTitle()
    {
        Pageable pageable = PageRequest.of(0, 20);
        String title = "Sun";
        String summary = "is";
        String content = "down";
        
        Page<EsBlog> page = esBlogRepository.findBytitleContainingOrSummaryContaini(title, summary, content, pageable);
        
        System.out.println("---------start 1");
        for (EsBlog blog : page)
        {
            System.out.println(blog.toString());
        }
        System.out.println("---------end 1");
        
    }
}
