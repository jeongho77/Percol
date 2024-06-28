package Umc.Percol.service;

import Umc.Percol.entity.IncenseEntity;
import Umc.Percol.entity.UserEntity;
import Umc.Percol.repository.IncenseRepository;
import Umc.Percol.web.dto.IncenseDTO;
import Umc.Percol.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncenseService {
    private final IncenseRepository incenseRepository;


    public IncenseDTO mbtiIncense(Long id) {
        Optional<IncenseEntity> optionalincenseEntity = incenseRepository.findById(id);
        if (optionalincenseEntity.isPresent()) {
            //옵셔널을 entity로 변환
            IncenseEntity incenseEntity = optionalincenseEntity.get();
            return IncenseDTO.toIncenseDTO(incenseEntity);
        }else {
            return null;
        }

    }
}
