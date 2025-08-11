package com.neumeyer.perfectnumber.core.gateway;

import com.neumeyer.perfectnumber.core.audit.AuditRegistry;

import java.util.List;

public interface AuditRegistryGateway {

    void saveAuditRegistry(AuditRegistry auditRegistry);
    List<AuditRegistry> listAll();
}
