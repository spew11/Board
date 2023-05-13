package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository{
    @PersistenceContext
    private final EntityManager entityManager;
    @Transactional
    @Override
    public void save(MemberEntity memberEntity) {
        entityManager.persist(memberEntity);
    }
    @Override
    public Optional<MemberEntity> findOne(String memberEmail) {
        MemberEntity memberEntity = entityManager.find(MemberEntity.class, memberEmail);
        return Optional.ofNullable(memberEntity);
    }
    @Override
    public List<MemberEntity> findAll() {
        List<MemberEntity> memberEntities = entityManager.createQuery("select m from member_table m", MemberEntity.class).getResultList();
        return memberEntities;
    }
}
