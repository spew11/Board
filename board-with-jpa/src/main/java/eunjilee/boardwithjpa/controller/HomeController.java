package eunjilee.boardwithjpa.controller;

import eunjilee.boardwithjpa.dto.NoticeDTO;
import eunjilee.boardwithjpa.entity.NoticeEntity;
import eunjilee.boardwithjpa.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final NoticeService noticeService;
    @GetMapping("/")
    public String showNotice(Model model) {
        List<NoticeEntity> noticeEntities = noticeService.findAllNotice();
        List<NoticeDTO> noticeDTOs = new ArrayList<>();
        for (NoticeEntity noticeEntity : noticeEntities) {
            noticeDTOs.add(NoticeDTO.EntityToDTO(noticeEntity));
        }
        Collections.sort(noticeDTOs, new Comparator<NoticeDTO>() {
            @Override
            public int compare(NoticeDTO o1, NoticeDTO o2) {
                return o2.getRegDate().compareTo(o1.getRegDate());
            }
        });
        model.addAttribute("notices", noticeDTOs);
        return "board";
    }
}
