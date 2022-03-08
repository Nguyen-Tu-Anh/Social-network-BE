package com.codegym.socialbook_be.user_pack.repository;

import com.codegym.socialbook_be.user_pack.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM social_book.comment where post_id = :id")
    List<Comment> getCommentByPostId(@Param(value = "id") Long id);
}
