package com.example.demo.controller;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.RedisService;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping("/{key}")
    public ResponseEntity<?> save(
            @PathVariable String key,
            @RequestBody Map<String, Object> body) {

        String value = (String) body.get("value");
        Object ttlObject = body.get("ttlSeconds");

        if (value == null || ttlObject == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error",
                            "value and ttlSeconds are required"));
        }

        long ttlSeconds;
        try {
            ttlSeconds = Long.parseLong(ttlObject.toString());
        } catch (NumberFormatException ex) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "ttlSeconds must be a number"));
        }

        if (ttlSeconds <= 0) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "ttlSeconds must be positive"));
        }

        redisService.save(key, value, ttlSeconds);

        return ResponseEntity.ok(Map.of(
                "message", "Saved successfully",
                "key", key
        ));
    }

    @GetMapping("/{key}")
    public ResponseEntity<?> get(@PathVariable String key) {
        String value = redisService.get(key);

        if (value == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Key not found or expired"));
        }

        return ResponseEntity.ok(Map.of(
                "key", key,
                "value", value
        ));
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> delete(@PathVariable String key) {
        if (!redisService.delete(key)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Key not found"));
        }

        return ResponseEntity.ok(Map.of(
                "message", "Deleted successfully",
                "key", key
        ));
    }
}
