package com.PracticaFinal.madPark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.BDDAssertions.then;

import com.PracticaFinal.madPark.model.Customer;
import com.PracticaFinal.madPark.repository.CustomerRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CustomerControllerTest {
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void usersEndpoinTest() {
        Iterable<Customer> users = repository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/customer";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<Customer>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<Customer>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(users);
    }
}

