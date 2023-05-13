package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.MemberDTO;
import eunjilee.boardwithjpa.entity.MemberEntity;
import eunjilee.boardwithjpa.service.MemberService;
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
        MemberEntity loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            httpSession.setAttribute("loginEmail", loginResult.getEmail());
            return "redirect:/";
        }
        else {
            return "login";
        }
    }
    @PostMapping("/member/join")
    public String joinMember(MemberDTO memberDTO) {
        memberService.join(memberDTO);
        return "redirect:/";
    }
    @GetMapping("/member/join")
    public String joinForm() {
        return "join";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
