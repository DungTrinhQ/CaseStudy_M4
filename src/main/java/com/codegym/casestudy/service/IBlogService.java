package com.codegym.casestudy.service;

import com.codegym.casestudy.models.Blog;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findOne(Long id);
    Blog createBlog(Blog blog);
    Blog delete(Long id);
    Iterable<Blog> findAllByDateDesc();
    Iterable<Blog> findAllByTitleLike(String keyWord);
}
