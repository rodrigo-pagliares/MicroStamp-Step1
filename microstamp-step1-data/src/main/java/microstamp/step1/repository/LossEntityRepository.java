package microstamp.step1.repository;

import microstamp.step1.data.LossEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LossEntityRepository extends JpaRepository<LossEntity, Long> {

    @Query(value = "SELECT * FROM loss_entity WHERE project_id = ?1", nativeQuery = true)
    Optional<List<LossEntity>> findByProjectId(Long id);

}
