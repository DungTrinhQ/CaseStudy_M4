package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends CrudRepository<Blog,Long> {
}
