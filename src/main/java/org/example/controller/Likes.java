// =============================
// Controller: LikeController.java
// =============================
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

    @PostMapping
    public Like createLike(@RequestParam Long userId, @RequestParam Long tweetId) {
        return likeService.createLike(userId, tweetId);
    }

    @GetMapping
    public List<Like> getLikes(@RequestParam Long tweetId) {
        return likeService.getLikesByTweetId(tweetId);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id, @RequestParam Long userId) {
        likeService.deleteLike(id, userId);
    }
}

// Dependencies (not shown here but required):
// - Tweet.java
// - User.java (with private flag)
// - TweetRepository.java
// - UserRepository.java
// - FollowerRepository.java (with method existsByFollowerIdAndFollowedId)
