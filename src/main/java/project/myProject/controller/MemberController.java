package project.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.myProject.entity.MemberDTO;
import project.myProject.service.MemberService;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/logIn")
    public String logInForm(){
        return "LogIn";
    }
    @PostMapping("/logIn")
    public String LogIn(MemberDTO memberDTO ){
        return null;
    }


}
