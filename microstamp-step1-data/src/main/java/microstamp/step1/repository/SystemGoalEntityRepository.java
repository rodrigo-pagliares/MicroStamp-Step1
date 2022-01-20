package microstamp.step1.repository;

import microstamp.step1.data.SystemGoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemGoalEntityRepository extends JpaRepository<SystemGoalEntity, Long> {

}
