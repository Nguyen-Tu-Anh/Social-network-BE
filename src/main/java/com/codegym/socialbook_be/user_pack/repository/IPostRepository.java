package com.codegym.socialbook_be.user_pack.repository;

import com.codegym.socialbook_be.user_pack.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM social_book.post order by time desc")
    List<Post> findAllShortByTime();
}
