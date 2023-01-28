package com.system.backend.outbound.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.system.backend.outbound"})
@EnableJpaRepositories(basePackages = {"com.system.backend.outbound.repository"})
public class OutboundConfiguration {
}
