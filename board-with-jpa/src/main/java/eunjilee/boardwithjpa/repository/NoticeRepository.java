package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.NoticeEntity;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository {
    void save(NoticeEntity noticeEntity);
    Optional<NoticeEntity> findOne(Long id);
    List<NoticeEntity> findAll();
    void remove(NoticeEntity noticeEntity);
}
