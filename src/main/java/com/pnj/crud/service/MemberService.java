package com.pnj.crud.service;

import com.pnj.crud.entity.Member;

public interface MemberService {
    Member signup(Member member);

    boolean memberLogin(String email, String passwd);
}
