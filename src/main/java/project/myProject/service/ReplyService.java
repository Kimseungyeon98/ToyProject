package project.myProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.myProject.entity.Board;
import project.myProject.entity.Reply;
import project.myProject.repository.BoardInterface;
import project.myProject.repository.ReplyInterface;

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
        replyInterface.deleteById(replyId);
    }

    // 특정 게시글의 댓글 조회
    public List<Reply> findReply(Long boardId) {
        Board board = boardInterface.findById(boardId);
        return board.getReplies();
    }
}
