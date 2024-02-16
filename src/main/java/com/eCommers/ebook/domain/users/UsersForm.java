package com.eCommers.ebook.domain.users;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersForm {
    @NotEmpty(message = "please write your username")
    private String username;

    @NotEmpty(message = "please write your nickname")
    private String nickname;

    @NotEmpty(message = "please write your email")
    private String email;

    @NotEmpty(message = "please write your password")
    private String password1;

    @NotEmpty(message = "please write your passwordConfirm")
    private String password2;

}
