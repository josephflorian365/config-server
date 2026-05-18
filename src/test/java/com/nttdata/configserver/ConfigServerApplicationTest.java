package com.nttdata.configserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfigServerApplicationTest {

    @Test
    void shouldBeAnnotatedAsSpringBootAndConfigServer() {
        assertTrue(ConfigServerApplication.class.isAnnotationPresent(SpringBootApplication.class));
        assertTrue(ConfigServerApplication.class.isAnnotationPresent(EnableConfigServer.class));
    }
}
