package com.codegym.socialbook_be.user_pack.repository;

import com.codegym.socialbook_be.user_pack.model.FriendsRequest;
import com.codegym.socialbook_be.user_pack.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFriendRequestRepo extends JpaRepository<FriendsRequest, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM social_book.friends_request where receiver_id = :id and status = 'pending';")
    List<FriendsRequest> getFriendsRequestByIdReceiver(@Param(value = "id") Long id);

    @Query(nativeQuery = true, value = "SELECT id from (SELECT users.id FROM social_book.users where id not in (SELECT receiver_id as idReceiver FROM social_book.friends_request  where sender_id = :id)) as stranger where id not in (SELECT sender_id as idSender FROM social_book.friends_request  where receiver_id = :id)")
    List<Long> getStranger(@Param(value = "id") Long id);
}
