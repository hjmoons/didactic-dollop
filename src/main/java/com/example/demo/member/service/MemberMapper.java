package com.example.demo.member.service;

import com.example.demo.member.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> findAll();
}
