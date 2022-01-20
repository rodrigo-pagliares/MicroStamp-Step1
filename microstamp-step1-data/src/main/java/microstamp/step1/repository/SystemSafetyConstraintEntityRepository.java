package microstamp.step1.repository;

import microstamp.step1.data.SystemSafetyConstraintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSafetyConstraintEntityRepository extends JpaRepository<SystemSafetyConstraintEntity, Long> {

}
