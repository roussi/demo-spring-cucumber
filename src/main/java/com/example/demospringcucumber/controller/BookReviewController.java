package com.example.demospringcucumber.controller;

import com.example.demospringcucumber.model.BookReview;
import com.example.demospringcucumber.repository.BookReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author aroussi
 * @version %I% %G%
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/book-review")
public class BookReviewController {

    private final BookReviewRepository bookReviewRepository;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<BookReview> getAllBookReview() {
        return bookReviewRepository.findAll();
    }

    @GetMapping(value = "/{id}" ,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BookReview> findBookReviewById(@PathVariable("id") Long id) {
        Optional<BookReview> bookReviewById = bookReviewRepository.findById(id);
        return bookReviewById.map(r-> ResponseEntity.ok(r)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity createBookReview(@RequestBody BookReview bookReview) {
        BookReview review = bookReviewRepository.save(bookReview);
        return Optional.ofNullable(review)
                .map(r-> ResponseEntity.created(URI.create("/api/v1/book-review/" + r.getId())).build())
                .orElseGet(()-> ResponseEntity.status(500).body("Could not save data to bd"));
    }
}
