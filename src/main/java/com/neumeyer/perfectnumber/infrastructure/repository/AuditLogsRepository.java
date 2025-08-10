package com.neumeyer.perfectnumber.infrastructure.repository;

import com.neumeyer.perfectnumber.infrastructure.model.AuditRegistryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogsRepository extends JpaRepository<AuditRegistryModel, Long> {
}
