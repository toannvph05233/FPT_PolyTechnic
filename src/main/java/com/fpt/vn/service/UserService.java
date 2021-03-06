package com.fpt.vn.service;


import com.fpt.vn.model.AppUser;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    void save(AppUser user);

    Iterable<AppUser> findAll();

    AppUser findByUsername(String username);

    Iterable<AppUser> findAllDoctor();

    AppUser getCurrentUser();

    Optional<AppUser> findById(Long id);

//    long coutFeedback(Long id);

    UserDetails loadUserById(Long id);

    boolean checkLogin(AppUser user);

    boolean isRegister(AppUser user);

    List<AppUser> findAllByLocation(long id);

    boolean isCorrectConfirmPassword(AppUser user);

    void delete(AppUser user);

    List<AppUser> findAllDoctorAndNannyByLocation(long idLocation,long idRole);

}
