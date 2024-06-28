package Umc.Percol.web.dto;

import Umc.Percol.entity.HoldEntity;
import Umc.Percol.entity.IncenseEntity;
import Umc.Percol.entity.MatchEntity;
import Umc.Percol.entity.WishIncenseEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class IncenseDTO {

    private Long id;
    private String name;
    private String image;
    private String type;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private List<WishIncenseEntity> wishIncensesEntityList;
    private List<MatchEntity> matchEntityList;
    private List<HoldEntity> holdEntityList;

    public static IncenseDTO toIncenseDTO(IncenseEntity incenseEntity) {
        IncenseDTO incenseDTO = new IncenseDTO();
        incenseDTO.setId(incenseEntity.getId());
        incenseDTO.setName(incenseEntity.getName());
        incenseDTO.setImage(incenseEntity.getImage());
        incenseDTO.setType(incenseEntity.getType());
        incenseDTO.setContent(incenseEntity.getContent());
        incenseDTO.setCreateTime(incenseEntity.getCreatedDate());
        incenseDTO.setUpdateTime(incenseEntity.getLastModifiedDate());

        return incenseDTO;
    }


}
