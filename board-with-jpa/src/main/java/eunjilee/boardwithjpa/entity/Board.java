package eunjilee.boardwithjpa.entity;

import eunjilee.boardwithjpa.dto.BoardDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Entity(name="board_table")
@NoArgsConstructor
@Table(name="board_table", schema="board")
@Getter
public class Board {
    @Id
    @GeneratedValue
    private Long articleNo;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false) @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name="writer", referencedColumnName = "member_nick_name")
    private Member member;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime regDate;
    @UpdateTimestamp
    private LocalDateTime modDate;

    public void toUpdateBoardEntity(BoardDTO boardDTO, Member member) {
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.member = member;
    }
}
