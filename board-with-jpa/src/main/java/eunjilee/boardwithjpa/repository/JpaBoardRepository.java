package eunjilee.boardwithjpa.repository;

import eunjilee.boardwithjpa.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class JpaBoardRepository implements BoardRepository{
    @PersistenceContext
    private final EntityManager entityManager;
    @Transactional
    @Override
    public Board save(Board board) {
        entityManager.persist(board);
        return null;
    }

    @Override
    public List<Board> findAll() {
        return entityManager.createQuery("select b from board_table b", Board.class).getResultList();
    }
}
