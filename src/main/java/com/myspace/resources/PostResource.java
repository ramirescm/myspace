package com.myspace.resources;

import com.myspace.dtos.PostDtoWithAnotation;
import com.myspace.entities.Post;
import com.myspace.resources.util.URL;
import com.myspace.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/posts")
public class PostResource {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        LOG.info("findById " + id);
        var post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<PostDtoWithAnotation>> findPaged(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "5") int pageSize,
                                                @RequestParam(value = "title", defaultValue = "") String title) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        title = URL.decodeParam(title);
        var posts = postService.findByTitleV2(title, pageable)
                .map(PostDtoWithAnotation::ofEntity);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        var posts = postService.findByTitle(title);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> findByTitle(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
            ) {
        text = URL.decodeParam(text);
        var dateMin = URL.convertDate(minDate, new Date());
        var dateMax = URL.convertDate(maxDate, new Date());
        var posts = postService.fullSearch(text, dateMin, dateMax);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        var list = postService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
