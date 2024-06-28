package Umc.Percol.entity;

import Umc.Percol.entity.baseEntity.TimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column
    private String provider;

    @Column
    private String providerId;

    @Column
    private String marketingAgree;

    //mappedBy는 entity의 이름을 같게 해줘야함
    @OneToMany(mappedBy = "userEntity" , cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WishPerfumeEntity> WishPerfumeEntityList = new ArrayList<>();

    //mappedBy는 entity의 이름을 같게 해줘야함
    @OneToMany(mappedBy = "userEntity" , cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WishIncenseEntity> WishIncenseEntityList = new ArrayList<>();


}
