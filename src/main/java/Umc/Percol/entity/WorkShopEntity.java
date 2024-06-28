package Umc.Percol.entity;

import Umc.Percol.entity.baseEntity.TimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WorkShopEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String representative;

    @Column
    private String phone;

    @Column
    private String content;




}
