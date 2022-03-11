package com.codegym.socialbook_be.user_pack.controller;


import com.codegym.socialbook_be.security_pack.security.userpincal.UserDetailService;
import com.codegym.socialbook_be.security_pack.service.IUserService;
import com.codegym.socialbook_be.user_pack.model.FriendsRequest;
import com.codegym.socialbook_be.user_pack.model.Users;
import com.codegym.socialbook_be.user_pack.service.IFriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IFriendRequestService friendRequestService;

    @Autowired
    UserDetailService userDetailService;


    @PostMapping("/{id}/addFriend")
    public ResponseEntity<?> addFriend(@PathVariable Long id, @RequestBody Users user) {
        FriendsRequest friendsRequest = new FriendsRequest();
        friendsRequest.setReceiver(userService.findById(id).get());
        friendsRequest.setSender(user);
        friendsRequest.setStatus("pending");
        return new ResponseEntity<>(friendRequestService.save(friendsRequest), HttpStatus.OK);
    }


    @GetMapping("{id}/friendRequest")
    public ResponseEntity<?> friendRequest(@PathVariable Long id) {
        return new ResponseEntity<>(friendRequestService.getFriendsRequestByIdReceiver(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/acceptFriendRequest")
    public ResponseEntity<?> acceptFriendRequest(@PathVariable Long id) {
        FriendsRequest friendsRequest = friendRequestService.findById(id);
        friendsRequest.setId(id);
        friendsRequest.setStatus("accept");

        return new ResponseEntity<>(friendRequestService.save(friendsRequest), HttpStatus.OK);
    }

    @PostMapping("/{id}/rejectFriendRequest")
    public ResponseEntity<?> rejectFriendRequest(@PathVariable Long id) {
        friendRequestService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/getStranger")
    public ResponseEntity<?> getStranger(@PathVariable Long id) {
        List<Long> idList = friendRequestService.getStranger(id);
        List<Users> users = new ArrayList<>();
        // Lấy ra những thằng mình không gửi lời mời kết bạn
        for (Long aLong : idList) {
            users.add(userService.findById(aLong).get());
        }
        // Lấy ra những thằng không gửi kết bạn cho mình
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i) == userService.findById(id).get()) {
                users.remove(i);
            }
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
