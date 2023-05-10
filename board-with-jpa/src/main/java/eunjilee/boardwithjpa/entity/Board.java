package eunjilee.boardwithjpa.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="board_table", schema="board")
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleNo;
    @Column @NotNull
    private String title;
    @Column @NotNull @Lob
    private String content;
    @ManyToOne
    @JoinColumn(name="member_table_member_email")
    private Member member;
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;

}
