package com.codegym.socialbook_be.user_pack.repository;

import com.codegym.socialbook_be.user_pack.model.RoomChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRoomChatRepo extends JpaRepository<RoomChat, Long> {
    @Query("SELECT f FROM RoomChat f where (f.userFriend =:userName1 and f.userName =:userName2) or (f.userFriend =:userName2 and f.userName =:userName1)")
    public RoomChat findChatRom(@Param("userName1") String userName1, @Param("userName2") String userName2);

}