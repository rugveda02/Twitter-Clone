// =============================
// Service: LikeService.java
// =============================
package org.example.services;

import org.example.entity.*;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowerRepository followerRepository;

    public Like createLike(Long userId, Long tweetId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new EntityNotFoundException("Tweet not found"));

        if (tweet.getUser().isPrivate()) {
            boolean isFollower = followerRepository.existsByFollowerIdAndFollowedId(userId, tweet.getUser().getId());
            if (!isFollower) {
                throw new SecurityException("Cannot like a private tweet without being a follower.");
            }
        }

        if (likeRepository.findByUserAndTweet(user, tweet).isPresent()) {
            throw new IllegalStateException("You already liked this tweet.");
        }

        Like like = new Like();
        like.setUser(user);
        like.setTweet(tweet);
        return likeRepository.save(like);
    }

    public List<Like> getLikesByTweetId(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new EntityNotFoundException("Tweet not found"));
        return likeRepository.findByTweet(tweet);
    }

    public void deleteLike(Long likeId, Long userId) {
        Like like = likeRepository.findById(likeId).orElseThrow(() -> new EntityNotFoundException("Like not found"));
        if (!like.getUser().getId().equals(userId)) {
            throw new SecurityException("You can only delete your own likes.");
        }
        likeRepository.delete(like);
    }
}

