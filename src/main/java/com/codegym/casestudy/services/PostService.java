package com.codegym.casestudy.services;

import com.codegym.casestudy.models.Post;
import com.codegym.casestudy.models.User;
import com.codegym.casestudy.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }

    public List<Post> findByUser(User user){
        return postRepository.findByCreatorId(user.getId());
    }

    public boolean deletePost(Long postId){
        Post thePost = postRepository.findOne(postId);
        if(thePost == null)
            return false;
        postRepository.delete(postId);
        return true;
    }

    public Post getPost(Long id) {
        return postRepository.findOne(id);
    }

    public Post find(Long postId) {
        return postRepository.findOne(postId);
    }
}
