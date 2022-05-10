package microstamp.step1.repository;

import microstamp.step1.data.SystemSafetyConstraintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SystemSafetyConstraintEntityRepository extends JpaRepository<SystemSafetyConstraintEntity, Long> {

    @Query(value = "SELECT * FROM system_safety_constraint_entity as s join hazard_entity as h WHERE s.id = h.ssc_id AND project_id = ?1", nativeQuery = true)
    Optional<List<SystemSafetyConstraintEntity>> findByProjectId(Long id);

}
