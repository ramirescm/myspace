package com.myspace.entities;

import com.myspace.dtos.AuthorDTO;
import com.myspace.dtos.CommentDTO;
import com.myspace.resources.util.URL;

import java.util.Arrays;
import java.util.Date;

public class MockPost {

    public Post mockEntity() {
        return mockEntity("");
    }

    public Post mockEntity(String id) {
        var authorPost = new AuthorDTO();
        authorPost.setId("a123");
        authorPost.setName("maria");

        var post = new Post();
        post.setTitle("Testando com JUnit " + id);
        post.setDescription("Testes unitários"+ id);
        post.setAuthor(authorPost);

        var authorComment1 = new AuthorDTO();
        authorComment1.setId("b123");
        authorComment1.setName("joao");

        var authorComment2 = new AuthorDTO();
        authorComment2.setId("b234");
        authorComment2.setName("bob");

        var date = URL.convertDate("2023-03-17", new Date());
        var c1 = new CommentDTO("Muito bom!!", date, authorComment1);
        var c2 = new CommentDTO("Muito bom!!", date, authorComment2);

        post.setComments(Arrays.asList(c1, c2));
        return post;
    }

}