package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.models.Blog;
import com.codegym.casestudy.repositories.IBlogRepository;
import com.codegym.casestudy.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>)blogRepository.findAll();
    }

    @Override
    public Blog findOne(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog delete(Long id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        blogRepository.delete(blog);
        return blog;
    }

    @Override
    public Iterable<Blog> findAllByDateDesc() {
        return blogRepository.findAllByDateDesc();
    }

    @Override
    public Iterable<Blog> findAllByTitleLike(String keyWord) {
        return blogRepository.findAllByTitleContainingOrderByPostTimeDesc(keyWord);
    }
}
