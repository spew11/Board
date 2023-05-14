package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.CommentDTO;
import eunjilee.boardwithjpa.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/board/notice/{noticeId}/comment")
    public String writeNotice(@PathVariable Long noticeId, HttpSession httpSession, CommentDTO commentDTO, Model model) {
        System.out.println("here!!!!!!!!!!!");
        String uid = (String)httpSession.getAttribute("loginEmail");
        commentService.saveComment(uid, noticeId, commentDTO);
        return "redirect:/board/notice/{noticeId}";
    }
}
