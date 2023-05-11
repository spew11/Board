package eunjilee.boardwithjpa.entity;

import eunjilee.boardwithjpa.dto.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
@ToString
@Entity(name="board_table")
@NoArgsConstructor
@Table(name="board_table", schema="board")
@Getter
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Timestamp regDate;
    @UpdateTimestamp
    private Timestamp modDate;

    public void toUpdateBoardEntity(BoardDTO boardDTO, Member member) {
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.member = member;
    }
}
