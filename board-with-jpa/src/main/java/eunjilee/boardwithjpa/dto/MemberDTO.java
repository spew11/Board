package eunjilee.boardwithjpa.dto;

import eunjilee.boardwithjpa.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {
    private String email;
    private String nickName;
    private String password;

    public static MemberDTO DtoToEntity(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail(memberEntity.getEmail());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setNickName(memberEntity.getNickName());
        return memberDTO;
    }
}
