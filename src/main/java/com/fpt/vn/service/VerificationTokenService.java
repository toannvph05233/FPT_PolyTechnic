package com.fpt.vn.service;


import com.fpt.vn.model.VerificationToken;

public interface
VerificationTokenService {
    VerificationToken findByToken(String token);

    void save(VerificationToken token);
}
