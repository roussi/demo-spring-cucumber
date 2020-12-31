package com.example.demospringcucumber.cucumber.glue;

import com.example.demospringcucumber.DemoSpringCucumberApplication;
import com.example.demospringcucumber.DemoSpringCucumberApplicationTests;
import com.example.demospringcucumber.controller.BookReviewController;
import com.example.demospringcucumber.cucumber.SpringCucumberIntegrationTest;
import com.example.demospringcucumber.cucumber.data.SharedDataHolder;
import com.example.demospringcucumber.model.BookReview;
import com.example.demospringcucumber.repository.BookReviewRepository;
import com.example.demospringcucumber.response.GreetingResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

import static com.example.demospringcucumber.cucumber.data.SharedDataHolder.response;

/**
 * @author aroussi
 * @version %I% %G%
 */
public class StepDefinitions {

    @Autowired
    BookReviewRepository bookReviewRepository;

    private static WebClient webClient;

    @BeforeAll
    static void init() {
        webClient = WebClient.builder()
                .baseUrl("http://localhost:" + DemoSpringCucumberApplicationTests.port)
                .build();
    }

    @Given("^The book reviews bellow$")
    public void given_the_book_reviews_bellow(List<BookReview> bookReviews) {
        if (Objects.nonNull(bookReviews)) {
            bookReviewRepository.saveAll(bookReviews);
        }
    }

    @When("^I send a Get to ([^\"]*)$")
    public void i_send_a_get_to(String url) {
        response = webClient.get()
                .uri(url)
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();
    }

    @Then("^I get the response json$")
    public void i_get_the_response(String jsonResponse) {
        System.out.println("Response : " + response);
        System.out.println("Expectation : " + jsonResponse);
    }
}
