package com.waylau.spring.boot.blog.domain.es;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * 文档类 <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2019年2月22日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class EsBlog implements Serializable
{
    @Id
    private String id;
    
    private String title;
    
    private String summary;
    
    private String content;
    
    protected EsBlog()
    {
        
    }
    
    public EsBlog(String title, String summary, String content)
    {
        super();
        this.title = title;
        this.summary = summary;
        this.content = content;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getSummary()
    {
        return summary;
    }
    
    public void setSummary(String summary)
    {
        this.summary = summary;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    @Override
    public String toString()
    {
        return "EsBlog [id=" + id + ", title=" + title + ", summary=" + summary + ", content=" + content + "]";
    }
    
}
