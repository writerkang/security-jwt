package com.example.securityjwt.controller;

import com.example.securityjwt.command.LoginCommand;
import com.example.securityjwt.domain.member.MemberRepository;
import com.example.securityjwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class LoginController {

    private final JwtUtil jwtUtil;
    private final MemberRepository memberRepository;

    @PostMapping("/login")
    public ResponseEntity login(LoginCommand loginCommand) {
        if (loginCommand.getEmail() == null) {

            return ResponseEntity.badRequest().build();
        }

        var member = memberRepository.findByEmail(loginCommand.getEmail())
            .orElseGet(null);

        if (member == null || !member.getPassword().equals(loginCommand.getPassword())) {

            return ResponseEntity.badRequest().build();
        }

        var jws = jwtUtil.createJws(loginCommand.getEmail());

        return ResponseEntity.ok(jws);
    }
}
