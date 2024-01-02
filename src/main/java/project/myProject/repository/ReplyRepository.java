package project.myProject.repository;

import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.springframework.stereotype.Repository;
import project.myProject.entity.Reply;

import java.util.List;

@Repository
public class ReplyRepository implements ReplyInterface{

    private final EntityManager em;

    public ReplyRepository(EntityManager em) {
        this.em=em;
    }

    @Override
    public void save(@Valid Reply reply) {
        em.persist(reply);
    }

    @Override
    public void deleteById(Long replyId) {
        em.createQuery("delete from Reply r where r.id=:id").setParameter("id",replyId).executeUpdate();
    }

    @Override
    public Reply findById(Long replyId) {
        return em.createQuery("select r from Reply r where r.id=:id",Reply.class).setParameter("id",replyId).getSingleResult();
    }
}