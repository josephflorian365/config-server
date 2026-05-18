package com.nttdata.configserver.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HealthControllerTest {

    private final HealthController controller = new HealthController();

    @Test
    void welcomeShouldReturnExpectedPayload() {
        ResponseEntity<Map<String, Object>> response = controller.welcome();

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("Config Server", response.getBody().get("service"));
        assertEquals("UP", response.getBody().get("status"));
        assertEquals(8888, response.getBody().get("port"));
        assertTrue(response.getBody().containsKey("timestamp"));
    }

    @Test
    void healthShouldReturnServiceStatus() {
        ResponseEntity<Map<String, Object>> response = controller.health();

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("UP", response.getBody().get("status"));
        assertEquals("Config Server", response.getBody().get("service"));
        assertTrue(response.getBody().containsKey("timestamp"));
    }

    @Test
    void infoShouldDescribeManagedServices() {
        ResponseEntity<Map<String, Object>> response = controller.info();

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("Config Server", response.getBody().get("service"));
        assertEquals("native", response.getBody().get("activeProfiles"));
        assertEquals("classpath:/config", response.getBody().get("configLocation"));
        assertTrue(response.getBody().containsKey("managedServices"));
    }
}
