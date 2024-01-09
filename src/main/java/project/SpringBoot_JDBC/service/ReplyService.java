package project.SpringBoot_JDBC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.SpringBoot_JDBC.entity.Board;
import project.SpringBoot_JDBC.entity.Reply;
import project.SpringBoot_JDBC.repository.BoardInterface;
import project.SpringBoot_JDBC.repository.ReplyInterface;

import java.util.List;

@Service
@Transactional
public class ReplyService {

    @Autowired
    private ReplyInterface replyInterface;

    @Autowired
    private BoardInterface boardInterface;


    // 댓글 작성
    public void writeReply(Reply reply){
        replyInterface.save(reply);
    }

    // 댓글 삭제
    public void deleteReply(Long replyId){
        replyInterface.deleteReplyById(replyId);
    }

    // 특정 게시글의 댓글 조회
    public List<Reply> findRepliesById(Long boardId) {
        Board board = boardInterface.findBoardById(boardId);
        return board.getReplies();
    }
}
