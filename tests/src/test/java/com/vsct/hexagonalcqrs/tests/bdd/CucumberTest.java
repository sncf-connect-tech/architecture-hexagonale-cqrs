package com.vsct.hexagonalcqrs.tests.bdd;

import com.vsct.hexagonalcqrs.HexagonalCQRSApplication;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.LocalHostUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class CucumberTest {

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @ContextConfiguration(classes = {HexagonalCQRSApplication.class, RestTemplateConfig.class}, loader = SpringBootContextLoader.class)
    public static class CucumberSpringContextConfiguration {
        @Before
        public void setUp() {
            // Initialisation du contexte Spring
        }
    }

    @Configuration
    public static class RestTemplateConfig {
        @Bean
        public RestTemplate restTemplate(Environment environment) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setUriTemplateHandler(new LocalHostUriTemplateHandler(environment));
            return restTemplate;
        }
    }
}
