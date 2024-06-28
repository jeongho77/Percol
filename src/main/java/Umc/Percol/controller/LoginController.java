package Umc.Percol.controller;

import Umc.Percol.service.UserService;
import Umc.Percol.web.dto.ReissueTokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private UserService userService;

    // 로그인 화면 (카카오, 네이버 선택)
    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping(value = "/kakao")
    public String kakaoLogin(@RequestBody ReissueTokenResponseDto reissueTokenResponseDto) throws Exception {
        // 엑세스 토큰을 다시 카카오에 줘서 안에 있는 id_token을 받아온다.
        long idToken;
        try {
            idToken = userService.getIdToken(reissueTokenResponseDto.getAccessToken());
        } catch (Exception e) {
            // idToken을 가져오는 중에 예외가 발생한 경우
            System.out.println("Exception occurred while getting idToken: " + e.getMessage());
            return "error"; // 예외 발생 시 에러 페이지로 이동
        }

        System.out.println("idToken : " + idToken); // try 문이 정상적으로 실행되면, 해당 코드가 정상적으로 실행된다.

        // idToken와 관련한 사용자 정보가 DB에 저장되어 있는지 확인 저장 안되어 있으면(기존회원) -> String providerId 반환
        // long providerID;

        // 기존회원의 카카오 UID(providerID)로 우리 서비스의 UID를 추출하는 코드
        // Long userId = userService.getUserId(providerID); // -> try 문이 정상적으로 실행되면, 해당 코드가 정상적으로 실행된다.

        return "user/kakao"; // 뷰 이름을 반환
    }

    // 카카오 로그인 뷰
    @GetMapping("/kakao")
    public String kakaoLogin() {
        return "kakao-login";
    }

    // 네이버 로그인 뷰
    @GetMapping("/naver")
    public String naverLogin() {
        return "naver-login";
    }
}

