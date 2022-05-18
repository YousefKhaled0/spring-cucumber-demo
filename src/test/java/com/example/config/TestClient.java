package com.example.config;

import com.example.model.Phone;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class TestClient {

    private static final String SERVER_URL = "http://localhost";

    private final String ENDPOINT = "/api/phones";

    private final RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    private int port;

    private String url() {
        return SERVER_URL + ":" + port + ENDPOINT;
    }

    public Phone post(Phone phone) {
        return restTemplate.postForObject(url(), phone, Phone.class);
    }


    public Phone get(UUID id) {
        return restTemplate.getForObject(String.format("%s/%s", url(), id), Phone.class);
    }

    public ResponseEntity<Void> delete(UUID id) {
        return restTemplate.exchange(String.format("%s/%s", url(), id), HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
    }

    public List<Phone> getAll() {
        ResponseEntity<List<Phone>> response = restTemplate.exchange(url(), HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Phone>>() {
        });
        return response.getBody();
    }
}
