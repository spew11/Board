package eunjilee.boardwithjpa.service;

import eunjilee.boardwithjpa.entity.Board;
import eunjilee.boardwithjpa.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final JpaBoardRepository jpaBoardRepository;

    public Board saveArticle(Board board) {
        jpaBoardRepository.save(board);
        return board;
    }

    public List<Board> getAllArticles() {
        return jpaBoardRepository.findAll();
    }
}
