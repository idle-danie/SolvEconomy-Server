package sogong.solveconomy.dto.quizDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseDTO {

    private Long quizId;
    private String question;
    private String answer;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
}
