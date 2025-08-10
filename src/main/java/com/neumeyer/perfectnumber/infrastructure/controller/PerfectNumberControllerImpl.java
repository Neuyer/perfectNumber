package com.neumeyer.perfectnumber.infrastructure.controller;

import com.neumeyer.perfectnumber.application.request.FindPerfectNumbersRequest;
import com.neumeyer.perfectnumber.application.response.FindPerfectNumbersResponse;
import com.neumeyer.perfectnumber.application.usecase.FindPerfectNumbersUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController("perfectNumbersController")
public class PerfectNumberControllerImpl implements PerfectNumberController {

    private final FindPerfectNumbersUseCase findPerfectNumbersUsecase;

    public PerfectNumberControllerImpl(FindPerfectNumbersUseCase findPerfectNumbersUsecase) {
        this.findPerfectNumbersUsecase = findPerfectNumbersUsecase;
    }

    @Override
    public ResponseEntity<FindPerfectNumbersResponse> findPerfectNumbers(FindPerfectNumbersRequest request) {
        var response = findPerfectNumbersUsecase.execute(request);
        return ResponseEntity.ok(response);
    }

}
