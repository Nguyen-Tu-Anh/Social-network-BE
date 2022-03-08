package com.codegym.socialbook_be.user_pack.dto;

import com.codegym.socialbook_be.user_pack.model.Users;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class PostDto {
    private Long id;
    private String content;
    private boolean isPublic;
    private String image;
    private Date time;
    private boolean status;
    private Users users;

    public PostDto() {
    }

    public PostDto(Long id, String content, boolean isPublic, String image, Date time, boolean status, Users users) {
        this.id = id;
        this.content = content;
        this.isPublic = isPublic;
        this.image = image;
        this.time = time;
        this.status = status;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
