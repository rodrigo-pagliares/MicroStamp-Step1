package microstamp.step1.repository;

import microstamp.step1.data.SystemGoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SystemGoalEntityRepository extends JpaRepository<SystemGoalEntity, Long> {

    @Query(value = "SELECT * FROM system_goals WHERE project_id = ?1", nativeQuery = true)
    Optional<List<SystemGoalEntity>> findByProjectId(Long id);

}
