package com.pnj.crud.repository;

import com.pnj.crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean findByEmailAndPasswd(String email, String passwd);
}
