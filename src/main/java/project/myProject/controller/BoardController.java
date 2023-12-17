package project.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.myProject.entity.Board;
import project.myProject.entity.Reply;
import project.myProject.service.BoardService;
import project.myProject.service.ReplyService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ReplyService replyService;

    // 게시물 작성
    @GetMapping("/board/write")
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("/board/write")
    public String boardWrite(Board board, MultipartFile file) throws Exception{
        boardService.writeBoard(board, file);
        return "redirect:/board/list";
    }


    // 게시물 리스트
    @GetMapping("/board/list")
    public String boardListForm(Model model){
        model.addAttribute("boards",boardService.findAllBoard());
        return "boardList";
    }

    // 게시물 상세조회
    @GetMapping("/board/list/{id}")
    public String boardDetailForm(@PathVariable Long id, Model model) {
        model.addAttribute("board",boardService.findOneBoard(id));
        model.addAttribute("replies",replyService.findReply(id));
        return "boardDetail";
    }


    // 게시물 수정
    @GetMapping("/board/list/{id}/edit")
    public String boardEditForm(@PathVariable Long id, Model model){
        model.addAttribute("board", boardService.findOneBoard(id));
        return "boardEdit";
    }

    @PostMapping("/board/list/{id}/edit")
    public String boardEdit(@ModelAttribute Board board, MultipartFile file) throws Exception{
        boardService.deleteFileBoard(board.getId());
        boardService.writeBoard(board, file);
        return "redirect:/board/list";
    }


    // 게시물 삭제
    @PostMapping("/board/list/{id}/delete")
    public String boardDelete(@PathVariable Long id){
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }


    // 게시글 댓글 작성
    @PostMapping("/board/reply")
    public String replyWrite(Reply reply) {
        replyService.writeReply(reply);
        return "redirect:/board/list/"+reply.getBoard().getId();
    }


    // 게시글 댓글 삭제
}
