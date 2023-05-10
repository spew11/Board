package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member/login")
    public String login_form() {
        return "login";
    }
    @PostMapping("/member/login")
    public String login(MemberDTO memberDTO, HttpSession httpSession) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            System.out.println("login complete!");
            httpSession.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "redirect:/";
        }
        else {
            System.out.println("login failed");
            return "login";
        }
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

    @GetMapping("/member/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}