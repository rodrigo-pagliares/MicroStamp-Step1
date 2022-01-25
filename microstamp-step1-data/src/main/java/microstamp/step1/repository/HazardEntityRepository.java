package microstamp.step1.repository;

import microstamp.step1.data.HazardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HazardEntityRepository extends JpaRepository<HazardEntity, Long> {

    @Query(value = "SELECT * FROM hazard_entity h WHERE h.ssc_id = ?1", nativeQuery = true)
    HazardEntity findBySscId(Long id);

    @Query(value = "SELECT * FROM hazard_entity WHERE project_id = ?1", nativeQuery = true)
    Optional<List<HazardEntity>> findByProjectId(Long id);
}
