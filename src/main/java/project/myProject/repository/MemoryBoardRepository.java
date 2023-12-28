package project.myProject.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import project.myProject.entity.Board;

import java.util.List;
import java.util.Optional;

@Repository
public class MemoryBoardRepository implements BoardRepository{

    private final EntityManager em;

    public MemoryBoardRepository(EntityManager em) {
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
    public void deleteById(Long boardId) {
        em.createQuery("DELETE FROM Board b Where b.id=:id").setParameter("id",boardId).executeUpdate();
        em.clear();
    }

    @Override
    public Board findById(Long boardId) {
//        return em.find(Board.class,boardId);
        return em.createQuery("select b from Board b where b.id=:id",Board.class).setParameter("id",boardId).getSingleResult();
//        return em.createQuery("select m from Board b where b.id=:id",Board.class).setParameter("id",boardId).getResultList().stream().findAny();
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select m from Board m", Board.class)
                .getResultList();
    }
}
