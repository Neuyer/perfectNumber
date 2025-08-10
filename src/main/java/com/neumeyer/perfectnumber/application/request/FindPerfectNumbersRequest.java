package com.neumeyer.perfectnumber.application.request;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record FindPerfectNumbersRequest(
        @Parameter(description = "Array where the perfect numbers will be found. Must not be empty.")
        @NotEmpty
        List<Integer> numbers
) {
}
