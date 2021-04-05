package com.fpt.vn.controllers;

import com.fpt.vn.model.AppUser;
import com.fpt.vn.model.JwtResponse;
import com.fpt.vn.model.UserPrinciple;
import com.fpt.vn.service.RoleService;
import com.fpt.vn.service.UserService;
import com.fpt.vn.service.VerificationTokenService;
import com.fpt.vn.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class UserController {
//    @Autowired
//    private Environment env;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private VerificationTokenService verificationTokenService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;




    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserPrinciple user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

}
