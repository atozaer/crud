package com.pnj.crud.repository;

import com.pnj.crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmailAndPasswd(String email, String passwd);

    @Override
    Optional<Member> findById(Long mno);
}
