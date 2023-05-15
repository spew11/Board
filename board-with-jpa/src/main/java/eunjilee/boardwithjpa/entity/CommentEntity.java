package eunjilee.boardwithjpa.entity;

import eunjilee.boardwithjpa.dto.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Entity(name="comment_table")
@SequenceGenerator(
        name="COMMENT_SEQ_GENERATOR",
        sequenceName = "COMMENT_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
@NoArgsConstructor
@Table(name="comment_table", schema = "board")
@Setter
public class CommentEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ_GENERATOR")
    private Long commentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="notice_id", nullable = false)
    private NoticeEntity noticeEntity;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer", nullable = false, referencedColumnName = "nick_name")
    private MemberEntity memberEntity;
    public CommentEntity(NoticeEntity noticeEntity, String content, MemberEntity memberEntity) {
        this.noticeEntity = noticeEntity;
        this.content = content;
        this.memberEntity = memberEntity;
    }
    public void constructComment(CommentDTO commentDTO, MemberEntity memberEntity, NoticeEntity noticeEntity) {
        this.noticeEntity = noticeEntity;
        this.content = commentDTO.getContent();
        this.memberEntity = memberEntity;
    }
}
