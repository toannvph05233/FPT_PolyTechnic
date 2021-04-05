package com.fpt.vn.model.entitys;


import com.fpt.vn.model.AppUser;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "images")
public class ImgEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;

    @Column(nullable = false,length = 1000)
    private String linkImg;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private PostEntity postEntity;

    public ImgEntity() {
    }

    public ImgEntity(Long id, Long postId, String linkImg, AppUser user) {
        this.id = id;
        this.postId = postId;
        this.linkImg = linkImg;
        this.user = user;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }


}
