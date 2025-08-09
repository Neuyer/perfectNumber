package com.neumeyer.perfectnumber.infrastructure.controller;

import com.neumeyer.perfectnumber.application.request.FindPerfectNumbersRequest;
import com.neumeyer.perfectnumber.application.response.FindPerfectNumbersResponse;
import com.neumeyer.perfectnumber.application.usecase.FindPerfectNumbersUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfect-numbers")
public class PerfectNumberController {

    private final FindPerfectNumbersUseCase findPerfectNumbersUsecase;

    public PerfectNumberController(FindPerfectNumbersUseCase findPerfectNumbersUsecase) {
        this.findPerfectNumbersUsecase = findPerfectNumbersUsecase;
    }

    @PostMapping
    public ResponseEntity<FindPerfectNumbersResponse> findPerfectNumbers(@RequestBody FindPerfectNumbersRequest request) {
        var response = findPerfectNumbersUsecase.execute(request);
        return ResponseEntity.ok(response);
    }

}
