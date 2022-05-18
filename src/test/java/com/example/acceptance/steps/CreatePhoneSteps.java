package com.example.acceptance.steps;

import com.example.config.TestClient;
import com.example.model.Phone;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class CreatePhoneSteps {

    @Autowired
    private TestClient testClient;
    private Phone phoneRequest;
    private Phone phoneResponse;

    @Given("the the following phone")
    public void theTheFollowingPhone(Phone phone) {
        this.phoneRequest = phone;
    }

    @When("the user requests add phone")
    public void theUserRequestsToAllPhone() {
        this.phoneResponse = testClient.post(phoneRequest);
    }

    @Then("success response with the phone created")
    public void successResponseWithThePhoneCreated() {
        Assertions.assertNotNull(phoneResponse);
        Assertions.assertNotNull(phoneResponse.getId());
        Assertions.assertNotNull(phoneResponse.getCratedAt());
    }

}
