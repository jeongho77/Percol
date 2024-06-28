package Umc.Percol.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WishIncense")
public class WishIncenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity; //어차피 프라이머리키가 들어가있음 UserEntity 타입형 잘보기

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incense_id")
    private IncenseEntity incenseEntity; //어차피 프라이머리키가 들어가있음 UserEntity 타입형 잘보기


}
