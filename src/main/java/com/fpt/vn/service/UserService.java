package com.fpt.vn.service;


import com.fpt.vn.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    void save(AppUser user);

    Iterable<AppUser> findAll();

    AppUser findByUsername(String username);

    AppUser getCurrentUser();

    Optional<AppUser> findById(Long id);

    UserDetails loadUserById(Long id);

    boolean checkLogin(AppUser user);

    boolean isRegister(AppUser user);

    AppUser findByEmail(String email);

    boolean isCorrectConfirmPassword(AppUser user);

    void delete(AppUser user);
}
