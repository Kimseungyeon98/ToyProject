package ksy.shop.member.controller;

import ksy.shop.member.service.MemberService;
import ksy.shop.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member")
    public String member(){

        return "/member/list";
    }

    @GetMapping("/member/register")
    public String register(){

        return "/member/register";
    }
    @PostMapping("/member/register")
    public String register(MemberVO member){
        System.out.println(member.toString());
        memberService.insertMember(member);
        return "redirect:/member";
    }
}
