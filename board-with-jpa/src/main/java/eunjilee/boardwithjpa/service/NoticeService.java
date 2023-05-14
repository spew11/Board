package eunjilee.boardwithjpa.service;

import eunjilee.boardwithjpa.dto.NoticeDTO;
import eunjilee.boardwithjpa.entity.NoticeEntity;
import eunjilee.boardwithjpa.entity.MemberEntity;
import eunjilee.boardwithjpa.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {
    private final JpaNoticeRepository jpaNoticeRepository;
    private final MemberService memberService;
    public NoticeEntity findOne(Long id) {
        return jpaNoticeRepository.findOne(id).orElse(null);
    }
    public void saveNotice(String uid, NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = new NoticeEntity();
        MemberEntity memberEntity = memberService.findOneByEmail(uid);
        noticeEntity.constructNotice(noticeDTO, memberEntity);
        jpaNoticeRepository.save(noticeEntity);
    }
    public List<NoticeEntity> findAllNotice() {
        return jpaNoticeRepository.findAll();
    }
    public NoticeEntity updateNotice(Long id, NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = findOne(id);
        noticeEntity.toUpdateNotice(noticeDTO);
        jpaNoticeRepository.save(noticeEntity);
        return noticeEntity;
    }
    public void removeById(Long id) {
        NoticeEntity noticeEntity = findOne(id);
        jpaNoticeRepository.remove(noticeEntity);
    }
}
