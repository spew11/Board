package eunjilee.boardwithjpa.dto;

import eunjilee.boardwithjpa.entity.CommentEntity;
import eunjilee.boardwithjpa.entity.MemberEntity;
import eunjilee.boardwithjpa.entity.NoticeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentDTO {
    private Long commentId;
    private NoticeEntity notice;
    private String content;
    private MemberEntity memberEntity;

    public CommentDTO entityToDTO(CommentEntity commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(commentEntity.getCommentId());
        commentDTO.setNotice(commentEntity.getNoticeEntity());
        commentDTO.setContent(commentEntity.getContent());
        commentDTO.setMemberEntity(commentEntity.getMemberEntity());
        return commentDTO;
    }
}
