package com.pnj.crud.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long mno;
    String email;
    String passwd;
    String uname;
    String mobile;
    String regDate;
    String modifyDate;
}
