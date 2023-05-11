package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.Member;
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
    private final EntityManager em;
    @Transactional
    @Override
    public Member save(Member member) {
        em.persist(member);
        return null;
    }

    @Override
    public Optional<Member> findByEmail(String memberEmail) {
        Member member = em.find(Member.class, memberEmail);
        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from member_table m", Member.class).getResultList();
    }
}
