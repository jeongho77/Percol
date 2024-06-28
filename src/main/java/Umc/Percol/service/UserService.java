package Umc.Percol.service;

import Umc.Percol.entity.UserEntity;
import Umc.Percol.repository.UserRepository;
import Umc.Percol.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public UserDTO findUserById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity boardEntity = optionalUserEntity.get();
            return UserDTO.toUserDTO(boardEntity);
        }else {
            return null;
        }
    }
}
