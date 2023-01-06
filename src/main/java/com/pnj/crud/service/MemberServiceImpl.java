package com.pnj.crud.service;

import com.pnj.crud.entity.Member;
import com.pnj.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

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
    public Long isLogin(String email, String passwd) {

        return memberRepository.findByEmailAndPasswd(email, passwd).getMno();
    }

    @Override
    public Member memberLogin(long isLogin) {

        return memberRepository.findById(isLogin).get();
    }

}
