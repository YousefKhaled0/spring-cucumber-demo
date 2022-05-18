package com.example.acceptacnce.steps;

import com.example.config.TestClient;
import com.example.model.Phone;
import com.example.repository.PhoneRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class PhoneGetAndDeleteSteps {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private TestClient testClient;

    private UUID id;

    private Phone phoneResponse;

    @Given("the the following phones with IDs")
    public void theTheFollowingPhonesWithIDs(List<Phone> phones) {
        phoneRepository.saveAll(phones);
    }

    @When("^the user requests to get phone with id (.*)$")
    public void theUserRequestsToGetPhoneWithId(UUID uuid) {
        this.id = uuid;
        this.phoneResponse = testClient.get(id);
    }

    @When("^the user requests to delete phone with id (.*)$")
    public void theUserRequestsToDeletePhoneWithId(UUID uuid) {
        this.id = uuid;
    }

    @Then("success response with the phone details")
    public void successResponseWithThePhoneDetails() {
        Assertions.assertNotNull(phoneResponse);
        Assertions.assertEquals(id.toString(), phoneResponse.getId());
    }

    @Then("the phone is deleted with no content response")
    public void thePhoneIsDeletedWithNoContentResponse() {
        ResponseEntity<Void> deleteResponse = testClient.delete(id);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());
    }
}
