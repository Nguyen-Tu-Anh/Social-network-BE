package com.codegym.socialbook_be.user_pack.service.impl;

import com.codegym.socialbook_be.user_pack.model.RoomChat;
import com.codegym.socialbook_be.user_pack.repository.IRoomChatRepo;
import com.codegym.socialbook_be.user_pack.service.IRoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomChatServiceImpl implements IRoomChatService {
    @Autowired
    IRoomChatRepo roomChatRepo;

    @Override
    public void save(RoomChat roomChat) {
        roomChatRepo.save(roomChat);
    }

    @Override
    public RoomChat findRoomChat(String userName1, String userName2) {
        return roomChatRepo.findChatRom(userName1, userName2);
    }
}
