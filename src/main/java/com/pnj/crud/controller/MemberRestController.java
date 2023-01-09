package com.pnj.crud.controller;

import com.pnj.crud.entity.Member;
import com.pnj.crud.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/member")
public class MemberRestController {
    private final MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/mlist")
    public List<Member> getMemberList() {

        return memberService.findMemberList();
    }

    @GetMapping("/dlist")
    public List<Member> getDeleteList() {

        return memberService.findDeleteList();
    }
}
