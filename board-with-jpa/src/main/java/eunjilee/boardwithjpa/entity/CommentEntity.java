package eunjilee.boardwithjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Entity(name="comment_table")
@Getter
@Setter
@NoArgsConstructor
@Table(name="comment_table", schema = "board")
public class CommentEntity extends BaseTimeEntity {
    @Id @GeneratedValue
    private Long id;
    @JoinColumn(name="notice_id", nullable = false)
    private NoticeEntity notice;
    @Column(nullable = false) @Lob
    private String content;
    @JoinColumn(name="writer", nullable = false)
    private MemberEntity memberEntity;
}
