package com.fpt.vn.controllers;

import com.fpt.vn.model.AppUser;
import com.fpt.vn.model.PostModel;
import com.fpt.vn.model.entitys.ImgEntity;
import com.fpt.vn.model.entitys.PostEntity;
import com.fpt.vn.service.CommentService;
import com.fpt.vn.service.IImgService;
import com.fpt.vn.service.PostService;
import com.fpt.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/post")
public class PostController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private IImgService iImgService;
    @Autowired
    private CommentService commentService;

//    @Autowired
//    private PostLikeService postLikeService;
//    String UPLOADED_FOLDER = "/D:/BESocialMedia/src/main/resources/img/";

    @PostMapping("/create")
    public ResponseEntity addPost(@RequestBody PostModel postModel) {
        AppUser user = (userService.findById(postModel.getUser().getId())).isPresent() ?
                userService.findById(postModel.getUser().getId()).get() : null;
        PostEntity postEntity = new PostEntity();
        Date date = new Date(Calendar.getInstance().getTime().getTime());

        postEntity.setCreateAt(date);
        postEntity.setUser(user);
        postEntity.setStatus(postModel.getStatus());
        postEntity.setContent(postModel.getContent());


        if (postModel.getImgs() != "") {
            ImgEntity imgEntity = new ImgEntity();
            imgEntity.setLinkImg(postModel.getImgs());
            imgEntity.setUser(user);
            postService.savePost(postEntity);

            List<PostEntity> listPost = (List<PostEntity>) postService.findAll();
            imgEntity.setPostId(listPost.get(listPost.size() - 1).getId());
            iImgService.save(imgEntity);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            postService.savePost(postEntity);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @PostMapping("/edit/{idUser}")
    public ResponseEntity editPost(@RequestBody PostModel postModel, @PathVariable Long idUser) {
        AppUser user = (userService.findById(idUser)).isPresent() ?
                userService.findById(idUser).get() : null;

        PostEntity postEntity = postService.findById(postModel.getId()).get();
        postEntity.setStatus(postModel.getStatus());
        postEntity.setContent(postModel.getContent());

        ImgEntity imgEntity = new ImgEntity();
        imgEntity.setLinkImg(postModel.getImgs());
//        List<ImgEntity> listImg = new ArrayList<>();
//        listImg.add(imgEntity);
//        postEntity.setImgs(listImg);

        imgEntity.setUser(user);
        postService.savePost(postEntity);

        imgEntity.setPostId(postEntity.getId());
        iImgService.save(imgEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/editAndImg/{idImg}")
    public ResponseEntity editPostAndImg(@RequestBody PostModel postModel, @PathVariable Long idImg) {
        PostEntity postEntity = postService.findById(postModel.getId()).get();
        postEntity.setStatus(postModel.getStatus());
        postEntity.setContent(postModel.getContent());

        ImgEntity imgEntity = iImgService.findById(idImg).get();
        imgEntity.setLinkImg(postModel.getImgs());

        postService.savePost(postEntity);
        iImgService.save(imgEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/allPost")
    public ResponseEntity<Iterable<PostEntity>> getAll() {
        Iterable<PostEntity> listPost = postService.findAllByStatus(1);
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

    @GetMapping("/allPostByUserId/{idUser}")
    public ResponseEntity<Iterable<PostEntity>> getAllByUserId(@PathVariable Long idUser) {
        Iterable<PostEntity> listPost = postService.findAllByUserId(idUser);
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

    @GetMapping("/findPostById/{idPost}")
    public ResponseEntity<PostEntity> findPostById(@PathVariable Long idPost) {
        PostEntity post = postService.findById(idPost).get();
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/findPostByContent/{idUser}/{content}")
    public ResponseEntity<Iterable<PostEntity>> findPostByContent(@PathVariable String content,@PathVariable Long idUser) {
        Iterable<PostEntity> listPost = postService.findAllByContent(content,idUser);
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

    @PostMapping("/changStatusTrue/{idPost}")
    public ResponseEntity changStatusTrue(@PathVariable Long idPost) {
        postService.changStatusPostTrue(idPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/changStatusFalse/{idPost}")
    public ResponseEntity changStatusFalse(@PathVariable Long idPost) {
        postService.changStatusPostFalse(idPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deletePost/{idPost}")
    public ResponseEntity deletePost(@PathVariable Long idPost) {
        PostEntity postEntity = postService.findById(idPost).get();
        postService.deletePost(postEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @GetMapping("/posts/{post-id}/post-likes")
//    public ResponseEntity<Iterable<PostLike>> getAllLikesByPostId(@PathVariable("post-id") Long postId) {
//        Iterable<PostLike> postLike = this.postLikeService.findAllByPostEntityId(postId);
//        return new ResponseEntity<>(postLike, HttpStatus.OK);
//    }
//
//    @PostMapping("/posts/{id}/comments")
//    public ResponseEntity<Optional<PostEntity>> comment(@PathVariable("id") Long id, @RequestBody CommentForm commentForm) {
//        commentService.save(commentForm);
//        Optional<PostEntity> postEntity = postService.findById(id);
//        if (postEntity.isPresent()) {
//            postEntity.get().getListComment().add(commentForm);
//            postService.savePost(postEntity.get());
//            return new ResponseEntity<>(postEntity, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
