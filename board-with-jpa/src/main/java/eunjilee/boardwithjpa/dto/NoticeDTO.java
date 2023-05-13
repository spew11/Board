package eunjilee.boardwithjpa.dto;

import eunjilee.boardwithjpa.entity.MemberEntity;
import eunjilee.boardwithjpa.entity.NoticeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoticeDTO {
    private Long id;
    private String title;
    private String content;
    private MemberEntity memberEntity;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public static NoticeDTO EntityToDTO(NoticeEntity noticeEntity) {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setMemberEntity(noticeEntity.getMemberEntity());
        noticeDTO.setTitle(noticeEntity.getTitle());
        noticeDTO.setContent(noticeEntity.getContent());
        noticeDTO.setId(noticeEntity.getId());
        noticeDTO.setRegDate(noticeEntity.getRegDate());
        noticeDTO.setModDate(noticeEntity.getModDate());
        return noticeDTO;
    }
}
