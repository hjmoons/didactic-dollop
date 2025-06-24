package com.example.demo.member.service;

import com.example.demo.member.domain.dto.LoginRequest;
import com.example.demo.member.domain.dto.MemberCreateRequest;
import com.example.demo.member.domain.dto.MemberUpdateRequest;
import com.example.demo.member.domain.dto.RegisterRequest;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MemberRepository memberRepository;

    public Member register(RegisterRequest request) {
        if (memberRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("이미 존재하는 사용자입니다.");
        }
        Member member = Member.builder()
                .name(request.getUsername())
                .email(passwordEncoder.encode(request.getPassword()))
                .build();
        return memberRepository.save(member);
    }

    public String login(LoginRequest request) {
        Member member = memberRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("사용자 없음"));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new RuntimeException("비밀번호 불일치");
        }

        return jwtUtil.generateToken(member.getUsername());
    }

    public Optional<Member> getMember(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> getMemberList() {
        return memberRepository.findAll();
    }

    public Member updateMember(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        member.setName(request.getName());
        member.setEmail(request.getEmail());

        return memberRepository.save(member);
    }
}