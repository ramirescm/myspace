package com.myspace.services;

import com.myspace.entities.MockPost;
import com.myspace.entities.Post;
import com.myspace.repositories.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    MockPost input;

    @InjectMocks
    private PostService service;

    @Mock
    private PostRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockPost();
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
        var id = "xpto";
        Post post = input.mockEntity(id);
        post.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(post));

        var result = service.findById(id);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getTitle());
        assertNotNull(result.getDescription());
        assertNotNull(result.getAuthor().getName());
        assertEquals(2, result.getComments().size());
    }

    @Test
    void findByTitle() {
        var title = "Testando com JUnit";
        var id = "xpto";
        Post post = input.mockEntity(id);
        post.setId(id);

        when(repository.findByTitle(title)).thenReturn(Arrays.asList(post));

        var result = service.findByTitle(title);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void fullSearch() {
    }
}