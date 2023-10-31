package com.kevinliu.springboogmallpractice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRegisterRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
