package com.myspace.services;

import com.myspace.entities.Post;
import com.myspace.repositories.PostRepository;
import com.myspace.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

}
