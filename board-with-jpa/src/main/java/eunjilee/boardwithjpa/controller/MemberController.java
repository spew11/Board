package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.MemberDTO;
import eunjilee.boardwithjpa.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member/login")
    public String login_form() {
        return "login";
    }
    @PostMapping("/member/login")
    public String login(MemberDTO memberDTO) {
        if (memberService.login(memberDTO)) {
            System.out.println("login complete!");
        }
        else {
            System.out.println("login failed");
        }
        return "redirect:/";
    }
    @PostMapping("/member/sign-up")
    public String join_member(MemberDTO memberDTO) {
        memberService.join(memberDTO);
        return "redirect:/";
    }
    @GetMapping("/member/sign-up")
    public String sign_up_form() {
        return "sign_up";
    }
}
