package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.CommentEntity;
import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Optional<CommentEntity> findOne(Long id);
    void save(CommentEntity commentEntity);
    List<CommentEntity> findNotices(Long noticeId);
    void remove(CommentEntity commentEntity);
}
