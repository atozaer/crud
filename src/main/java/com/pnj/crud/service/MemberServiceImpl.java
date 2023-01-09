package com.pnj.crud.service;

import com.pnj.crud.entity.Member;
import com.pnj.crud.repository.MemberRepository;
import com.pnj.crud.repository.MemberRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.annotation.ElementType;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private MemberRepositoryCustom memberRepositoryCustom;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member signup(Member member) {
        return memberRepository.save(member);
    }
    @Override
    public Member memberLogin(String email, String passwd) {

        return memberRepository.findByEmailAndPasswdAndIsDelete(email, passwd, "n");
    }

    @Override
    public List<Member> findMemberList() {

        return memberRepository.findAllByIsDelete("n");
    }

    @Override
    public List<Member> findDeleteList() {

        return memberRepository.findAllByIsDelete("y");
    }


    @Override
    public Member update(Member member) {
        memberRepositoryCustom.update(member);
        return null;
    }

    @Override
    public Optional<Member> findById(Long mno) {
        System.out.println("findById service : "+memberRepository.findById(mno));
        return memberRepository.findById(mno);
    }

    @Override
    @Transactional
    public void delete(Long mno, String passwd) {
        memberRepository.isDelete(mno, passwd);
    }



}
