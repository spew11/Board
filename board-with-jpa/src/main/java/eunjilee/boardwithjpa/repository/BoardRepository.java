package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.Board;
import java.util.List;
public interface BoardRepository {
    Board save(Board board);
    List<Board> findAll();
}
