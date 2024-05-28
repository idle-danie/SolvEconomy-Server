package sogong.solveconomy.converter;

import sogong.solveconomy.domain.Dict;
import sogong.solveconomy.domain.Quiz;
import sogong.solveconomy.dto.incorrectDTO.IncorrectDetailResponseDTO;

public class IncorrectConverter {

    public static IncorrectDetailResponseDTO toIncorrectDetailResponseDTO(Quiz quiz, Dict dict) {
        return IncorrectDetailResponseDTO.builder()
                .keyword(quiz.getAnswer())
                .question(quiz.getQuestion())
                .c1(quiz.getC1())
                .c2(quiz.getC2())
                .c3(quiz.getC3())
                .c4(quiz.getC4())
                .definition(dict.getDefinition()).build();
    }
}
