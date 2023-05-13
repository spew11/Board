package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.NoticeEntity;
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
public class JpaNoticeRepository implements NoticeRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Transactional
    @Override
    public void save(NoticeEntity noticeEntity) {
        entityManager.persist(noticeEntity);
    }
    @Override
    public Optional<NoticeEntity> findOne(Long id) {
        NoticeEntity noticeEntity = entityManager.find(NoticeEntity.class, id);
        return Optional.ofNullable(noticeEntity);
    }
    @Override
    public List<NoticeEntity> findAll() {
        List<NoticeEntity> selected = entityManager.createQuery("select n from notice_table n", NoticeEntity.class).getResultList();
        return selected;
    }
    @Override
    public void remove(NoticeEntity noticeEntity){
        entityManager.remove(noticeEntity);
    }
}
