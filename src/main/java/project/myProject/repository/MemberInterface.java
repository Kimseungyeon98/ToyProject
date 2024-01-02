package project.myProject.repository;

import project.myProject.entity.Member;

public interface MemberInterface {
    void signUp(Member member);
    void login(Member member);
}
