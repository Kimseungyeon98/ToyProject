package project.myProject.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import project.myProject.entity.Member;

import java.util.List;

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
    public void logIn(Member member) {

    }

    @Override
    public Member findMemberById(Long memberId) {
        return em.createQuery("select m from Member m where m.id=:id", Member.class)
                .setParameter("id",memberId)
                .getSingleResult();
    }

    @Override
    public Member findMemberByLogInId(String logInId) {
        return em.createQuery("select m from Member m where m.logInId=:logInId",Member.class)
                .setParameter("logInId",logInId)
                .getSingleResult();
    }

    @Override
    public List<Member> findAllMember() {
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }
}
