package com.neumeyer.perfectnumber.core.gateway;

import com.neumeyer.perfectnumber.core.audit.AuditRegistry;

public interface AuditRegistryGateway {

    void saveAuditRegistry(AuditRegistry auditRegistry);
}
