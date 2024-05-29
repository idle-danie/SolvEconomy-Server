package sogong.solveconomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogong.solveconomy.domain.Memo;
import sogong.solveconomy.domain.User;

import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    Optional<Memo> findByUserAndId(User user, Long id);

}
