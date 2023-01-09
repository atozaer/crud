package com.pnj.crud.service;

import com.pnj.crud.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member signup(Member member);

    Member memberLogin(String email, String passwd);


    List<Member> findMemberList();

    List<Member> findDeleteList();

    Member update(Member member);

    Optional<Member> findById(Long mno);


    void delete(Long mno, String passwd);
}
