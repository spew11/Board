package eunjilee.boardwithjpa.service;

import eunjilee.boardwithjpa.entity.CommentEntity;
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
    public CommentEntity findById(Long id) {
        return commentRepository.findOne(id).orElse(null);
    }
    public void saveComment(CommentEntity commentEntity) {
        commentRepository.save(commentEntity);
    }
    public List<CommentEntity> findComments(Long noticeId) {
        return commentRepository.findNotices(noticeId);
    }
    public void removeComment(Long id) {
        commentRepository.remove(findById((id)));
    }
}
