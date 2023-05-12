package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.BoardDTO;
import eunjilee.boardwithjpa.entity.Board;
import eunjilee.boardwithjpa.entity.Member;
import eunjilee.boardwithjpa.service.BoardService;
import eunjilee.boardwithjpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final MemberService memberService;
    private final BoardService boardService;
    @GetMapping("/")
    public String showBoard(Model model) {
        List<BoardDTO> articles = boardService.getAllArticles();
        model.addAttribute("articles", articles); //나중에 이거 이름 boards로 바꾸자..
        return "board";
    }
    @GetMapping("/board/article-form")
    public String articleForm() {
        return "articleForm";
    }

    @PostMapping("/board/article-form")
    public String writeArticle(BoardDTO boardDTO, HttpSession httpSession) {
        System.out.println("--------------------------------------hehehehe");
        String uid = (String)httpSession.getAttribute("loginName");
        System.out.println("=============================="+uid);
        if (uid != null) {
            Optional<Member> selectedOne = memberService.findOneByNickName(uid);
            if (selectedOne.isPresent()) {
                Board board = new Board();
//              System.out.println("***********"+uid);
//              System.out.println(boardDTO.toString());
//              System.out.println(selectedOne.toString());
                board.toUpdateBoardEntity(boardDTO, selectedOne.get());
                boardService.saveArticle(board);
            }
            else {
                System.out.println("*****NOTHING*****");
            }
        }
        return "redirect:/";
    }

    @GetMapping("/board/{articleNo}")
    public String showArticle(@PathVariable Long articleNo, Model model) {
        Board board = boardService.findOne(articleNo);
        if (board != null) {
            model.addAttribute("board", board);
        }
        else {
            System.out.println("존재하지 않는 게시글 입니다.");
        }
        return "article";
    }
}
