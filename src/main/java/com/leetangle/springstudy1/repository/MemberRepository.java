package com.leetangle.springstudy1.repository;

import com.leetangle.springstudy1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member Member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
