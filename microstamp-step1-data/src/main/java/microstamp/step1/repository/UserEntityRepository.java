package microstamp.step1.repository;

import microstamp.step1.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM users u WHERE u.username = ?1")
    UserEntity getUserByUsername(String username);

}
