package com.pnj.crud.repository;

import com.pnj.crud.entity.Member;
import com.pnj.crud.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Primary
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    private final QMember qMember;

    public MemberRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
        qMember = QMember.member;
    }

    @Transactional
    public long update(Member member) {
        long result = queryFactory.update(qMember)
                .set(qMember.uname, member.getUname())
                .set(qMember.mobile, member.getMobile())
                .where(qMember.mno.eq(member.getMno()))
                .execute();

        System.out.println("update repo : " + result);

        return result;
    }


//    private final JPAQueryFactory queryFactory;

}
