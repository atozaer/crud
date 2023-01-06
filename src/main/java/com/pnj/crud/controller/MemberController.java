package com.pnj.crud.controller;

import com.pnj.crud.entity.Member;
import com.pnj.crud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String getSignUp() {

        return "views/member/signup";
    }

    @PostMapping("/signup")
    public String postSignUp(Member member) {
        String resultPage = "views/index";
        System.out.println(member);
        memberService.signup(member);

        return resultPage;
    }

    @PostMapping("/signin")
    public String postLogin(String email, String passwd) {
        String returnPage = "views/index";

        if (memberService.memberLogin(email,passwd)) {
            returnPage = "views/member/info";
        }

        return returnPage;
    }

}
