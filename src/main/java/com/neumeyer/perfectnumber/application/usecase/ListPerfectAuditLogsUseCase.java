package com.neumeyer.perfectnumber.application.usecase;

import com.neumeyer.perfectnumber.application.request.FindPerfectNumbersRequest;
import com.neumeyer.perfectnumber.core.audit.AuditRegistry;
import com.neumeyer.perfectnumber.core.gateway.AuditRegistryGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ListPerfectAuditLogsUseCase {
    private final AuditRegistryGateway auditRegistryGateway;

    public ListPerfectAuditLogsUseCase(AuditRegistryGateway auditRegistryGateway) {
        this.auditRegistryGateway = auditRegistryGateway;
    }

    public List<AuditRegistry> execute() {
        log.info("Listing audit logs");

        var logs = auditRegistryGateway.listAll();

        log.info("audit logs found: {}", logs.size());

        return logs;
    }
}
