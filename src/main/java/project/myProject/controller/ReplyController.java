package project.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.myProject.entity.Board;
import project.myProject.entity.Reply;
import project.myProject.service.ReplyService;

@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    // 댓글 작성
    @PostMapping("/board/reply")
    public String replyWrite(Reply reply) {
        replyService.writeReply(reply);
        return "redirect:/board/list/"+reply.getBoard().getId();
    }

    // 댓글 리스트
//    @GetMapping("/board/list/{id}")
//    public String replyListForm(@PathVariable Long id, Model model) {
//        replyService.
//    }

}
