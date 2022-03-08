package com.codegym.socialbook_be.user_pack.service.impl;

import com.codegym.socialbook_be.user_pack.model.Likes;
import com.codegym.socialbook_be.user_pack.repository.ILikeRepository;
import com.codegym.socialbook_be.user_pack.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
    ILikeRepository likeRepository;

    @Override
    public List<Likes> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public Likes save(Likes like) {
        return likeRepository.save(like);
    }

    @Override
    public void deleteById(Long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public Likes findById(Long id) {
        return likeRepository.findById(id).get();
    }

    @Override
    public Long getLikeNumber(Long id) {
        return likeRepository.getLikeNumber(id);
    }
}
