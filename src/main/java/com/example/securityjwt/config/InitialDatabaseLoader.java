package com.example.securityjwt.config;

import com.example.securityjwt.domain.member.Member;
import com.example.securityjwt.domain.member.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDatabaseLoader {

    @Bean
    CommandLineRunner initialize(MemberRepository memberRepository) {
        return args -> {
            memberRepository.save(new Member(1L, "aaa@aaa.com", "1234"));
        };
    }
}
