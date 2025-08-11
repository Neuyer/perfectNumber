package com.neumeyer.perfectnumber.infrastructure.controller;

import com.neumeyer.perfectnumber.application.usecase.ListPerfectAuditLogsUseCase;
import com.neumeyer.perfectnumber.core.audit.AuditRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditControllerImpl implements AuditController {

    private final ListPerfectAuditLogsUseCase listPerfectAuditLogsUseCase;

    public AuditControllerImpl(ListPerfectAuditLogsUseCase listPerfectAuditLogsUseCase) {
        this.listPerfectAuditLogsUseCase = listPerfectAuditLogsUseCase;
    }

    @Override
    public ResponseEntity<List<AuditRegistry>> listAll() {
        var logs = listPerfectAuditLogsUseCase.execute();
        return ResponseEntity.ok(logs);
    }
}
