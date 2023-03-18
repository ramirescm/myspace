package com.myspace.repositories;

import com.myspace.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContaining(String title);

    // ?0 first, ?1 second... parameters, option i to ignore case
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String title);

    @Query("{ $and: [ {date: { $gte: ?1} }, {date: { $lte: ?2} },  {$or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ]}")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    Page<Post> findByTitleV2(@Param("title") String lastName, Pageable pageable);
}