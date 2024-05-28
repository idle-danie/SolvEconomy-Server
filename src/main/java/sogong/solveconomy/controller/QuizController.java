package sogong.solveconomy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sogong.solveconomy.apiPayload.ApiResponse;
import sogong.solveconomy.dto.quizDTO.QuizHomeResponseDTO;
import sogong.solveconomy.dto.quizDTO.QuizResponseDTO;
import sogong.solveconomy.dto.quizDTO.QuizSolveRequestDTO;
import sogong.solveconomy.service.quizService.QuizQueryService;
import sogong.solveconomy.service.quizService.QuizService;

@RequestMapping("/quiz")
@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final QuizQueryService quizQueryService;

    @GetMapping("")
    public ApiResponse<QuizResponseDTO> getQuiz(@RequestParam(name = "uid") String uid) {
        QuizResponseDTO dto = quizQueryService.getQuiz(uid);
        return ApiResponse.onSuccess(dto);
    }

    @GetMapping("/home")
    public ApiResponse<QuizHomeResponseDTO> home(@RequestParam(name = "uid") String uid) {
        QuizHomeResponseDTO dto = quizQueryService.home(uid);
        return ApiResponse.onSuccess(dto);
    }

    //답 확인하기 && 문제 풀기
    @PostMapping("/solving")
    public ApiResponse<String> confirmAnswer(@RequestParam(name = "uid") String uid,
                                             @RequestBody QuizSolveRequestDTO dto) {
        String result = quizService.confirmAnswer(uid, dto);
        return ApiResponse.onSuccess(result);
    }
}
