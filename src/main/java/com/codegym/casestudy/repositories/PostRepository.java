package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository <Long, Post> {
    List<Post> findByCreatorId(Long id);
}
