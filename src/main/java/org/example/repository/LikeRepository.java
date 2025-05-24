package org.example.repository;

import org.example.entity.Like;
import org.example.entity.Tweet;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByTweet(Tweet tweet);
    List<Like> findByUser(User user);
    boolean existsByUserAndTweet(User user, Tweet tweet);
    long countByTweet(Tweet tweet); // For like count
}
