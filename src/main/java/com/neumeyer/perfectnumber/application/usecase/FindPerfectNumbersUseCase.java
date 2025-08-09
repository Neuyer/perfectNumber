package com.neumeyer.perfectnumber.application.usecase;

import com.neumeyer.perfectnumber.application.request.FindPerfectNumbersRequest;
import com.neumeyer.perfectnumber.application.response.FindPerfectNumbersResponse;
import com.neumeyer.perfectnumber.core.PerfectNumber;
import org.springframework.stereotype.Service;

@Service
public class FindPerfectNumbersUseCase {
    public FindPerfectNumbersResponse execute(FindPerfectNumbersRequest input) {
        var perfectNumber = PerfectNumber.create();

        var numbers = input.numbers();
        var rangeStart = input.start();
        var rangeEnd = input.end();

        var perfectNumbers = perfectNumber.findPerfectNumbersInRange(numbers, rangeStart, rangeEnd);

        return new FindPerfectNumbersResponse(perfectNumbers);
    }
}
