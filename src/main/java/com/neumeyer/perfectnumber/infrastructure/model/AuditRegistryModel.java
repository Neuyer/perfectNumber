package com.neumeyer.perfectnumber.infrastructure.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Table(name = "audit_logs")
@Entity
@Builder
@Data
public class AuditRegistryModel extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ip;
    String useCase;
    String result;
    LocalDateTime requestTime;
}
