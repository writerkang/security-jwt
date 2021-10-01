package com.example.securityjwt.domain.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void findByEmail_success() {
        var newMember = new Member(1L, "aaa@aaa.com", "1234");
        memberRepository.save(newMember);

        var found = memberRepository.findByEmail("aaa@aaa.com")
            .orElseThrow();

        Assertions.assertEquals(newMember, found);
    }

}
