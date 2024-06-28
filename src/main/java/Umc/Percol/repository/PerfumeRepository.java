package Umc.Percol.repository;

import Umc.Percol.entity.PerfumeEntity;
import org.slf4j.MDC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfumeRepository extends JpaRepository<PerfumeEntity, Long> {

    List<PerfumeEntity> findByNameContaining(String keyword);
}
