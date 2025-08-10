package com.neumeyer.perfectnumber.application.gatewayimpl;

import com.neumeyer.perfectnumber.core.audit.AuditRegistry;
import com.neumeyer.perfectnumber.core.gateway.AuditRegistryGateway;
import com.neumeyer.perfectnumber.infrastructure.model.AuditRegistryModel;
import com.neumeyer.perfectnumber.infrastructure.repository.AuditLogsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class AuditRegistryGatewayImpl implements AuditRegistryGateway {

    private final AuditLogsRepository auditLogsRepository;

    public AuditRegistryGatewayImpl(AuditLogsRepository auditLogsRepository) {
        this.auditLogsRepository = auditLogsRepository;
    }

    @Override
    public void saveAuditRegistry(AuditRegistry audit) {
        var model = AuditRegistryModel
                .builder()
                .ip(audit.getIp())
                .useCase(audit.getUseCase())
                .requestTime(audit.getStartTime())
                .result(audit.getResult())
                .build();

        auditLogsRepository.save(model);
        log.info("audit_log saved {}", model);
    }
}
