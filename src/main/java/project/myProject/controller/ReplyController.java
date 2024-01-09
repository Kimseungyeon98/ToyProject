package project.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import project.myProject.entity.Board;
import project.myProject.entity.Reply;
import project.myProject.entity.ReplyDTO;
import project.myProject.service.BoardService;
import project.myProject.service.ReplyService;

@Controller
public class ReplyController {

    @Autowired
    public BoardService boardService;
    @Autowired
    public ReplyService replyService;


    // 게시글 댓글 작성
    @PostMapping("/board/reply")
    public String replyWrite(ReplyDTO replyDTO) {
        Board board = boardService.findOneBoard(replyDTO.getBoard());
        Reply reply = replyDTO.toEntity(board);

        replyService.writeReply(reply);
        return "redirect:/board/list/" + replyDTO.getBoard();
    }

    // 게시글 댓글 삭제
}
