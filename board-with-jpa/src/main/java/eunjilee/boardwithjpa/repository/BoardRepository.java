package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.Board;
import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);

    Optional<Board> findByArticleNo(Long articleNo);
    List<Board> findAll();
}
