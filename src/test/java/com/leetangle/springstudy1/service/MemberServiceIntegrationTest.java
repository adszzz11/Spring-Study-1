package com.leetangle.springstudy1.service;

import com.leetangle.springstudy1.domain.Member;
import com.leetangle.springstudy1.repository.MemberRepository;
import com.leetangle.springstudy1.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

// Spring 컨테이너와 테스트를 함께 실행
@SpringBootTest
// Testcase에 해당 Annotation이 있으면, AutoCommit 비활성화 & 테스트 종료 시 Rollback 실행
// Service에 붙으면 롤백하지 않으며, TestCase에서만 동작
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService ;



    @Test
    void 회원가입() {

        //given
        Member member = new Member();
        member.setName("spring");


        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {

        //given
        Member member1=new Member();
        member1.setName("spring");
        Member member2=new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }

}

