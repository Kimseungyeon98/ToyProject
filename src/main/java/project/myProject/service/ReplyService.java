package project.myProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.myProject.entity.Board;
import project.myProject.entity.Reply;
import project.myProject.repository.BoardRepository;
import project.myProject.repository.ReplyRepository;

import java.util.List;

@Service
@Transactional
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    // 댓글 작성
    public void writeReply(Reply reply){
        replyRepository.save(reply);
    }

    // 댓글 삭제
    public void deleteReply(Long replyId){
        replyRepository.deleteById(replyId);
    }

    // 댓글 전체 조회
//    public List<Reply> findAllReply(){
//        return replyRepository.findAll();
//    }

    // 특정 게시글의 댓글 조회
//    public List<Reply> findReply(Reply reply){
//
//        return replyRepository.findAllById();
//    }
}
