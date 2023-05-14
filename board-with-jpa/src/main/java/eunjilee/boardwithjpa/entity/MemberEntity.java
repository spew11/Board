package eunjilee.boardwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="member_table")
@Getter
@Table(name="member_table", schema="board")
public class MemberEntity implements Serializable{
    @Id
    private String email;
    @Column(nullable = false, unique = true, name="nick_name")
    private String nickName;
    @Column(nullable = false)
    private String password;
}
