package eunjilee.boardwithjpa.service;

import eunjilee.boardwithjpa.dto.CommentDTO;
import eunjilee.boardwithjpa.entity.CommentEntity;
import eunjilee.boardwithjpa.entity.MemberEntity;
import eunjilee.boardwithjpa.entity.NoticeEntity;
import eunjilee.boardwithjpa.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final NoticeService noticeService;
    private final MemberService memberService;
    public CommentEntity findById(Long id) {
        return commentRepository.findOne(id).orElse(null);
    }
    public void saveComment(String uid, Long noticeId, CommentDTO commentDTO) {
//        CommentEntity commentEntity = new CommentEntity();
        MemberEntity memberEntity = memberService.findOneByEmail(uid);
        NoticeEntity noticeEntity = noticeService.findOne(noticeId);
//        commentEntity.constructComment(commentDTO, memberEntity, noticeEntity);
        CommentEntity commentEntity = new CommentEntity(noticeEntity, commentDTO.getContent(), memberEntity);
        commentRepository.save(commentEntity);
    }
    public List<CommentEntity> findComments(Long noticeId) {
        return commentRepository.findNotices(noticeId);
    }
    public void removeComment(Long id) {
        commentRepository.remove(findById((id)));
    }
}
