package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.boardDAO;
import com.board.domain.BoardVO;

@Service
public class boardServiceImpl implements boardService {
	@Inject
	private boardDAO dao;

	// 회원 목록
	@Override
	public List<BoardVO> list() {
		return dao.list();
	}
	
	@Override
	public void create(BoardVO vo) {
		dao.create(vo);
	}
	
	// 게시물 상세내용 불러오기
	@Override
	public BoardVO detail(int no) {
		return dao.detail(no);
	}
	
	// 게시물 수정
	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}
	
	// 게시물 삭제
	@Override
	public void delete(String no) {
		dao.delete(no);
	}
}
