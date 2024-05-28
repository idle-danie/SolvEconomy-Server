package sogong.solveconomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogong.solveconomy.domain.Solve;
import sogong.solveconomy.domain.User;

import java.util.List;
import java.util.Optional;

public interface SolveRepository extends JpaRepository<Solve, Long> {

}
