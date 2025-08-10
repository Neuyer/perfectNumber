package com.neumeyer.perfectnumber.application.config;

import com.neumeyer.perfectnumber.core.PerfectNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    PerfectNumber perfectNumber() {
        return PerfectNumber.create();
    }
}
