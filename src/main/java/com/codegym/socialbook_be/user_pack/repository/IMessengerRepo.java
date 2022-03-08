package com.codegym.socialbook_be.user_pack.repository;

import com.codegym.socialbook_be.user_pack.model.MessengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessengerRepo extends JpaRepository<MessengerEntity, Long> {
    public Iterable<MessengerEntity> findAllByRoomChatId(Long id);

}
