package com.neumeyer.perfectnumber.application.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record FindPerfectNumbersRequest(
        @Schema(description = "Array where the perfect numbers will be found. Must not be empty.",
                example = "[0,1000000]")
        @NotEmpty
        List<Integer> numbers
) {
}
