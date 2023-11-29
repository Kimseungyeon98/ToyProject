package project.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.myProject.entity.Board;
import project.myProject.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시물 작성
    @GetMapping("/board/write")
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("/board/write")
    public String boardWrite(Board board) {
        boardService.writeBoard(board);
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
        Board board = boardService.findOneBoard(id);
        model.addAttribute("board",board);
        return "boardDetail";
    }


    // 게시물 수정
    @GetMapping("/board/list/{id}/edit")
    public String boardEditForm(@PathVariable Long id, Model model){
        Board board = boardService.findOneBoard(id);
        model.addAttribute("board", board);
        return "boardEdit";
    }

    @PostMapping("/board/list/{id}/edit")
    public String boardEdit(@ModelAttribute Board board){
        boardService.writeBoard(board);
        return "redirect:/board/list";
    }


    // 게시물 삭제
    @PostMapping("/board/list/{id}/delete")
    public String boardDelete(@PathVariable Long id){
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }


    // 게시글 댓글 작성

    // 게시글 댓글 삭제

    // 게시글 사진 업로드

    // 게시글 사진 삭제
}
