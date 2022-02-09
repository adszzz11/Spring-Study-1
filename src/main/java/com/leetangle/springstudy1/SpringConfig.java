package com.leetangle.springstudy1;

import com.leetangle.springstudy1.aop.TimeTraceAop;
import com.leetangle.springstudy1.repository.*;
import com.leetangle.springstudy1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//    }


    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

}
