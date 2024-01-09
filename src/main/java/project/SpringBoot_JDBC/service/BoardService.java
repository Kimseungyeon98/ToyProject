package project.SpringBoot_JDBC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import project.SpringBoot_JDBC.entity.Board;
import project.SpringBoot_JDBC.repository.BoardInterface;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardInterface boardInterface;

//    private final BoardInterface boardInterface;
//
//    public BoardService(BoardInterface boardInterface) {
//        this.boardInterface = boardInterface;
//    }
    public Board fileUpload(Board board, MultipartFile file) throws Exception {
        // 파일 첨부 로직
        if(!file.isEmpty()) {
            // 1. 프로젝트 경로 + 저장할 경로를 지정
            String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

            // 2. 식별자 랜덤으로 생성
            UUID uuid = UUID.randomUUID();

            // 3. '랜덤식별자_원래파일이름' 으로 저장될 파일 이름 지정
            String fileName = uuid + "_" + file.getOriginalFilename();


            // 4. 빈 껍데기 생성
            File saveFile = new File(filePath, fileName);

            file.transferTo(saveFile);

            // 디비에 파일내용 등록
            board.setFileName(fileName);
            board.setFilePath("/files/" + fileName);
        }
        return board;
    }

    // 글 작성
    public void writeBoard(Board board, MultipartFile file) throws Exception{
        boardInterface.save(fileUpload(board, file));
    }
    // 글 수정
    public void updateBoard(Board board, MultipartFile file) throws Exception{
        boardInterface.update(fileUpload(board, file));
    }

    // 글 삭제 시 저장된 파일 삭제
    public void deleteFileBoard(Long boardId) {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
        File file = new File(filePath+"\\"+ boardInterface.findBoardById(boardId).getFileName());
        file.delete();
    }

    // 글 삭제
    public void deleteBoard(Long boardId) {
        deleteFileBoard(boardId);
        boardInterface.deleteBoardById(boardId);
    }

    // 전체 조회
    public List<Board> findAllBoard() {
        return boardInterface.findAllBoard();
    }

    // 단건 조회
    public Board findOneBoard(Long boardId) {
        return boardInterface.findBoardById(boardId);
    }

}
