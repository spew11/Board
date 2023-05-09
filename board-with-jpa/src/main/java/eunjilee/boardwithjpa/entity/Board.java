package eunjilee.boardwithjpa.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

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
    @JoinColumn()
    private String writerId;
    @Column @CreationTimestamp
    private Date regDate;
    @Column @CreationTimestamp
    private Date modDate;

}
