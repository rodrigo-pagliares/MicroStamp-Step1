package microstamp.step1.repository;

import microstamp.step1.data.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Long> {

    Optional<ProjectEntity> findByUrl(String url);

}
