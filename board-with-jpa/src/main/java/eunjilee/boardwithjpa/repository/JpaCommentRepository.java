package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
@RequiredArgsConstructor
public class JpaCommentRepository implements CommentRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public Optional<CommentEntity> findOne(Long id) {
        CommentEntity commentEntity = entityManager.find(CommentEntity.class, id);
        return Optional.ofNullable(commentEntity);
    }
    @Override
    public void save(CommentEntity commentEntity){
        entityManager.persist(commentEntity);
    }
    @Override
    public List<CommentEntity> findNotices(Long noticeId){
        String jpql = "select c from comment_table as c where c.noticeEntity.noticeId = :noticeId";
        List<CommentEntity> commentEntities = entityManager.createQuery(jpql, CommentEntity.class)
                .setParameter("noticeId", noticeId).getResultList();
        return commentEntities;
    }
    @Override
    public void remove(CommentEntity commentEntity){
        entityManager.remove(commentEntity);
    };
}
