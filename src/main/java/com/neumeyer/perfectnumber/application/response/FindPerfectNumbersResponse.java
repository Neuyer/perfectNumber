package com.neumeyer.perfectnumber.application.response;

import java.util.List;

public record FindPerfectNumbersResponse(
        List<Integer> perfectNumbers
) {
}
