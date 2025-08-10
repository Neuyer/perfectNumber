package com.neumeyer.perfectnumber.infrastructure.controller;

import com.neumeyer.perfectnumber.application.request.FindPerfectNumbersRequest;
import com.neumeyer.perfectnumber.application.response.FindPerfectNumbersResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/perfect-numbers")
public interface PerfectNumberController {
    @PostMapping
    @Operation(summary = "Find perfect numbers in a given array", description = "Returns a list of perfect numbers found between the start and end values. Consider the START and END values the minor and major values in the array")
    @ApiResponse(responseCode = "200", description = "Successfully found perfect numbers.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = FindPerfectNumbersResponse.class))))
    @ApiResponse(responseCode = "400", description = "Invalid array provided.", content = @Content(schema = @Schema(implementation = ResponseEntity.class)))
    @ApiResponse(responseCode = "422", description = "Invalid array provided.", content = @Content(schema = @Schema(implementation = ResponseEntity.class)))
    ResponseEntity<FindPerfectNumbersResponse> findPerfectNumbers(@Valid @RequestBody FindPerfectNumbersRequest request);
}
