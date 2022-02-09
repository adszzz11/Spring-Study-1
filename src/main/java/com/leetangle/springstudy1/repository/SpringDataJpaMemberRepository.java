package com.leetangle.springstudy1.repository;

import com.leetangle.springstudy1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);

    @Override
    Optional<Member> findById(Long aLong);

    @Override
    List<Member> findAll();
}
