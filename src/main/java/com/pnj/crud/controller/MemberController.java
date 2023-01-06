package com.pnj.crud.controller;

import com.pnj.crud.dto.JoinDto;
import com.pnj.crud.dto.LoginDto;
import com.pnj.crud.entity.Member;
import com.pnj.crud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpSession;

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
    public String postLogin(LoginDto loginMember, HttpSession session) {
        String returnPage = "views/index";

        System.out.println(loginMember);

        long isLogin = memberService.isLogin(loginMember.getEmail(), loginMember.getPasswd());
        System.out.println("mno : " + isLogin);

        if (isLogin > 0) {
            Member member = memberService.memberLogin(isLogin);
            session.setAttribute("member", member);
            returnPage = "views/member/info";
        } else {
            System.out.println("로그인실패");
        }

        return returnPage;
    }

    @GetMapping("/info")
    public ModelAndView getInfo(HttpSession session) {
        ModelAndView mv = null;

        if (session != null) {
            mv.setViewName("views/member/info");
            Member member = (Member) session.getAttribute("member");

            System.out.println(member);
            mv.addObject("member", member);

        } else {
            mv.setViewName("views/index");
        }

        return mv;
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }
}
