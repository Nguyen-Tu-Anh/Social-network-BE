package com.codegym.socialbook_be.user_pack.service;

import com.codegym.socialbook_be.user_pack.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> findAll();

    Post save(Post post);

    void deleteById(Long id);

    Optional<Post> findById(Long id);

}
