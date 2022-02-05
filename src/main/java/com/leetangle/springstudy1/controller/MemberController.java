package com.leetangle.springstudy1.controller;

import com.leetangle.springstudy1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
//    필드 주입
//    한번 생성 후 바꿀 방법이 없다.
//    @Autowired private MemberService memberService;

//    생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    Setter 주입
//    SetterInjection 방식
//    누군가가 MemberController로 접근했을 때, public으로 열려 있어야 함.
//    @Autowired
//    public MemberService setMemberService() {
//        return memberService;
//    }
}
