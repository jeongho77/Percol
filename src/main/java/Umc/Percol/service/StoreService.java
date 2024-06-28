package Umc.Percol.service;

import Umc.Percol.entity.IncenseEntity;
import Umc.Percol.entity.PerfumeEntity;
import Umc.Percol.entity.ShopEntity;
import Umc.Percol.repository.Find_PerfumeRepository;
import Umc.Percol.repository.IncenseRepository;
import Umc.Percol.repository.PerfumeRepository;
import Umc.Percol.web.dto.IncenseDTO;
import Umc.Percol.web.dto.PerfumeDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final PerfumeRepository perfumeRepository;
    private final IncenseRepository incenseRepository;

    //Perfume 모든걸 조회
    public List<PerfumeDTO> PerfumeFindAll() {
        List<PerfumeEntity> PerfumeEntityList = perfumeRepository.findAll();
        List<PerfumeDTO> PerfumeDTOList = new ArrayList<>();

        for (PerfumeEntity perfumeEntity : PerfumeEntityList) {
            PerfumeDTOList.add(PerfumeDTO.toPerfumeDTO(perfumeEntity));
        }

        return PerfumeDTOList;
    }

    //Perfume 모든걸 조회 + 페이징
    @Transactional
    public Page<PerfumeDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1; // 페이지 0부터 시작해서 -1 해줘야함
        int pageLimit = 3; // 한페이지에 보여줄 글 갯수
        //한 페이지당 3개씩 글을 보여주고 정렬 기준은 id 기준으로 내림차순 정렬
        Page<PerfumeEntity> PerfumeEntities
                = perfumeRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC,"id")));

        System.out.println("boardEntities.getContent() = " + PerfumeEntities.getContent()); // 요청 페이지에 해당하는 글
        System.out.println("boardEntities.getTotalElements() = " + PerfumeEntities.getTotalElements()); // 전체 글갯수
        System.out.println("boardEntities.getNumber() = " + PerfumeEntities.getNumber()); // DB로 요청한 페이지 번호
        System.out.println("boardEntities.getTotalPages() = " + PerfumeEntities.getTotalPages()); // 전체 페이지 갯수
        System.out.println("boardEntities.getSize() = " + PerfumeEntities.getSize()); // 한 페이지에 보여지는 글 갯수
        System.out.println("boardEntities.hasPrevious() = " + PerfumeEntities.hasPrevious()); // 이전 페이지 존재 여부
        System.out.println("boardEntities.isFirst() = " + PerfumeEntities.isFirst()); // 첫 페이지 여부
        System.out.println("boardEntities.isLast() = " + PerfumeEntities.isLast()); // 마지막 페이지 여부

        //MAP은 board 변수를 하나씩 꺼내서 DTO 객체에 연결해줌
        //목록 : ID, WRITER , TITLE , HITS, createdTime
        Page<PerfumeDTO> PerfumeDTOS = PerfumeEntities.map(perfume -> new PerfumeDTO(
                perfume.getId(),
                perfume.getName(),
                perfume.getImage(),
                perfume.getContent(),
                perfume.getPrice(),
                perfume.getBuyUrl()));

        return PerfumeDTOS;
    }

    @Transactional
    public Page<IncenseDTO> IncensePaging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1; // 페이지 0부터 시작해서 -1 해줘야함
        int pageLimit = 3; // 한페이지에 보여줄 글 갯수
        //한 페이지당 3개씩 글을 보여주고 정렬 기준은 id 기준으로 내림차순 정렬
        Page<IncenseEntity> IncenseEntities
                = incenseRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC,"id")));

        System.out.println("boardEntities.getContent() = " + IncenseEntities.getContent()); // 요청 페이지에 해당하는 글
        System.out.println("boardEntities.getTotalElements() = " + IncenseEntities.getTotalElements()); // 전체 글갯수
        System.out.println("boardEntities.getNumber() = " + IncenseEntities.getNumber()); // DB로 요청한 페이지 번호
        System.out.println("boardEntities.getTotalPages() = " + IncenseEntities.getTotalPages()); // 전체 페이지 갯수
        System.out.println("boardEntities.getSize() = " + IncenseEntities.getSize()); // 한 페이지에 보여지는 글 갯수
        System.out.println("boardEntities.hasPrevious() = " + IncenseEntities.hasPrevious()); // 이전 페이지 존재 여부
        System.out.println("boardEntities.isFirst() = " + IncenseEntities.isFirst()); // 첫 페이지 여부
        System.out.println("boardEntities.isLast() = " + IncenseEntities.isLast()); // 마지막 페이지 여부

        Page<IncenseDTO> incenseDTOS = IncenseEntities.map(incense -> new IncenseDTO(
                incense.getId(),
                incense.getName(),
                incense.getImage(),
                incense.getType(),
                incense.getContent()));

        return incenseDTOS;
    }

    public List<PerfumeDTO> findName(String name) {
        List<PerfumeEntity> perfumeEntities = perfumeRepository.findByNameContaining(name);
        return perfumeEntities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private PerfumeDTO convertToDto(PerfumeEntity perfumeEntity) {
        PerfumeDTO perfumeDTO = new PerfumeDTO();
        perfumeDTO.setId(perfumeEntity.getId());
        perfumeDTO.setName(perfumeEntity.getName());
        perfumeDTO.setContent(perfumeEntity.getContent());
        perfumeDTO.setImage(perfumeEntity.getImage());
        return perfumeDTO;
    }


}
