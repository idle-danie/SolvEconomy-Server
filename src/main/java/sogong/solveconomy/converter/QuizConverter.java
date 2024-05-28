package sogong.solveconomy.converter;

import sogong.solveconomy.domain.Quiz;
import sogong.solveconomy.dto.quizDTO.QuizHomeResponseDTO;
import sogong.solveconomy.dto.quizDTO.QuizResponseDTO;

public class QuizConverter {

    public static QuizResponseDTO toQuizResponseDTO(Quiz quiz) {
        return QuizResponseDTO.builder()
                .quizId(quiz.getId())
                .question(quiz.getQuestion())
                .answer(quiz.getAnswer())
                .c1(quiz.getC1())
                .c2(quiz.getC2())
                .c3(quiz.getC3())
                .c4(quiz.getC4())
                .build();
    }

    public static QuizHomeResponseDTO toQuizHomeResponseDTO(String username, int count) {
        return QuizHomeResponseDTO.builder()
                .username(username)
                .count(count)
                .build();
    }

}
