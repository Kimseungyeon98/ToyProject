package project.myProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.myProject.repository.MemberInterface;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberInterface memberInterface;

    public boolean isLogInIdAvailable(String logInId) {
        return memberInterface.findMemberByLogInId(logInId)==null;
    }

}
