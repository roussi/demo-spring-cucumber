package com.example.demospringcucumber.cucumber.glue;

import com.example.demospringcucumber.response.GreetingResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author aroussi
 * @version %I% %G%
 */
public class StepDefinitions {

    @When("I send a Get to \\/greeting\\/abdel$")
    public void i_send_a_get_to() {
        System.out.println("url");
    }

    @Then("I get the response")
    public void i_get_the_response(GreetingResponse response) {
        System.out.println(response);
    }
}
