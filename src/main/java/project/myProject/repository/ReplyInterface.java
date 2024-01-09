package project.myProject.repository;

import project.myProject.entity.Reply;

//@Repository
//public interface ReplyRepository extends JpaRepository<Reply, Long> {
//}


public interface ReplyInterface {
    void save(Reply reply);
    void deleteReplyById(Long replyId);
    Reply findReplyById(Long replyId);

}