package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(MemberEntity memberEntity);
    Optional<MemberEntity> findOne(String memberEmail);
    List<MemberEntity> findAll();
}
