package Umc.Percol.web.dto;

import Umc.Percol.entity.UserEntity;
import Umc.Percol.entity.WishIncenseEntity;
import Umc.Percol.entity.WishPerfumeEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String nickname;
    private String provider;
    private String providerId;
    private String marketingAgree;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private List<WishPerfumeEntity> wishPerfumeEntityList;
    private List<WishIncenseEntity> wishIncensEntityList;

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setNickname(userEntity.getNickname());
        userDTO.setProvider(userEntity.getProvider());
        userDTO.setProviderId(userEntity.getProviderId());
        userDTO.setMarketingAgree(userEntity.getMarketingAgree());
        userDTO.setCreatedTime(userEntity.getCreatedDate());
        userDTO.setUpdatedTime(userEntity.getLastModifiedDate());

        userDTO.setWishPerfumeEntityList(new ArrayList<>(userEntity.getWishPerfumeEntityList()));
        userDTO.setWishIncensEntityList(new ArrayList<>(userEntity.getWishIncenseEntityList()));

        return userDTO;
    }
}
