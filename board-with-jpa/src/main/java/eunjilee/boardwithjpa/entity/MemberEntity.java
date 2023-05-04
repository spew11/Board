package eunjilee.boardwithjpa.entity;

import javax.persistence.*;

@All
@Entity
@Table(name="member_table")
public class MemberEntity {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private string email;
    @Column
    private string name;
    @Column
    private string password;
}
