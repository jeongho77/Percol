package Umc.Percol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {

    //로그인화면 ( 카카오 , 네이버 선택)
    @GetMapping("/")
    public String index(){
        return "login";
    }

    //카카오 로그인 뷰
    @GetMapping("/kakao")
    public String kakaoLogin(){
        return "kakao-login";
    }

    //네이버 로그인 뷰
    @GetMapping("/naver")
    public String naverLogin(){
        return "naver-login";
    }


}
