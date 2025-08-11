package com.neumeyer.perfectnumber.infrastructure.controller;

import com.neumeyer.perfectnumber.core.audit.AuditRegistry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Validated
@RequestMapping("/admin/audit-logs")
public interface AuditController {
    @GetMapping
    @SecurityRequirement(name = "basicAuth")
    @Operation(
            summary = "Find perfect numbers in a given array",
            description = "Returns a list of perfect numbers found between the start and end values. Consider the START and END values the minor and major values in the array"
    )
    @ApiResponse(responseCode = "200", description = "Successfully found logs.", content = @Content(schema = @Schema(implementation = AuditRegistry.class)))
    ResponseEntity<List<AuditRegistry>> listAll();
}
