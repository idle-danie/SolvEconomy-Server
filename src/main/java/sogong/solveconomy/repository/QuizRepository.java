package sogong.solveconomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogong.solveconomy.domain.Quiz;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<Quiz> findByAnswer(String keyword);
}
