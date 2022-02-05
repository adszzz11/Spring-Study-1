package com.leetangle.springstudy1;

import com.leetangle.springstudy1.repository.MemberRepository;
import com.leetangle.springstudy1.repository.MemoryMemberRepository;
import com.leetangle.springstudy1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
