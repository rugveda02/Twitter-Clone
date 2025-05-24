// =============================
// Repository: LikeRepository.java
// =============================
package org.example.repository;

import org.example.entity.Like;
import org.example.entity.Tweet;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByTweet(Tweet tweet);
    Optional<Like> findByUserAndTweet(User user, Tweet tweet);
}

