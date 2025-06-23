package com.example.demo.member.service;

import com.example.demo.member.domain.dto.MemberCreateRequest;
import com.example.demo.member.domain.dto.MemberUpdateRequest;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(MemberCreateRequest request) {
        Member member = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
        return memberRepository.save(member);
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