package com.example.securityjwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class InfoController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok("OK");
    }
}
