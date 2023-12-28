package project.myProject.repository;

import project.myProject.entity.Board;

import java.util.List;
import java.util.Optional;


//public interface BoardRepository extends JpaRepository<Board, Long> {
//}
public interface BoardRepository {
    void save(Board board);
    void update(Board board);
    void deleteById(Long boardId);
    Board findById(Long boardId);
    List<Board> findAll();

}
