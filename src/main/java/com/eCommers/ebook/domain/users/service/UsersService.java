package com.eCommers.ebook.domain.users.service;

import com.eCommers.ebook.domain.users.UsersForm;
import com.eCommers.ebook.domain.users.entity.Users;
import com.eCommers.ebook.domain.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UsersForm usersForm){
        Users users = Users.builder()
                .username(usersForm.getUsername())
                .nickname(usersForm.getNickname())
                .password(passwordEncoder.encode(usersForm.getPassword1()))
                .email(usersForm.getEmail())
                .role("buyer")
                .isSeller(false)
                .build();

        this.usersRepository.save(users);
    }
}
