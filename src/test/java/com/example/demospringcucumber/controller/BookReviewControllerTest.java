package com.example.demospringcucumber.controller;

import com.example.demospringcucumber.DemoSpringCucumberApplication;
import com.example.demospringcucumber.DemoSpringCucumberApplicationTests;
import com.example.demospringcucumber.model.BookReview;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.HeaderAssertions;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = {DemoSpringCucumberApplication.class})
@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookReviewControllerTest {

    public static final String API_V1_BOOK_REVIEW = "/api/v1/book-review";
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testContextIsUp() {
        assertNotNull(webTestClient);
    }

    @Test
    @Order(1)
    public void findAllBookReviewShouldReturnNothing() {
        webTestClient.get()
        .uri(URI.create(API_V1_BOOK_REVIEW))
        .exchange()
        .expectBodyList(BookReview.class)
        .hasSize(0);
    }

    @Test
    @Order(2)
    public void shouldCreateOneElement() {
        BookReview bookReview = BookReview.builder()
                .bookTitle("JPA in action")
                .bookImagePath("/tmp/projects/lab/jpa-example/jpa-in-action.jpg")
                .build();
        webTestClient.post()
                .uri(URI.create(API_V1_BOOK_REVIEW))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(bookReview)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().value(HttpHeaders.LOCATION, Matchers.equalTo("/api/v1/book-review/1"));
    }

    @Test
    @Order(3)
    public void shouldFindBookReviewById() {
        final Long bookReviewId = 1L;
        webTestClient.get()
                .uri(URI.create(API_V1_BOOK_REVIEW + "/" + bookReviewId))
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("$.bookTitle").value(Matchers.equalTo("JPA in action"));
    }

    @Test
    public void checkThatThereIsOneBookReview() {

    }
}