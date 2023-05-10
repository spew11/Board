package eunjilee.boardwithjpa.entity;

import com.sun.istack.NotNull;
import eunjilee.boardwithjpa.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name="member_table", schema="board")
public class Member {
    @Id
    private String memberEmail;
    @Column(nullable = false)
    private String memberName;
    @Column(nullable = false)
    private String memberPassword;
}
