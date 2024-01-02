package project.myProject.repository;

import org.springframework.stereotype.Repository;
import project.myProject.entity.Reply;

import java.util.List;

//@Repository
//public interface ReplyRepository extends JpaRepository<Reply, Long> {
//}


public interface ReplyInterface {
    void save(Reply reply);
    void deleteById(Long replyId);
    Reply findById(Long replyId);

}