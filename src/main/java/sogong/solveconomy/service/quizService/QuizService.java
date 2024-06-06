package sogong.solveconomy.service.quizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogong.solveconomy.apiPayload.exception.handler.DictHandler;
import sogong.solveconomy.apiPayload.exception.handler.QuizHandler;
import sogong.solveconomy.apiPayload.exception.handler.UserHandler;
import sogong.solveconomy.domain.Dict;
import sogong.solveconomy.domain.Quiz;
import sogong.solveconomy.domain.Solve;
import sogong.solveconomy.domain.User;
import sogong.solveconomy.dto.quizDTO.QuizSolveRequestDTO;
import sogong.solveconomy.repository.DictRepository;
import sogong.solveconomy.repository.QuizRepository;
import sogong.solveconomy.repository.SolveRepository;
import sogong.solveconomy.repository.UserRepository;


import static sogong.solveconomy.apiPayload.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class QuizService {

    private final QuizRepository quizRepository;
    private final SolveRepository solveRepository;
    private final UserRepository userRepository;
    private final DictRepository dictRepository;

    public String confirmAnswer(String uid, QuizSolveRequestDTO dto) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        alreadySolved(user, dto.getQuizId());
        user.addSolvedQuiz(dto.getQuizId());

        Quiz quiz = quizRepository.findById(dto.getQuizId()).orElseThrow(() -> new QuizHandler(QUIZ_NOT_FOUND));
        Dict dict = dictRepository.findByKeyword(quiz.getAnswer()).orElseThrow(() -> new DictHandler(DICT_NOT_FOUND));

        if (quiz.getAnswer().equals(dto.getPick())) {
            Solve solve = Solve.builder()
                    .user(user)
                    .quiz(quiz)
                    .isCorrect(true)
                    .dict(dict).build();
            solveRepository.save(solve);
            return "맞았습니다";
        }else{
            Solve solve = Solve.builder()
                    .user(user)
                    .quiz(quiz)
                    .isCorrect(false)
                    .dict(dict).build();
            solveRepository.save(solve);
            return "틀렸습니다";
        }
    }


    public Integer alreadySolved(User user, Long quizId) {
        if (user.getSolvedQuiz()==null) {
            return null;
        }
        if (user.getSolvedQuiz().contains(quizId)) {
            throw new QuizHandler(QUIZ_ALREADY_SOLVED);
        }else{
            return null;
        }
    }

}
