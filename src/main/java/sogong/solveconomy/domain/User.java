package sogong.solveconomy.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import sogong.solveconomy.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Memo> memoList;

    private List<Long> solvedQuiz = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Solve> solveList;


    public void addSolvedQuiz(Long quizId) {
        if (this.solvedQuiz == null) {
            this.solvedQuiz = new ArrayList<>();
            this.solvedQuiz.add(quizId);
        }
        this.solvedQuiz.add(quizId);
    }

    public void initSolvedQuiz(List<Long> list) {
        this.solvedQuiz = list;
    }

}
