package project.myProject.repository;

import project.myProject.entity.Member;

import java.util.List;

public interface MemberInterface {
    void signUp(Member member);
    void logIn(Member member);
    Member findMemberById(Long memberId);
    Member findMemberByLogInId(String logInId);
    List<Member> findAllMember();
}
