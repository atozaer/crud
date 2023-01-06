package com.pnj.crud.service;

import com.pnj.crud.entity.Member;

public interface MemberService {
    Member signup(Member member);

    Member memberLogin(long isLogin);

    Long isLogin(String email, String passwd);
}
