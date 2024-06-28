package Umc.Percol.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "MatchEntity")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfume_id")
    private PerfumeEntity perfumeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incense_id")
    private IncenseEntity incenseEntity;
}
