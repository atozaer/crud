package com.pnj.crud.dto.member;

import com.pnj.crud.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class JoinDto {
    private String email;
    private String passwd;

    private String uname;

    private String mobile;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .passwd(passwd)
                .uname(uname)
                .mobile(mobile)
                .build();

    }

}
