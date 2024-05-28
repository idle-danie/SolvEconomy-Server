package sogong.solveconomy.dto.quizDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizHomeResponseDTO {
    private String username;
    private int count;
}
