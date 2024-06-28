package Umc.Percol.web.dto;

import Umc.Percol.entity.PerfumeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString //필드값학인
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자(햄버거)
public class PerfumeDTO {

    private Long id;
    private String name;
    private String image;
    private String content;
    private String price;
    private String buyUrl;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public PerfumeDTO(Long id, String name, String image, String content, String price, String buyUrl) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.content = content;
        this.price = price;
        this.buyUrl = buyUrl;
    }

    public static PerfumeDTO toPerfumeDTO(PerfumeEntity perfumeEntity){
        PerfumeDTO perfumeDTO = new PerfumeDTO();
        perfumeDTO.setId(perfumeEntity.getId());
        perfumeDTO.setName(perfumeEntity.getName());
        perfumeDTO.setImage(perfumeEntity.getImage());
        perfumeDTO.setContent(perfumeEntity.getContent());
        perfumeDTO.setPrice(perfumeEntity.getPrice());
        perfumeDTO.setBuyUrl(perfumeEntity.getBuyUrl());
        perfumeDTO.setCreatedDate(perfumeEntity.getCreatedDate());
        perfumeDTO.setLastModifiedDate(perfumeEntity.getLastModifiedDate());
        return perfumeDTO;
    }
}
