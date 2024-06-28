package Umc.Percol.entity;

import Umc.Percol.entity.baseEntity.TimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Perfume")
public class PerfumeEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private String content;

    @Column
    private String price;

    @Column
    private String buyUrl;

    //mappedBy는 entity의 이름을 같게 해줘야함
    @OneToMany(mappedBy = "PerfumeEntity" , cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PerfumeEntity> PerfumeEntityList = new ArrayList<>();


}
