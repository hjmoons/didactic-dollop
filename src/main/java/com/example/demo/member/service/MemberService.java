package com.example.demo.member.service;

import com.example.demo.member.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> getAllUsers() {
        return memberMapper.findAll();
    }
}
