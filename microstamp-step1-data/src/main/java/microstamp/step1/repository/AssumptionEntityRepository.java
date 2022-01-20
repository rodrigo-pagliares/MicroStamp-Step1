package microstamp.step1.repository;

import microstamp.step1.data.AssumptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssumptionEntityRepository extends JpaRepository<AssumptionEntity, Long> {

}
