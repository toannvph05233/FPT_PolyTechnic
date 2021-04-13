package com.fpt.vn.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PostModel {
    private Long id;
    private Date createAt;
    private int status;
    private String content;
    private Long userId;
    private String imgs;

    public PostModel(Long id, Date createAt, int status, String content, Long userid, String imgs) {
        this.id = id;
        this.createAt = createAt;
        this.status = status;
        this.content = content;
        this.userId = userid;
        this.imgs = imgs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userid) {
        this.userId = userid;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public PostModel() {
    }
}

