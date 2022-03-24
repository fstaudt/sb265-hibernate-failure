package com.spring.reproducer.sb265.hibernate.failure.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void findAllByPartialName_ShouldReturnUsers() {
        // First API call is OK
        ResponseEntity<Object> first = restTemplate.getForEntity("/api/users?partialName=staudt", Object.class);
        assertThat(first.getStatusCode()).isEqualTo(OK);
        // Second API call is KO with Spring Boot 2.6.5, OK with 2.6.4
        ResponseEntity<Object> second = restTemplate.getForEntity("/api/users?partialName=staudt", Object.class);
        assertThat(second.getStatusCode()).isEqualTo(OK);
    }
}
