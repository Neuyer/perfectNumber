package com.neumeyer.perfectnumber.core.audit;

import com.neumeyer.perfectnumber.core.exception.PerfectNumberException;

import java.net.InetAddress;
import java.time.LocalDateTime;

public class AuditRegistry {
    private String ip;
    private String useCase;
    private String result;
    private LocalDateTime startTime;

    public String getIp() {
        return ip;
    }

    public String getUseCase() {
        return useCase;
    }

    public String getResult() {
        return result;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    private AuditRegistry(String ip, String useCase, String result, LocalDateTime startTime) {
        if (ip == null)
            throw new PerfectNumberException("ip must not be null");
        this.ip = ip;
        if (useCase == null)
            throw new PerfectNumberException("use case must not be null");
        this.useCase = useCase;
        if (result == null)
            throw new PerfectNumberException("result case must not be null");
        this.result = result;
        if (startTime == null)
            throw new PerfectNumberException("startTime must not be null");
        this.startTime = startTime;
    }

    private AuditRegistry(InetAddress ip, Class<?> useCase) {
        if (ip == null)
            throw new PerfectNumberException("ip must not be null");
        this.ip = ip.getHostAddress();
        if (useCase == null)
            throw new PerfectNumberException("use case must not be null");
        this.useCase = useCase.getSimpleName();
        this.startTime = LocalDateTime.now();
    }

    public static AuditRegistry create(InetAddress ip, Class<?> event) {
        return new AuditRegistry(ip, event);
    }

    public static AuditRegistry load(String ip, String useCase, String result, LocalDateTime startTime) {
        return new AuditRegistry(ip, useCase, result, startTime);
    }

    public void updateResult(String result) {
        if (result == null || result.isBlank())
            throw new PerfectNumberException("result must not be null");
        if (result.getBytes().length > 255)
            throw new PerfectNumberException("result too long, max 255 bytes");
        this.result = result;
    }


}
