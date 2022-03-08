package com.codegym.socialbook_be.user_pack.controller;

import com.codegym.socialbook_be.user_pack.model.RoomChat;
import com.codegym.socialbook_be.user_pack.service.IRoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RoomChatController {
    @Autowired
    IRoomChatService roomChatService;

    @GetMapping("/findRomChat/{userName1}/{userName2}")
    public ResponseEntity<String> findRomChat(@PathVariable String userName1, @PathVariable String userName2) {
        RoomChat romChatEntity = roomChatService.findRoomChat(userName1, userName2);
        return new ResponseEntity(romChatEntity.getId(), HttpStatus.OK);
    }
}
