package com.codegym.socialbook_be.user_pack.controller;

import com.codegym.socialbook_be.user_pack.model.MessengerEntity;
import com.codegym.socialbook_be.user_pack.model.RoomChat;
import com.codegym.socialbook_be.user_pack.service.IMessengerService;
import com.codegym.socialbook_be.user_pack.service.IRoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ChatControllerApi {
    @Autowired
    IRoomChatService roomChatService;
    @Autowired
    IMessengerService iMessengerService;


    @GetMapping("/addRomchat/{user1}/{user2}")
    public ResponseEntity addRomchat(@PathVariable String user1, @PathVariable String user2) {
        RoomChat romChatEntity = roomChatService.findRoomChat(user1, user2);
        if (romChatEntity == null) {
            romChatEntity = new RoomChat();
            romChatEntity.setUserName(user1);
            romChatEntity.setUserFriend(user2);
            roomChatService.save(romChatEntity);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/allChat/{idRomChat}")
    public ResponseEntity fillAllChatByRom(@PathVariable Long idRomChat) {
        Iterable<MessengerEntity> listMessenger = iMessengerService.findAllByRoomChatId(idRomChat);
        return new ResponseEntity(listMessenger, HttpStatus.OK);
    }
}
