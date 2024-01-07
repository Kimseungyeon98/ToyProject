package com.myproject.myapp;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.BoardVO;
import com.board.service.boardService;

@Controller
@RequestMapping("/board/*")

public class BoardController {
	@Inject
	private boardService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getList(Model model) {
		List<BoardVO> list = service.list();
		model.addAttribute("list",list);
		//board/list.jsp로 포워딩
		return "board/list";
	}
	// 게시물 작성 페이지로 이동
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String Create() throws Exception {
		return "board/create";
	}
	// 게시물 작성 post
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String postcreate(BoardVO vo) throws Exception {
		service.create(vo);
		return "redirect:list";
	}
	
	// 게시물 상세 페이지로 이동
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String getdetail(Model model, int no) {
		BoardVO data = service.detail(no);//no값 넘김
		model.addAttribute("data", data);
		return "board/detail";
	}
	
	
	// 게시물 수정 페이지로 이동
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String getupdate(int no, Model model) throws Exception {
		BoardVO data = service.detail(no);
		model.addAttribute("data", data);
		return "board/update";
	}
	
	// 게시물 수정  post
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String postupdate(BoardVO vo) throws Exception {
		service.update(vo);
		return "redirect:list"; //리스트로 리다이렉트
	}
	
	// 게시물 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String postdelete(String no) throws Exception {
		service.delete(no);
		return "redirect:list";
	}
	
	// 게시물 선택삭제
	@RequestMapping(value="/delete")
	public String ajaxTest(HttpServletRequest request) {
		String[] ajaxMsg = request.getParameterValues("valueArr");
		int size = ajaxMsg.length;
		for(int i=0; i<size; i++) {
			service.delete(ajaxMsg[i]);
		}
		return "redirect:list";
	}
}
