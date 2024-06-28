package Umc.Percol.entity;

import Umc.Percol.entity.baseEntity.TimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

@Entity
@Getter
@Setter
@Table(name = "WishPerfume")
public class WishPerfumeEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity; //어차피 프라이머리키가 들어가있음 UserEntity 타입형 잘보기

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfume_id")
    private PerfumeEntity perfumeEntity; //어차피 프라이머리키가 들어가있음 UserEntity 타입형 잘보기


}
