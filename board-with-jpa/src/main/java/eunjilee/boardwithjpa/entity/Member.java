package eunjilee.boardwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="member_table")
@Getter
@Table(name="member_table", schema="board")
public class Member implements Serializable{
    @Id
    private String memberEmail;
    @Column(nullable = false, unique = true, name="member_nick_name")
    private String memberNickName;
    @Column(nullable = false)
    private String memberPassword;
}
