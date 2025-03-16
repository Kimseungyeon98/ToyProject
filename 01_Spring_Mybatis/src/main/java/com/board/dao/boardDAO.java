package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;

public interface boardDAO {
	public List<BoardVO> list(); //조회
	public void create(BoardVO vo); //쓰기
	public BoardVO detail(int no); //상세보기
	public void update(BoardVO vo); //수정하기
	public void delete(String no); //삭제하기
}
