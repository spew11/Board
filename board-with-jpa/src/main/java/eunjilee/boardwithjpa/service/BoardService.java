package eunjilee.boardwithjpa.service;

import eunjilee.boardwithjpa.dto.BoardDTO;
import eunjilee.boardwithjpa.entity.Board;
import eunjilee.boardwithjpa.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final JpaBoardRepository jpaBoardRepository;

    public Board findOne(Long id) {
        Optional<Board> SelectedOne = jpaBoardRepository.findByArticleNo(id);
        if (SelectedOne.isPresent()) {
            return SelectedOne.get();
        }
        else {
            return null;
        }
    }

    public Board saveArticle(Board board) {
        jpaBoardRepository.save(board);
        return board;
    }

    public List<BoardDTO> getAllArticles() {
        List<Board> boards = jpaBoardRepository.findAll();
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (Board board : boards) {
            boardDTOS.add(BoardDTO.EntityToDTO(board));
        }
        return boardDTOS;
    }
}
