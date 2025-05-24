package org.example.services;

import org.example.entity.Like;
import org.example.entity.Tweet;
import org.example.entity.User;
import org.example.repository.LikeRepository;
import org.example.repository.TweetRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    public List<Like> getLikesByTweetId(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElse(null);
        return tweet != null ? likeRepository.findByTweet(tweet) : null;
    }

    public long getLikeCountByTweetId(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElse(null);
        return tweet != null ? likeRepository.countByTweet(tweet) : 0;
    }

    public Like createLike(Long userId, Long tweetId) {
        User user = userRepository.findById(userId).orElse(null);
        Tweet tweet = tweetRepository.findById(tweetId).orElse(null);

        if (user == null || tweet == null || likeRepository.existsByUserAndTweet(user, tweet)) {
            return null;
        }

        Like like = new Like();
        like.setUser(user);
        like.setTweet(tweet);
        return likeRepository.save(like);
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
