package com.codegym.socialbook_be.user_pack.dto;

import com.codegym.socialbook_be.user_pack.model.Comment;
import com.codegym.socialbook_be.user_pack.model.Users;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class PostDto {
    private Long id;
    private String content;
    private boolean isPublic;
    private String image;
    private LocalDateTime time;
    private boolean status;
    private Users users;
    private List<Comment> comments;

    public PostDto() {
    }

    public PostDto(Long id, String content, boolean isPublic, String image, LocalDateTime time, boolean status, Users users) {
        this.id = id;
        this.content = content;
        this.isPublic = isPublic;
        this.image = image;
        this.time = time;
        this.status = status;
        this.users = users;
    }

    public PostDto(Long id, String content, boolean isPublic, String image, LocalDateTime time, boolean status, Users users, List<Comment> comments) {
        this.id = id;
        this.content = content;
        this.isPublic = isPublic;
        this.image = image;
        this.time = time;
        this.status = status;
        this.users = users;
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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
