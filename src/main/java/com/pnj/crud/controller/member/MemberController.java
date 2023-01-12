package com.pnj.crud.controller.member;

import com.pnj.crud.dto.member.LoginDto;
import com.pnj.crud.entity.Member;
import com.pnj.crud.service.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String getSignUp(HttpSession session) {
        String returnPage = "views/member/signup";

        if (session.getAttribute("member") != null) {

            returnPage = "views/member/info";
        }

        return returnPage;
    }

    @PostMapping("/signup")
    public String postSignUp(Member member) {
        memberService.signup(member);

        return "views/index";
    }

    @PostMapping("/login")
    public String postLogin(LoginDto loginMember, HttpSession session) {
        String returnPage = "views/index";

        System.out.println(loginMember);

        Member member = memberService.memberLogin(loginMember.getEmail(), loginMember.getPasswd());
        if (member != null) {
            session.setAttribute("member", member);
            returnPage = "redirect:/";
        } else {
            System.out.println("로그인실패");
        }

        return returnPage;
    }

    @GetMapping("/info")
    public String getInfo(HttpSession session) {
        String returnPage = "views/index";

        if (session.getAttribute("member") != null) {
            Member member = (Member) session.getAttribute("member");

            returnPage = "views/member/info";
        } else {
            returnPage = "views/member/signup";
        }

        return returnPage;
    }

    @GetMapping("/modify")
    public String getModify(HttpSession session, Model model) {

        Member member = (Member) session.getAttribute("member");

        model.addAttribute("member", member);

        return "views/member/modify";
    }

    @PostMapping("/modify")
    public String postModify(HttpSession session, Member member, Model model) {

        System.out.println("controller : " + member);

        memberService.update(member);

        Member modifyMember = memberService.findById(member.getMno()).get();

        model.addAttribute("member", modifyMember);

        session.setAttribute("member", modifyMember);

        return "views/member/info";
    }

    @GetMapping("/mlist")
    public String getMlist() {

        return "views/member/mlist";
    }

    @GetMapping("/deletelist")
    public String getDlist() {

        return "views/member/deletelist";
    }

    @GetMapping("/delete")
    public String getDelete(HttpSession session, Model model) {

        Member member = (Member) session.getAttribute("member");

        model.addAttribute("member", member);

        return "views/member/delete";
    }

    @PostMapping("/delete")
    public String postDelete(HttpSession session, Long mno, String passwd) {

        memberService.delete(mno, passwd);

        session.invalidate();
        return "views/index";
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }


}
