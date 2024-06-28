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
@Table(name = "Incense")
public class IncenseEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String content;

    @OneToMany(mappedBy = "IncenseEntity" , cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WishIncenseEntity> WishIncenseEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "IncenseEntity" , cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MatchEntity> MatchEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "IncenseEntity" , cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HoldEntity> HoldEntityList = new ArrayList<>();



}
