package eunjilee.boardwithjpa.entity;

import eunjilee.boardwithjpa.dto.NoticeDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Entity(name="notice_table")
@NoArgsConstructor
@Table(name="notice_table", schema="board")
@Getter
public class NoticeEntity extends BaseTimeEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false) @Lob
    private String content;
    @ManyToOne
    @JoinColumn(name="writer", referencedColumnName = "nick_name")
    private MemberEntity memberEntity;

    public void constructBoard(NoticeDTO noticeDTO, MemberEntity memberEntity) {
        this.title = noticeDTO.getTitle();
        this.content = noticeDTO.getContent();
        this.memberEntity = memberEntity;
    }

    public void toUpdateArticle(NoticeDTO noticeDTO) {
        this.title = noticeDTO.getTitle();
        this.content = noticeDTO.getContent();
    }
}
