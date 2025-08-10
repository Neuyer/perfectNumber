package com.neumeyer.perfectnumber.infrastructure.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseModel {
    private LocalDateTime saveTime;

    @PrePersist
    public void onPrePersist() {
        this.setSaveTime(LocalDateTime.now());
    }
}
