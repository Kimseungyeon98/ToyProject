package project.myProject.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import project.myProject.entity.Member;

@Repository
public class MemberRepository implements MemberInterface{
    private final EntityManager em;

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void signUp(Member member) {
        em.persist(member);
    }

    @Override
    public void login(Member member) {

    }
}
