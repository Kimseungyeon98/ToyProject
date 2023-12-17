package project.myProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.myProject.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
