package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.BoardDTO;
import eunjilee.boardwithjpa.entity.Board;
import eunjilee.boardwithjpa.entity.Member;
import eunjilee.boardwithjpa.service.BoardService;
import eunjilee.boardwithjpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class BoardController {
    private final MemberService memberService;
    private final BoardService boardService;
    @GetMapping("/")
    public String showBoard(Model model) {
        List<Board> articles = boardService.getAllArticles();
//        for (Board article : articles)
//            System.out.println("*: " + article.toString());
        model.addAttribute("articles", articles);
        return "board";
    }
    @GetMapping("/board/article")
    public String articleForm() {
        return "article";
    }

    @PostMapping("/board/article")
    public String article(BoardDTO boardDTO, HttpSession httpSession) {
        String uid = (String)httpSession.getAttribute("loginEmail");
        if (uid != null) {
            Member selectedOne = memberService.findOne(uid).get();
            Board board = new Board();
            board.toUpdateBoardEntity(boardDTO, selectedOne);
            boardService.saveArticle(board);
        }
        return "redirect:/";
    }
}
