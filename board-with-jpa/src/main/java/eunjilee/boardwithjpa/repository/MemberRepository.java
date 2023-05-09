package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByEmail(String memberEmail);
    List<Member> findAll();
}
