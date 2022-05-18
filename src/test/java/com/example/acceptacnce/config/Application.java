package com.example.acceptacnce.config;

import com.example.config.TestClient;
import com.example.config.TestMongoConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@CucumberContextConfiguration
@Import(TestClient.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestMongoConfiguration.class)
public class Application {
}
