package eunjilee.boardwithjpa.dto;

import eunjilee.boardwithjpa.entity.Board;
import eunjilee.boardwithjpa.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {
    private Long articleNo;
    private String title;
    private String content;
    private Member member;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public static BoardDTO EntityToDTO(Board board) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setMember(board.getMember());
        boardDTO.setTitle(board.getTitle());
        boardDTO.setContent(board.getContent());
        boardDTO.setArticleNo(board.getArticleNo());
        boardDTO.setRegDate(board.getRegDate());
        boardDTO.setModDate(board.getModDate());
        return boardDTO;
    }
}
