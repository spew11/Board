package eunjilee.boardwithjpa.dto;

import eunjilee.boardwithjpa.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {
    private String memberEmail;
    private String memberNickName;
    private String memberPassword;

    public static MemberDTO DtoToEntity(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail(member.getMemberEmail());
        memberDTO.setMemberPassword(member.getMemberPassword());
        memberDTO.setMemberNickName(member.getMemberNickName());
        return memberDTO;
    }
}
