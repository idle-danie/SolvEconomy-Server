package sogong.solveconomy.service.quizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogong.solveconomy.apiPayload.exception.handler.QuizHandler;
import sogong.solveconomy.apiPayload.exception.handler.UserHandler;
import sogong.solveconomy.converter.QuizConverter;
import sogong.solveconomy.domain.Quiz;
import sogong.solveconomy.domain.User;
import sogong.solveconomy.dto.quizDTO.QuizHomeResponseDTO;
import sogong.solveconomy.dto.quizDTO.QuizResponseDTO;
import sogong.solveconomy.repository.QuizRepository;
import sogong.solveconomy.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sogong.solveconomy.apiPayload.code.status.ErrorStatus.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class QuizQueryService {

    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    public QuizResponseDTO getQuiz(String uid) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        List<Quiz> quizList = quizRepository.findAll();
        List<Long> solvedQuiz = user.getSolvedQuiz();

        List<Quiz> unsolvedQuizzes = new ArrayList<>();
        for (Quiz quiz : quizList) {
            if (solvedQuiz == null || !solvedQuiz.contains(quiz.getId())) {
                unsolvedQuizzes.add(quiz);
            }
        }

        if (unsolvedQuizzes.isEmpty()) {
            throw new QuizHandler(QUIZ_ALL_SOLVED);
        }

        Collections.shuffle(unsolvedQuizzes); // Shuffle the list to randomize
        return QuizConverter.toQuizResponseDTO(unsolvedQuizzes.get(0));
    }

    public QuizHomeResponseDTO home(String uid) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        if (user.getSolvedQuiz() == null) {
            log.info("현재 유저가 푼 문제는 없습니다");
            return QuizConverter.toQuizHomeResponseDTO(user.getName(), 0);
        }
        return QuizConverter.toQuizHomeResponseDTO(user.getName(), user.getSolvedQuiz().size());
    }
}
