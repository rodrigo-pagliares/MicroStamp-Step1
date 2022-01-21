package microstamp.step1.repository;

import microstamp.step1.data.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Long> {

    ProjectEntity findByExternalId(Long id);
}
