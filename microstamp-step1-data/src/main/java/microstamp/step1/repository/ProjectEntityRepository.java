package microstamp.step1.repository;

import microstamp.step1.data.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Long> {

    Optional<ProjectEntity> findByUrl(String url);

    @Query(value = "SELECT * FROM project_entity p WHERE p.user_id = ?1", nativeQuery = true)
    Optional<List<ProjectEntity>> findProjectsByUserId(long id);

    @Query(value = "SELECT * FROM project_entity p WHERE p.user_id = 3", nativeQuery = true)
    Optional<List<ProjectEntity>> findProjectsForGuests();

}
