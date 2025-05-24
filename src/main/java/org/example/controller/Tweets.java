package org.example.controller;

import org.example.entity.Tweet;
import org.example.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class Tweets {

    @Autowired
    private TweetService tweetService;

    // GET all tweets
    @GetMapping
    public List<Tweet> getAllTweets() {
        return tweetService.getAllTweets(); // Fixed static call
    }

    // GET tweet by ID
    @GetMapping("/{id}")
    public Tweet getTweetById(@PathVariable Long id) {
        return tweetService.getTweetById(id);
    }

    // POST new tweet
    @PostMapping
    public Tweet createTweet(@RequestBody Tweet tweet) {
        return tweetService.createTweet(tweet);
    }

    // PUT update tweet
    @PutMapping("/{id}")
    public Tweet updateTweet(@PathVariable Long id, @RequestBody Tweet updatedTweet) {
        return tweetService.updateTweet(id, updatedTweet);
    }

    // DELETE tweet by ID
    @DeleteMapping("/{id}")
    public void deleteTweet(@PathVariable Long id) {
        tweetService.deleteTweet(id);
    }
}
