package com.example.demospringcucumber.repository;

import com.example.demospringcucumber.model.BookReview;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author aroussi
 * @version %I% %G%
 */
public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
    @EntityGraph(attributePaths = {"comments"})
    Optional<BookReview> findById(Long id);
}
