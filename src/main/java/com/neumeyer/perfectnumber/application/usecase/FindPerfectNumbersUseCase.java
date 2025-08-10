package com.neumeyer.perfectnumber.application.usecase;

import com.neumeyer.perfectnumber.application.request.FindPerfectNumbersRequest;
import com.neumeyer.perfectnumber.application.response.FindPerfectNumbersResponse;
import com.neumeyer.perfectnumber.application.utils.RemoteAddressUtils;
import com.neumeyer.perfectnumber.core.PerfectNumber;
import com.neumeyer.perfectnumber.core.audit.AuditRegistry;
import com.neumeyer.perfectnumber.core.gateway.AuditRegistryGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FindPerfectNumbersUseCase {
    private final AuditRegistryGateway auditRegistryGateway;
    private final PerfectNumber perfectNumber;
    private final RemoteAddressUtils remoteAddressUtils;

    public FindPerfectNumbersUseCase(AuditRegistryGateway auditRegistryGateway, PerfectNumber perfectNumber, RemoteAddressUtils remoteAddressUtils) {
        this.auditRegistryGateway = auditRegistryGateway;
        this.perfectNumber = perfectNumber;
        this.remoteAddressUtils = remoteAddressUtils;
    }

    public FindPerfectNumbersResponse execute(FindPerfectNumbersRequest input) {
        var clientAddress = remoteAddressUtils.getClientIp();

        var audit = AuditRegistry.create(clientAddress, this.getClass());

        log.info("Find perfect numbers request: {}", input);

        var numbers = input.numbers();
        var perfectNumbers = perfectNumber.findPerfectNumbersInArray(numbers);

        audit.updateResult(perfectNumbers.toString());
        auditRegistryGateway.saveAuditRegistry(audit);

        log.info("Find perfect numbers result: {}", perfectNumbers);

        return new FindPerfectNumbersResponse(perfectNumbers);
    }
}
