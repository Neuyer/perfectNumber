package com.neumeyer.perfectnumber.infrastructure.controller;

import com.neumeyer.perfectnumber.application.request.FindPerfectNumbersRequest;
import com.neumeyer.perfectnumber.application.response.FindPerfectNumbersResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PerfectNumberControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void whenValidRequest_thenReturnsPerfectNumbers() {

        FindPerfectNumbersRequest request = new FindPerfectNumbersRequest(List.of(1, 6, 10, 28, 50));

        ResponseEntity<FindPerfectNumbersResponse> response = restTemplate.postForEntity(
                "/perfect-numbers",
                request,
                FindPerfectNumbersResponse.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().perfectNumbers()).containsExactly(6, 28);
    }

    @Test
    void whenNoPerfectNumbersFound_thenReturnsEmptyList() {
        FindPerfectNumbersRequest request = new FindPerfectNumbersRequest(List.of(1, 2, 3, 4, 5));

        ResponseEntity<FindPerfectNumbersResponse> response = restTemplate.postForEntity(
                "/perfect-numbers",
                request,
                FindPerfectNumbersResponse.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().perfectNumbers()).isEmpty();
    }

    @Test
    void whenInvalidRequest_thenReturnsBadRequest() {
        FindPerfectNumbersRequest request = new FindPerfectNumbersRequest(Collections.emptyList());

        ResponseEntity<?> response = restTemplate.postForEntity(
                "/perfect-numbers",
                request,
                Map.class
        );
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();
    }
}
