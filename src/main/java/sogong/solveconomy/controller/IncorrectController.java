package sogong.solveconomy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sogong.solveconomy.apiPayload.ApiResponse;
import sogong.solveconomy.dto.incorrectDTO.IncorrectDetailResponseDTO;
import sogong.solveconomy.dto.incorrectDTO.IncorrectResponseDTO;
import sogong.solveconomy.service.incorrectService.IncorrectQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/incorrect")
public class IncorrectController {

    private final IncorrectQueryService incorrectQueryService;

    @GetMapping("")
    public ApiResponse<List<String>> incorrectList(@RequestParam(name = "uid") String uid) {
        return ApiResponse.onSuccess(incorrectQueryService.incorrectList(uid));
    }

    @GetMapping("/detail")
    public ApiResponse<IncorrectDetailResponseDTO> detail(@RequestParam(name = "uid") String uid,
                                      @RequestParam(name = "keyword") String keyword) {
        return ApiResponse.onSuccess(incorrectQueryService.detail(uid, keyword));
    }
}
