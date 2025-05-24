package org.example.services;

import org.example.entity.Tweet;
import org.example.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    // Get all tweets
    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    // Get a single tweet by ID
    public Tweet getTweetById(Long id) {
        return tweetRepository.findById(id).orElse(null);
    }

    // Create a new tweet
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    // Update an existing tweet
    public Tweet updateTweet(Long id, Tweet updatedTweet) {
        Tweet existing = tweetRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setContent(updatedTweet.getContent());
            existing.setImageUrl(updatedTweet.getImageUrl());
            existing.setUser(updatedTweet.getUser());
            return tweetRepository.save(existing);
        }
        return null;
    }

    // Delete a tweet
    public void deleteTweet(Long id) {
        tweetRepository.deleteById(id);
    }
}
