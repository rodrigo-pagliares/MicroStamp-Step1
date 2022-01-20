package microstamp.step1.repository;

import microstamp.step1.data.LossEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LossEntityRepository extends JpaRepository<LossEntity, Long> {

}
