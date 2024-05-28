package sogong.solveconomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogong.solveconomy.domain.Dict;

import java.util.List;
import java.util.Optional;

public interface DictRepository extends JpaRepository<Dict, Long> {
    List<Dict> findByKeywordContaining(String keyword);

    Optional<Dict> findByKeyword(String keyword);
}