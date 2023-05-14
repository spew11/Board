package eunjilee.boardwithjpa.entity;

import eunjilee.boardwithjpa.dto.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Entity(name="comment_table")
@Getter
@NoArgsConstructor
@Table(name="comment_table", schema = "board")
@Setter
public class CommentEntity extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name="comment_id")
    private Long commentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="notice_id", nullable = false)
    private NoticeEntity noticeEntity;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer", nullable = false, referencedColumnName = "nick_name")
    private MemberEntity memberEntity;
    public void constructComment(CommentDTO commentDTO, MemberEntity memberEntity, NoticeEntity noticeEntity) {
        this.noticeEntity = noticeEntity;
        this.content = commentDTO.getContent();
        this.memberEntity = memberEntity;
    }
}
