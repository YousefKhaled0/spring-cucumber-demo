package com.example.acceptacnce.steps;

import com.example.config.TestClient;
import com.example.model.Phone;
import com.example.repository.PhoneRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetAllSteps {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private TestClient testClient;

    @Given("the the following phones")
    public void theTheFollowingPhones(List<Phone> phones) {
        phoneRepository.saveAll(phones);
    }

    @When("the user requests all phones")
    public void theUserRequestsAllPhones() {
    }

    @Then("all phones are returned")
    public void allPhonesAreReturned() {
        Assertions.assertEquals(4, testClient.getAll().size());
    }
}
