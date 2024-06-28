package Umc.Percol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Percol")
public class PercolController {

    //메인화면
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //로그인 후 메인화면 정보
    @PostMapping("/delete/{providerId}")
    public String delete(@PathVariable Long id){
        return "delete";
    }





}
