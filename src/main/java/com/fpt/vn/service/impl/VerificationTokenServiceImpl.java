package com.fpt.vn.service.impl;


import com.fpt.vn.model.VerificationToken;
import com.fpt.vn.repository.VerificationTokenRepository;
import com.fpt.vn.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    @Override
    public void save(VerificationToken token) {
        verificationTokenRepository.save(token);
    }
}
