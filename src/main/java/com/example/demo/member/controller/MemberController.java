package com.example.demo.member.controller;

import com.example.demo.member.model.Member;
import com.example.demo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getUsers() {
        return memberService.getAllUsers();
    }
}
