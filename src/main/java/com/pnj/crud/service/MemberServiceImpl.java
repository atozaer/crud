package com.pnj.crud.service;

import com.pnj.crud.entity.Member;
import com.pnj.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member signup(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public boolean memberLogin(String email, String passwd) {
        boolean result = false;

        memberRepository.findByEmailAndPasswd(email, passwd);

        return result;
    }

}
