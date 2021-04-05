package com.fpt.vn.service.impl;


import com.fpt.vn.model.AppUser;
import com.fpt.vn.model.UserPrinciple;
import com.fpt.vn.repository.UserRepository;
import com.fpt.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        AppUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        if (this.checkLogin(user)) {
            return UserPrinciple.build(user);
        }
        boolean enable = false;
        boolean accountNonExpired = false;
        boolean credentialsNonExpired = false;
        boolean accountNonLocked = false;
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), enable, accountNonExpired, credentialsNonExpired,
                accountNonLocked, null);
    }


    @Override
    public void save(AppUser user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser getCurrentUser() {
        AppUser user;
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        user = this.findByUsername(userName);
        return user;
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserById(Long id) {
        Optional<AppUser> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new NullPointerException();
        }
        return UserPrinciple.build(user.get());
    }

    @Override
    public boolean checkLogin(AppUser user) {
        Iterable<AppUser> users = this.findAll();
        boolean isCorrectUser = false;
        for (AppUser currentUser : users) {
            if (currentUser.getUsername().equals(user.getUsername())
                    && user.getPassword().equals(currentUser.getPassword())) {
                isCorrectUser = true;
            }
        }
        return isCorrectUser;
    }

    @Override
    public boolean isRegister(AppUser user) {
        boolean isRegister = false;
        Iterable<AppUser> users = this.findAll();
        for (AppUser currentUser : users) {
            if (user.getUsername().equals(currentUser.getUsername())) {
                isRegister = true;
                break;
            }
        }
        return isRegister;
    }

    @Override
    public AppUser findByEmail(String email) {
        return null;
    }

    @Override
    public boolean isCorrectConfirmPassword(AppUser user) {
//        boolean isCorrentConfirmPassword = false;
//        if(user.getPassword().equals(user.getConfirmPassword())){
//            isCorrentConfirmPassword = true;
//        }
        return true;
    }

    @Override
    public void delete(AppUser user) {
        userRepository.delete(user);
    }
}
