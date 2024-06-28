package Umc.Percol.web.dto;

import Umc.Percol.entity.HoldEntity;
import Umc.Percol.entity.ShopEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ShopDTO {
    private Long id;
    private String name;
    private String representative;
    private String phone;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private List<HoldEntity> holdEntityList;

    public static ShopDTO toShopDTO(ShopEntity shopEntity) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shopEntity.getId());
        shopDTO.setName(shopEntity.getName());
        shopDTO.setRepresentative(shopEntity.getRepresentative());
        shopDTO.setPhone(shopEntity.getPhone());
        shopDTO.setContent(shopEntity.getContent());
        shopDTO.setCreatedTime(shopEntity.getCreatedDate());
        shopDTO.setUpdatedTime(shopEntity.getLastModifiedDate());

        return shopDTO;
    }
}
