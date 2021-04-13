package com.fpt.vn.model.entitys;

import com.fpt.vn.model.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "post")
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date createAt;

    @Column(nullable = false)
    private int status;

    private String content;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "postTypeId")
    private PostTypeEntity postType;


    private Long likes;

//    @OneToMany(mappedBy = "postId", fetch = FetchType.EAGER)
//    private List<ImgEntity> imgs = new ArrayList<>();
//
//    @OneToMany(targetEntity = CommentForm.class)
//    private List<CommentForm> listComment;

    public PostEntity() {
    }

    public PostEntity(Long id, Date createAt, int status, String content, AppUser user, PostTypeEntity postType, Long likes) {
        this.id = id;
        this.createAt = createAt;
        this.status = status;
        this.content = content;
        this.user = user;
        this.postType = postType;
        this.likes = likes;
    }

    public PostTypeEntity getPostType() {
        return postType;
    }

    public void setPostType(PostTypeEntity postType) {
        this.postType = postType;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
