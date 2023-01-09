package com.pnj.crud.entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@ToString
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@Builder
@Table(name = "member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mno;
    String email;
    String passwd;
    String uname;
    String mobile;
    String regDate;
    String modifyDate;
    String isDelete;


    @Builder
    public Member(Long mno, String email, String passwd) {
        this.mno = mno;
        this.email = email;
        this.passwd = passwd;
    }
}
