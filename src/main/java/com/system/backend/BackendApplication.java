package com.system.backend;

import com.system.backend.core.configuration.CoreConfiguration;
import com.system.backend.core.security.configuration.SecurityConfiguration;
import com.system.backend.inbound.configuration.InboundConfiguration;
import com.system.backend.outbound.configuration.OutboundConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{BackendApplication.class,
                CoreConfiguration.class,
                InboundConfiguration.class,
                OutboundConfiguration.class,
                SecurityConfiguration.class}, args);
    }

}
