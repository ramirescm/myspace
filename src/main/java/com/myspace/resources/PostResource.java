package com.myspace.resources;

import com.myspace.entities.Post;
import com.myspace.resources.util.URL;
import com.myspace.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        var post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        var posts = postService.findByTitle(title);
        return ResponseEntity.ok().body(posts);
    }
}
