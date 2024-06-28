package Umc.Percol.controller;

import Umc.Percol.service.MbtiService;
import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("Percol")

public class MbtiController {
    private final MbtiController mbtiController;
    private final MbtiService mbtiService;

    @GetMapping("/Mbti")
    public String getMbtiAction(@RequestParam String mbti, Model model) {
        String action = mbtiService.getActionByMbti(mbti);
        model.addAttribute("mbti",mbti);
        model.addAttribute("action",mbti);
        return "mbtiAction";


    }

}
