package com.pnj.crud.service;

import com.pnj.crud.entity.Member;

import java.util.List;

public interface MemberService {
    Member signup(Member member);

    Member memberLogin(long isLogin);

    Long isLogin(String email, String passwd);

    List<Member> findAllUser();
}
