package microstamp.step1.repository;

import microstamp.step1.data.HazardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface HazardEntityRepository extends JpaRepository<HazardEntity, Long> {

    @Query(value = "SELECT * FROM hazards WHERE project_id = ?1", nativeQuery = true)
    Optional<List<HazardEntity>> findByProjectId(Long id);

    @Query(value = "SELECT * FROM hazards WHERE father_id = ?1", nativeQuery = true)
    Optional<List<HazardEntity>> findHazardChildren(Long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM hazard_loss WHERE hazard_id = ?1", nativeQuery = true)
    void deleteLossesAssociated(Long id);
}
