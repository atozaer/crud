package com.pnj.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long mno;
    private String email;
    private String passwd;
}
