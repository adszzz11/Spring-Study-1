package com.leetangle.springstudy1;

import com.leetangle.springstudy1.repository.JdbcMemberRepository;
import com.leetangle.springstudy1.repository.JdbcTemplateMemberRepository;
import com.leetangle.springstudy1.repository.MemberRepository;
import com.leetangle.springstudy1.repository.MemoryMemberRepository;
import com.leetangle.springstudy1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
