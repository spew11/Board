package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.MemberDTO;
import eunjilee.boardwithjpa.entity.Member;
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
        Member loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            System.out.println("login complete!");
            httpSession.setAttribute("loginName", loginResult.getMemberNickName());
            System.out.println(httpSession.getAttribute("loginName"));
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
