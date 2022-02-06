package com.leetangle.springstudy1.controller;

import com.leetangle.springstudy1.domain.Member;
import com.leetangle.springstudy1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member= new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }
}
