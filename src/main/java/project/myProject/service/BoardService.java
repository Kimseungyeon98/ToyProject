package project.myProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import project.myProject.entity.Board;
import project.myProject.repository.BoardRepository;

import java.util.List;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 글 쓰기
    public void writeBoard(Board board) {
        boardRepository.save(board);
    }

    // 글 삭제
    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    // 전체 조회
    public List<Board> findAllBoard() {
        return boardRepository.findAll();
    }

    // 단건 조회
    public Board findOneBoard(Long boardId) {
        return boardRepository.getOne(boardId);
    }
}
