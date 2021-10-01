package com.example.securityjwt.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginCommand {
    private final String email;
    private final String password;
}
