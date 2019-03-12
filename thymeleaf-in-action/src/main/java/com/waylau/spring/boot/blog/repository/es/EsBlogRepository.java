package com.waylau.spring.boot.blog.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.waylau.spring.boot.blog.domain.es.EsBlog;

/**
 * 博客
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2019年2月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface EsBlogRepository extends ElasticsearchCrudRepository<EsBlog, String>
{
    /**
     * 分页查询博客
     * <一句话功能简述>
     * <功能详细描述>
     * @param title
     * @param summay
     * @param content
     * @param pageable
     * @return
     * @see [类、类#方法、类#成员]
     */
    Page<EsBlog> findBytitleContainingOrSummaryContaini(String title, String summay, String content, Pageable pageable);
}
