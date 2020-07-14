package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Blog;
import com.codegym.casestudy.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository <Long, Post> {
    List<Post> findByCreatorId(Long id);
    @Query(value = "SELECT * FROM blog ORDER BY post_time DESC", nativeQuery = true)
    Iterable<Blog> findAllByDateDesc();
}
