package com.pnj.crud.repository.member;

import com.pnj.crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Member findByEmailAndPasswdAndIsDelete(String email, String passwd, String isDelete);


    List<Member> findAllByIsDelete(String isDelete);

    @Override
    Optional<Member> findById(Long mno);

//    @Modifying
//    @Query(value = " update Member set uname = :uname, mobile = :mobile where mno = :mno ")
//    void updateInfo(
//            @Param("mno") Long mno,
//            @Param("uname") String uname,
//            @Param("mobile") String mobile
//    );
//
    @Modifying
    @Query(value = " update Member set isDelete = 'y' where mno = :mno and passwd = :passwd ")
    void isDelete(
            @Param("mno") Long mno,
            @Param("passwd") String passwd
    );
}
