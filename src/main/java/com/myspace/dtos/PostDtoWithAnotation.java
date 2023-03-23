package com.myspace.dtos;

import com.myspace.entities.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class PostDtoWithAnotation {
    private final String id;
    private final String title;
    private final String description;
    private final Date createDate;
    private final List<CommentDTO> comments;
    private final AuthorDTO author;

    public static PostDtoWithAnotation ofEntity(Post entity) {
        return PostDtoWithAnotation.builder()
                .id(entity.getId())
                .createDate(entity.getDate())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .author(entity.getAuthor())
                .comments(entity.getComments())
                .build();
    }
}
