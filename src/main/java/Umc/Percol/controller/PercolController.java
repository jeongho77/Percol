package Umc.Percol.controller;

import Umc.Percol.service.IncenseService;
import Umc.Percol.service.StoreService;
import Umc.Percol.service.UserService;
import Umc.Percol.web.dto.IncenseDTO;
import Umc.Percol.web.dto.PerfumeDTO;
import Umc.Percol.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/percol")
public class PercolController {

    private static final Logger log = LoggerFactory.getLogger(PercolController.class);

    private final StoreService storeService;
    private final UserService userService;
    private final IncenseService incenseService;

    //메인화면
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //로그인 후 메인화면 정보
    @PostMapping("/main")
    @ResponseBody // 이 애노테이션은 메소드의 반환값이 응답 본문이 될 것임을 나타내며, 일반적으로 JSON 형식으로 변환됩니다.
    public UserDTO login(@RequestBody Long id) { // @PathVariable 대신 @RequestBody 사용
        UserDTO userDto = userService.findUserById(id);
        return userDto;
    }

    //회원탈퇴
    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Long id){
        userService.delete(id);
        return "main"; //메인화면으로
    }

    //향수
    @GetMapping("/PerfumeStore")
    public String perfumeStore(Model model){
        List<PerfumeDTO> perfumeDTOList = storeService.PerfumeFindAll();
        model.addAttribute("perfumeList", perfumeDTOList);

        return "perfumeStore";
    }

    // /board/paging?page=1
    @GetMapping("/PerfumeShop")
    @ResponseBody // This annotation indicates that the return value of the method will be the response body, which is typically JSON.
    public Map<String, Object> PerfumeStore(@PageableDefault(page = 1) Pageable pageable) {
        pageable.getPageNumber();
        Page<PerfumeDTO> perFumeList = storeService.paging(pageable);
        int blockLimit = 3;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
        int endPage = ((startPage + blockLimit - 1) < perFumeList.getTotalPages()) ? startPage + blockLimit - 1 : perFumeList.getTotalPages();

        Map<String, Object> response = new HashMap<>();
        response.put("perFumeList", perFumeList.getContent()); // List of PerfumeDTO
        response.put("startPage", startPage);
        response.put("endPage", endPage);
        response.put("totalPages", perFumeList.getTotalPages());
        response.put("totalElements", perFumeList.getTotalElements());
        response.put("currentPage", pageable.getPageNumber());

        return response;
    }


    @GetMapping("/IncenseShop")
    @ResponseBody // 이 애노테이션은 메소드의 반환값이 응답 본문이 될 것임을 나타내며, 일반적으로 JSON 형식으로 변환됩니다.
    public Map<String, Object> IncenseStore(@PageableDefault(page = 1) Pageable pageable) {
        pageable.getPageNumber();
        Page<IncenseDTO> incenseList = storeService.IncensePaging(pageable);
        int blockLimit = 3;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 등
        int endPage = ((startPage + blockLimit - 1) < incenseList.getTotalPages()) ? startPage + blockLimit - 1 : incenseList.getTotalPages();

        Map<String, Object> response = new HashMap<>();
        response.put("incenseList", incenseList.getContent()); // IncenseDTO 객체 리스트
        response.put("startPage", startPage);
        response.put("endPage", endPage);
        response.put("totalPages", incenseList.getTotalPages());
        response.put("totalElements", incenseList.getTotalElements());
        response.put("currentPage", pageable.getPageNumber());

        return response;
    }


    @GetMapping("/PerfumeFind/{name}") //향수 검색
    public List<PerfumeDTO> PerfumeFind(@PathVariable String name ,Model model){
        List<PerfumeDTO> PerfumeDTOList = storeService.findName(name);

        log.info("PerfumeDTOList: {}", PerfumeDTOList);
        model.addAttribute("perfumeList", PerfumeDTOList);

        return PerfumeDTOList;
    }

    //마이페이지 조회
    @PostMapping("/MyPage")
    public UserDTO myPage(@ModelAttribute("id") Long id, Model model) {

        UserDTO userDto = userService.findUserById(id);
        model.addAttribute("user", userDto);

        return userDto; // myPage.html 템플릿으로 반환
    }


    //MBTI 테스트
    @GetMapping("/Mbti/{id}")
    public Map<String, IncenseDTO> getMbtiAction(@PathVariable Long id, Model model) {
        IncenseDTO incenseDto = incenseService.mbtiIncense(id);
        IncenseDTO incenseDto2 = incenseService.mbtiIncense(id+1);

        Map<String, IncenseDTO> response = new HashMap<>();
        response.put("incenseDto", incenseDto);
        response.put("incenseDto2", incenseDto2);

        return response;

    }
}
