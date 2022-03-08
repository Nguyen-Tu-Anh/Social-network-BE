package com.codegym.socialbook_be.user_pack.service;

import com.codegym.socialbook_be.user_pack.model.RoomChat;

public interface IRoomChatService {
    void save(RoomChat roomChat);

    RoomChat findRoomChat(String userName1, String userName2);
}
