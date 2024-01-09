package project.SpringBoot_JDBC.repository;

import project.SpringBoot_JDBC.entity.Board;

import java.util.List;

//@Repository
//public interface BoardRepository extends JpaRepository<Board, Long> {
//}

public interface BoardInterface {
    void save(Board board);
    void update(Board board);
    void deleteBoardById(Long boardId);
    Board findBoardById(Long boardId);
    List<Board> findAllBoard();

}
