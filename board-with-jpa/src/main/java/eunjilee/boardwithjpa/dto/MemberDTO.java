package eunjilee.boardwithjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {
    private String memberEmail;
    private String memberName;
    private String memberPassword;
}
