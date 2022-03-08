package com.codegym.socialbook_be.user_pack.model;

public class UserSocket {
    private String name;
    private String userNameFriend;

    public UserSocket() {
    }

    public UserSocket(String name, String userNameFriend) {
        this.name = name;
        this.userNameFriend = userNameFriend;
    }

    @Override
    public String toString() {
        return "UserSocket{" +
                "name='" + name + '\'' +
                ", userNameFriend='" + userNameFriend + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserNameFriend() {
        return userNameFriend;
    }

    public void setUserNameFriend(String userNameFriend) {
        this.userNameFriend = userNameFriend;
    }
}
