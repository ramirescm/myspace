package com.myspace.services;

import com.myspace.entities.Post;
import com.myspace.entities.User;
import com.myspace.repositories.PostRepository;
import com.myspace.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String title) {
        // return postRepository.findByTitleContaining(title);
        return postRepository.findByTitle(title);
    }

    public Page<Post> findByTitleV2(String title, Pageable pageable) {
        return postRepository.findByTitleV2(title, pageable);
    }
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

}
