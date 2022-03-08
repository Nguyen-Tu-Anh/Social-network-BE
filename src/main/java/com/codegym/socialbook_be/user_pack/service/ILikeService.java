package com.codegym.socialbook_be.user_pack.service;

import com.codegym.socialbook_be.user_pack.model.Likes;

import java.util.List;

public interface ILikeService {
    List<Likes> findAll();

    Likes save(Likes like);

    void deleteById(Long id);

    Likes findById(Long id);

    Long getLikeNumber(Long id);
}
