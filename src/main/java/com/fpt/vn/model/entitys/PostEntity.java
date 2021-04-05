package com.fpt.vn.model.entitys;

import com.fpt.vn.model.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    private Long postIdShear;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser user;

    private Long likes;
    @OneToMany(mappedBy = "postId", fetch = FetchType.EAGER)
    private List<ImgEntity> imgs = new ArrayList<>();

    @OneToMany(targetEntity = CommentForm.class)
    private List<CommentForm> listComment;

    public PostEntity() {
    }

    public PostEntity(Long id, Date createAt, int status,String content, Long postIdShear, AppUser user, List<ImgEntity> imgs) {
        this.id = id;
        this.createAt = createAt;
        this.status = status;
        this.content = content;
        this.postIdShear = postIdShear;
        this.user = user;
        this.imgs = imgs;
    }

    public List<ImgEntity> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgEntity> imgs) {
        this.imgs = imgs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostIdShear() {
        return postIdShear;
    }

    public void setPostIdShear(Long postIdShear) {
        this.postIdShear = postIdShear;
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
