package project.SpringBoot_JDBC.repository;

import project.SpringBoot_JDBC.entity.Reply;

//@Repository
//public interface ReplyRepository extends JpaRepository<Reply, Long> {
//}


public interface ReplyInterface {
    void save(Reply reply);
    void deleteReplyById(Long replyId);
    Reply findReplyById(Long replyId);

}