package Umc.Percol.controller;

import Umc.Percol.service.StoreService;
import Umc.Percol.web.dto.IncenseDTO;
import Umc.Percol.web.dto.PerfumeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/percol")
public class PercolController {

    private final StoreService storeService;

    //메인화면
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //로그인 후 메인화면 정보
    @PostMapping("/main")
    public String login(@PathVariable Long id){
        return "delete";
    }

    @PostMapping("/delete/{providerId}")
    public String delete(@PathVariable Long id){
        return "delete";
    }

    //향수
    @GetMapping("/PerfumeStore")
    public String perfumeStore(Model model){
        List<PerfumeDTO> perfumeDTOList = storeService.PerfumeFindAll();
        model.addAttribute("perfumeList", perfumeDTOList);

        return "perfumeStore";
    }

    // /board/paging?page=1
    @GetMapping("/PerfumeShop") //pageable import 잘 확인하기
    public String PerfumeStore(@PageableDefault(page = 1) Pageable pageable , Model model){
        pageable.getPageNumber();
        Page<PerfumeDTO> perFumeList = storeService.paging(pageable);
        int blockLimit = 3;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
        int endPage = ((startPage + blockLimit - 1) < perFumeList.getTotalPages()) ? startPage + blockLimit - 1 : perFumeList.getTotalPages();

        model.addAttribute("perFumeList", perFumeList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "PerfumeShop";
    }

    @GetMapping("/IncenseShop") //pageable import 잘 확인하기
    public String IncenseStore(@PageableDefault(page = 1) Pageable pageable , Model model){
        pageable.getPageNumber();
        Page<IncenseDTO> incenseList = storeService.IncensePaging(pageable);
        int blockLimit = 3;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
        int endPage = ((startPage + blockLimit - 1) < incenseList.getTotalPages()) ? startPage + blockLimit - 1 : incenseList.getTotalPages();

        model.addAttribute("incenseList", incenseList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "PerfumeShop";
    }





}
