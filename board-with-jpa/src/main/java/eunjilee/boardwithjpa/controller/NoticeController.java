package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.NoticeDTO;
import eunjilee.boardwithjpa.entity.CommentEntity;
import eunjilee.boardwithjpa.entity.NoticeEntity;
import eunjilee.boardwithjpa.service.CommentService;
import eunjilee.boardwithjpa.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class NoticeController {
    private final NoticeService noticeService;
    private final CommentService commentService;
    @GetMapping("/board/notice")
    public String noticeForm() {
        return "noticeForm";
    }
    @PostMapping("/board/notice")
    public String writeNotice(NoticeDTO noticeDTO, HttpSession httpSession) {
        String uid = (String)httpSession.getAttribute("loginEmail");
        noticeService.saveNotice(uid, noticeDTO);
        return "redirect:/";
    }
    @GetMapping("/board/notice/{noticeId}")
    public String showNotice(@PathVariable Long noticeId, Model model) {
        NoticeEntity noticeEntity = noticeService.findOne(noticeId);
        if (noticeEntity != null) {
            model.addAttribute("notice", NoticeDTO.EntityToDTO(noticeEntity));
        }
        List<CommentEntity> commentEntityList = commentService.findComments(noticeId);
        model.addAttribute("comments",commentEntityList);
        return "notice";
    }
    @GetMapping("/board/notice/modify/{noticeId}")
    public String modifyNotice(@PathVariable Long noticeId, Model model) {
        model.addAttribute("notice", NoticeDTO.EntityToDTO(noticeService.findOne(noticeId)));
        return "noticeModForm";
    }
    @PostMapping("/board/notice/update/{noticeId}")
    public String modifyNotice(@PathVariable Long noticeId, NoticeDTO noticeDTO, Model model) {
        NoticeEntity updated = noticeService.updateNotice(noticeId, noticeDTO);
        model.addAttribute("notice", NoticeDTO.EntityToDTO(updated));
        return "redirect:/board/notice/{noticeId}";
    }
    @GetMapping("/board/notice/remove/{noticeId}")
    public String removeNotice(@PathVariable Long noticeId) {
        noticeService.removeById(noticeId);
        return "redirect:/";
    }
}
