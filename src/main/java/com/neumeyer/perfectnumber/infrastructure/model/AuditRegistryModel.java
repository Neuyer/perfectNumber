package com.neumeyer.perfectnumber.infrastructure.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audit_logs")
@EqualsAndHashCode(callSuper = true)
public class AuditRegistryModel extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ip;
    String useCase;
    String result;
    LocalDateTime requestTime;
}
