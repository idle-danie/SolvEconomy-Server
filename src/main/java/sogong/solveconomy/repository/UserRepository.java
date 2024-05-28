package sogong.solveconomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogong.solveconomy.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUid(String uid);
}
