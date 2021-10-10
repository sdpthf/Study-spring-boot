package com.example.mailsender.service;

import com.example.mailsender.entity.Member;
import com.example.mailsender.entity.MemberRepository;
import com.example.mailsender.payload.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public void verifyAccount(String token) {

    }

    @Override
    public void signup(SignupRequest request) {
        memberRepository.save(Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
    }

}