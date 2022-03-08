package com.codegym.socialbook_be.user_pack.service;


import com.codegym.socialbook_be.user_pack.model.MessengerEntity;

public interface IMessengerService {
    void save(MessengerEntity messengerEntity);

    Iterable<MessengerEntity> findAllByRoomChatId(Long id);
}
