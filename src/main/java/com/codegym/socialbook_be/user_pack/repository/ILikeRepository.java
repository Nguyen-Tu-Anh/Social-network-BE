package com.codegym.socialbook_be.user_pack.repository;

import com.codegym.socialbook_be.user_pack.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ILikeRepository extends JpaRepository<Likes, Long> {
    @Query(nativeQuery = true, value = "SELECT count(id) FROM social_book.likes where post_id = :id")
    Long getLikeNumber(@Param(value = "id") Long id);

}
