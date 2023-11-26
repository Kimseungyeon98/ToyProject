package project.myProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.myProject.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
