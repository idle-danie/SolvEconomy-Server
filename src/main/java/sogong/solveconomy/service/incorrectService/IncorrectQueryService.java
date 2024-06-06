package sogong.solveconomy.service.incorrectService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogong.solveconomy.apiPayload.exception.handler.DictHandler;
import sogong.solveconomy.apiPayload.exception.handler.QuizHandler;
import sogong.solveconomy.apiPayload.exception.handler.UserHandler;
import sogong.solveconomy.converter.IncorrectConverter;
import sogong.solveconomy.domain.Dict;
import sogong.solveconomy.domain.Quiz;
import sogong.solveconomy.domain.Solve;
import sogong.solveconomy.domain.User;
import sogong.solveconomy.dto.incorrectDTO.IncorrectDetailResponseDTO;
import sogong.solveconomy.dto.incorrectDTO.IncorrectResponseDTO;
import sogong.solveconomy.repository.DictRepository;
import sogong.solveconomy.repository.QuizRepository;
import sogong.solveconomy.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static sogong.solveconomy.apiPayload.code.status.ErrorStatus.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IncorrectQueryService {

    private final UserRepository userRepository;
    private final QuizRepository quizRepository;
    private final DictRepository dictRepository;

    public List<String> incorrectList(String uid) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        List<String> result = new ArrayList<>();
        List<Solve> solveList = user.getSolveList();
        for (Solve solve : solveList) {
            if (!solve.isCorrect()) {
                result.add(solve.getQuiz().getAnswer());
            }
        }
        return result;
    }

    public IncorrectDetailResponseDTO detail(String uid, String keyword) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        Quiz quiz = quizRepository.findByAnswer(keyword).orElseThrow(() -> new QuizHandler(QUIZ_NOT_FOUND));
        Dict dict = dictRepository.findByKeyword(keyword).orElseThrow(() -> new DictHandler(DICT_NOT_FOUND));
        return IncorrectConverter.toIncorrectDetailResponseDTO(quiz, dict);
    }



}
