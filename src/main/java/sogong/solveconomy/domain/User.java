package sogong.solveconomy.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import sogong.solveconomy.domain.common.BaseEntity;

import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ColumnDefault("0")
    private int quizCount;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Memo> memoList;
}
