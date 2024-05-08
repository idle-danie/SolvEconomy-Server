package sogong.solveconomy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sogong.solveconomy.apiPayload.ApiResponse;
import sogong.solveconomy.service.TestService;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public ApiResponse<String> test() {
        String s = testService.test();
        return ApiResponse.onSuccess(s);
    }

}
