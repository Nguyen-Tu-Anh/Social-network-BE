package com.codegym.socialbook_be.user_pack.service;

import com.codegym.socialbook_be.user_pack.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    List<Comment> findAll();

    List<Comment> getCommentByPostId(Long id);

    Comment save(Comment comment);

    Comment findById(Long id);

    void deleteById(Long id);
}
