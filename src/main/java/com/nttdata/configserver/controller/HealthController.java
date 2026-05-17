package com.nttdata.configserver.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Health and Status Controller for Config Server.
 * Provides endpoints for monitoring and health checks.
 */
@RestController
@Slf4j
@Tag(name = "Config Server Health", description = "Health and status endpoints")
public class HealthController {

    /**
     * Welcome endpoint for Config Server.
     * Returns basic information about the service.
     *
     * @return ResponseEntity with welcome message
     */
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> welcome() {
        log.debug("Config Server root endpoint accessed");

        Map<String, Object> response = new HashMap<>();
        response.put("service", "Config Server");
        response.put("version", "1.0.0");
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now());
        response.put("message", "Banking System Configuration Server is running");
        response.put("port", 8888);
        response.put("config-endpoint", "/config");

        return ResponseEntity.ok(response);
    }

    /**
     * Health check endpoint.
     * Returns health status in detail.
     *
     * @return ResponseEntity with health information
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        log.debug("Health check endpoint accessed");

        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "Config Server");
        response.put("timestamp", LocalDateTime.now());
        response.put("uptime", "Running");

        return ResponseEntity.ok(response);
    }

    /**
     * Info endpoint.
     * Returns information about available configuration sources.
     *
     * @return ResponseEntity with configuration information
     */
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        log.debug("Info endpoint accessed");

        Map<String, Object> response = new HashMap<>();
        response.put("service", "Config Server");
        response.put("version", "1.0.0");
        response.put("activeProfiles", "native");
        response.put("configLocation", "classpath:/config");
        response.put("managedServices", new String[]{
            "client-service",
            "product-service",
            "eureka-server"
        });
        response.put("timestamp", LocalDateTime.now());

        return ResponseEntity.ok(response);
    }
}

