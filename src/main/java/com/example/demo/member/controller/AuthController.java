package com.example.demo.member.controller;

import com.example.demo.member.domain.dto.LoginRequest;
import com.example.demo.member.domain.dto.RegisterRequest;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        memberService.register(request);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = memberService.login(request);
        return ResponseEntity.ok(Map.of("token", token));
    }
}