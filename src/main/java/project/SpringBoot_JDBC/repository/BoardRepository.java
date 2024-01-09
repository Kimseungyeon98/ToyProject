package project.SpringBoot_JDBC.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import project.SpringBoot_JDBC.entity.Board;

import java.util.List;

@Repository
public class BoardRepository implements BoardInterface {

    private final EntityManager em;

    public BoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Board board) {
        em.persist(board);
    }

    @Override
    public void update(Board board){
        em.createQuery("update Board b set b.title=:title, b.content=:content, b.fileName=:fileName, b.filePath=:filePath")
                .setParameter("title",board.getTitle())
                .setParameter("content",board.getContent())
                .setParameter("fileName",board.getFileName())
                .setParameter("filePath",board.getFilePath())
                .executeUpdate();
    }

    @Override
    public void deleteBoardById(Long boardId) {
        em.createQuery("delete from Board b where b.id=:id")
                .setParameter("id",boardId)
                .executeUpdate();
    }

    @Override
    public Board findBoardById(Long boardId) {
//        return em.find(Board.class,boardId);
        return em.createQuery("select b from Board b where b.id=:id", Board.class)
                .setParameter("id",boardId)
                .getSingleResult();
//        return em.createQuery("select m from Board b where b.id=:id",Board.class).setParameter("id",boardId).getResultList().stream().findAny();
    }

    @Override
    public List<Board> findAllBoard() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }
}
