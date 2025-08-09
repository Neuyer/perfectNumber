package com.neumeyer.perfectnumber.application.request;

import java.util.List;

public record FindPerfectNumbersRequest(
        List<Integer> numbers,
        int start,
        int end
) {
}
