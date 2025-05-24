package org.example.controller;

import org.example.entity.Like;
import org.example.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class Likes {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }

    @GetMapping("/tweet/{tweetId}")
    public List<Like> getLikesByTweet(@PathVariable Long tweetId) {
        return likeService.getLikesByTweetId(tweetId);
    }

    @GetMapping("/tweet/{tweetId}/count")
    public long getLikeCount(@PathVariable Long tweetId) {
        return likeService.getLikeCountByTweetId(tweetId);
    }

    @PostMapping
    public Like createLike(@RequestParam Long userId, @RequestParam Long tweetId) {
        return likeService.createLike(userId, tweetId);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
    }
}
