package com.eCommers.ebook.domain.users.entity;

import com.eCommers.ebook.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Users extends BaseEntity {

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String nickname;

    @Column
    private String email;

    private String password;

    @Column
    private String role;

    @Column
    private boolean isSeller;
}
